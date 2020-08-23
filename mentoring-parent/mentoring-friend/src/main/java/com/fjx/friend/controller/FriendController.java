package com.fjx.friend.controller;/*
 * @program: tensquare_parent
 * @Date: 2020-04-29 19:08
 * @Author: Jason
 * @Description:
 */


import com.fjx.friend.service.FriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 添加好友或者非好友
     *
     * @param [friendid, type]
     * @Return: entity.Result
     */
    @RequestMapping(value = "/like/{friend}/{type}", method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid, @PathVariable String type) {
        // 验证是否登陆,并且获取当前登陆用户id
        Claims claims = (Claims) request.getAttribute("claims_user");
        if (claims == null) {
            return new Result(false, StatusCode.ACCESSERROR, "无权访问");
        }

        // 判断是添加好友,还是非还有
        if (type.equals("1")) {
            // 添加好友,首先判断是否为好友
            if (friendService.addFriend(claims.getId(), friendid) == 0) {
                return new Result(false, StatusCode.ACCESSERROR, "不能重复添加好友");
            }

        } else {
            // 不喜欢,向不喜欢列表中添加记录
            friendService.addNoFriend(claims.getId(), friendid);
        }

        return new Result(true, StatusCode.Ok, "添加成功");
    }

    /*
     * @Description: 删除好友
     * @param
     * @Return:
     * @Author: Jason
     * @Date: 2020-04-29 19:46
     */

    @RequestMapping(value = "/{friendid}", method = RequestMethod.DELETE)
    public Result remove(@PathVariable String friendid) {
        Claims claims = (Claims) request.getAttribute("claims_user");
        if (claims == null) {
            return new Result(false, StatusCode.ACCESSERROR, "无权访问");
        }
        friendService.deleteFriend(claims.getId(), friendid);
        return new Result(true, StatusCode.Ok, "删除成功");
    }

}
