package com.fjx.qa.client.impl;/*
 * @program: tensquare_parent
 * @Date: 2020-05-02 8:25
 * @Author: Jason
 * @Description:
 */


import com.fjx.qa.client.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

@Component
public class BaseClientImpl implements BaseClient {

    @Override
    public Result findById(String lableId) {

        return new Result(false, StatusCode.ERROR,"熔断器启动了");
    }
}
