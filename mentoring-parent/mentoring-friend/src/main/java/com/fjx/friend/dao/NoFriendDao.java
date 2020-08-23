package com.fjx.friend.dao;/*
 * @program: tensquare_parent
 * @Date: 2020-04-29 16:05
 * @Author: Jason
 * @Description:
 */


import com.fjx.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoFriendDao extends JpaRepository<NoFriend, String> {


}
