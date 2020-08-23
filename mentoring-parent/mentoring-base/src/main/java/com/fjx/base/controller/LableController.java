package com.fjx.base.controller;
/**
 * @program: tensquare_parent
 * @Date: 2020-04-14 10:13
 * @Author: Jason
 * @Description:
 */


import com.fjx.base.pojo.Label;
import com.fjx.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RefreshScope
@RequestMapping("/lable")
public class LableController {

    @Autowired
    private LabelService labelService;

    //@Autowired
    //private HttpServletRequest request;

    @ApiOperation(value = "查询所有的标签")
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        //String header = request.getHeader("Authorization");
        //System.out.println(header);

        return new Result(true, StatusCode.Ok, "查询成功", labelService.findAll());
    }

    @ApiOperation(value = "根据标签ID 查询标签")
    @RequestMapping(value = "{lableId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String lableId) {
        return new Result(true, StatusCode.Ok, "查询成功", labelService.findById(lableId));
    }

    @ApiOperation(value = "根据条件查询标签")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label) {
        List<Label> list = labelService.findSearch(label);
        return new Result(true, StatusCode.Ok, "查询成功", list);
    }

    @ApiOperation(value = "标签分页查询")
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label, @PathVariable int page, @PathVariable int size) {
        Page<Label> pageData = labelService.pageQuery(label, page, size);
        return new Result(true, StatusCode.Ok, "查询成功", new PageResult<Label>(pageData.getTotalElements(),
                pageData.getContent()));
    }

    @ApiOperation(value = "添加标签")
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.Ok, "添加成功");
    }

    @ApiOperation(value = "根据ID 修改标签")
    @RequestMapping(value = "{lableId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String lableId, @RequestBody Label label) {
        label.setId(lableId);
        labelService.update(label);
        return new Result(true, StatusCode.Ok, "修改成功");
    }

    @ApiOperation(value = "根据标签ID 删除标签")
    @RequestMapping(value = "{lableId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String lableId) {
        labelService.deleteById(lableId);
        return new Result(true, StatusCode.Ok, "删除成功");
    }

}
