package com.fjx.qa.client;/*
 * @program: tensquare_parent
 * @Date: 2020-04-29 9:38
 * @Author: Jason
 * @Description:
 */

import com.fjx.qa.client.impl.BaseClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mentoring-base",fallback = BaseClientImpl.class)
public interface BaseClient {

    @RequestMapping(value = "/lable/{lableId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("lableId") String lableId);
}
