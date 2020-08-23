package com.fjx.qa.controller;


import com.fjx.qa.client.BaseClient;
import com.fjx.qa.pojo.Problem;
import com.fjx.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

	@Autowired
	private ProblemService problemService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private BaseClient baseClient;


	@RequestMapping(value = "/label/{lableId}", method = RequestMethod.GET)
	public Result findLableById(@PathVariable String lableId){
		Result result = baseClient.findById(lableId);
		return  result;
	}

	/**
	 * 最新回答
	 * @return
	 */
	@RequestMapping(value = "/newlist/{label}/{page}/{size}",method= RequestMethod.GET)
	public Result newList(@PathVariable  String label , @PathVariable int page, @PathVariable int size){
		Page<Problem> pageData = problemService.newList(label, page, size);
		return new Result(true, StatusCode.Ok,"查询成功",new PageResult<Problem>(pageData.getTotalElements(),pageData.getContent()));
	}

	/**
	 * 热门回答
	 * @return
	 */
	@RequestMapping(value = "/hotlist/{label}/{page}/{size}",method= RequestMethod.GET)
	public Result hotList(@PathVariable String label , @PathVariable int page, @PathVariable int size){
		Page<Problem> pageData = problemService.hotList(label, page, size);
		return new Result(true, StatusCode.Ok,"查询成功",new PageResult<Problem>(pageData.getTotalElements(),pageData.getContent()));
	}


	/**
	 * 等待回答
	 * @return
	 */
	@RequestMapping(value = "/waitlist/{label}/{page}/{size}",method= RequestMethod.GET)
	public Result waitList(@PathVariable String label , @PathVariable int page, @PathVariable int size){
		Page<Problem> pageData = problemService.waitList(label, page, size);
		return new Result(true, StatusCode.Ok,"查询成功",new PageResult<Problem>(pageData.getTotalElements(),pageData.getContent()));
	}

	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true, StatusCode.Ok,"查询成功",problemService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true, StatusCode.Ok,"查询成功",problemService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
		return  new Result(true, StatusCode.Ok,"查询成功",  new PageResult<Problem>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap){
        return new Result(true, StatusCode.Ok,"查询成功",problemService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param problem
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Problem problem  ){
	String token=(String)request.getAttribute("user_claims");
		// 对令牌进行验证
		if (token == null || "".equals(token)) {
			return new Result(true, StatusCode.ACCESSERROR,"权限不足");
		}
		problemService.add(problem);
		return new Result(true, StatusCode.Ok,"增加成功");
	}
	
	/**
	 * 修改
	 * @param problem
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Problem problem, @PathVariable String id ){
		problem.setId(id);
		problemService.update(problem);		
		return new Result(true, StatusCode.Ok,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		problemService.deleteById(id);
		return new Result(true, StatusCode.Ok,"删除成功");
	}
	
}
