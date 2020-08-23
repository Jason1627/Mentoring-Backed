package com.fjx.friend.service;/*
 * @program: tensquare_parent
 * @Date: 2020-04-29 19:07
 * @Author: Jason
 * @Description:
 */

import com.fjx.friend.client.UserClient;
import com.fjx.friend.dao.FriendDao;
import com.fjx.friend.dao.NoFriendDao;
import com.fjx.friend.pojo.Friend;
import com.fjx.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private UserClient userClient;

    @Autowired
    private NoFriendDao nofriendDao;

    public int addFriend(String userid, String friendid) {

        // 判断如果用户已经添加了这个好友，则不进行任何操作，返回为0
        if (friendDao.findByUseridAndFriendid(userid, friendid)!=null) {
            return 0;
        }

        // 直接添加好友,让好友表中的userid 到friendid 方向的type 改为 0
        Friend friend = new Friend();
        friend.setFriendid(friendid);
        friend.setUserid(userid);
        friend.setIslike("0");
        friendDao.save(friend);

        // 判断对方是否喜欢你,如果喜欢 islike  把双方的islike设置为1,且修改自己的关注数,对方的粉丝数目
        if (friendDao.findByUseridAndFriendid(friendid, userid) !=null) {
           // 将自己的islike 设置为1
            friendDao.updateIsLike(userid, friendid, "1");
            // 将好友的islike 设置为1
            friendDao.updateIsLike(friendid, userid, "1");
            // 增加自己的关注数
            userClient.incFollowcount(userid, 1);
            // 增加对方的粉丝数
            userClient.incFanscount(friendid, 1);
        }
        return 1;
    }

    public void addNoFriend(String userid, String friendid) {
        // 向不喜欢表中添加记录
        NoFriend nofriend = new NoFriend();
        nofriend.setFriendid(friendid);
        nofriend.setUserid(userid);
        nofriendDao.save(nofriend);
    }

    /**
     * 删除好友
     *
     * @param userid
     * @param friendid
     */
    public void deleteFriend(String userid, String friendid) {
        friendDao.deleteFriend(userid, friendid);

        friendDao.updateIsLike(friendid, userid, "0");
        //向不喜欢表中添加记录
        addNoFriend(userid, friendid);
        //减少自己的关注数
        userClient.incFollowcount(userid, -1);
        //减少对方的粉丝数
        userClient.incFanscount(friendid, -1);
    }

}
