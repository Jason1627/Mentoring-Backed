package com.fjx.friend.dao;/*
 * @program: tensquare_parent
 * @Date: 2020-04-30 9:17
 * @Author: Jason
 * @Description:
 */

import com.fjx.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FriendDao extends JpaRepository<Friend, String> {

     Friend findByUseridAndFriendid(String userid, String friendid);

    @Modifying
    @Query(value = "UPDATE tb_friend SET islike=? WHERE userid=? and friend=?" ,nativeQuery = true)
    public void updateIsLike(String userid, String friendid, String islike);

    @Modifying
    @Query(value ="DELETE FROM tb_friend WHERE userid=? and friendid=?", nativeQuery = true)
    public void deleteFriend(String userid, String friendid);
}
