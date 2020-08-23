package com.fjx.search.controller;/*
 * @program: tensquare_parent
 * @Date: 2020-04-27 9:42
 * @Author: Jason
 * @Description:
 */


import com.fjx.search.pojo.Article;
import com.fjx.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {
    @Autowired
    private ArticleSearchService articleSearchService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        articleSearchService.add(article);
        return new Result(true, StatusCode.Ok,"操作成功");
    }

    @RequestMapping(value="/{key}/{page}/{size}",method = RequestMethod.GET)
    public Result findByKey(@PathVariable String key, @PathVariable int page,@PathVariable int size ){
        Page<Article> pageData =articleSearchService.findByKey(key,page,size);

        return new Result(true,StatusCode.Ok,"查询成功",new PageResult<Article>(pageData.getTotalElements(),
                pageData.getContent()));
    }
}
