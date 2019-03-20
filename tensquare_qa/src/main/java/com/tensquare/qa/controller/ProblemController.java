package com.tensquare.qa.controller;

import com.tensquare.qa.client.BaseClient;
import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * 控制器层
 * 
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("problem")
public class ProblemController {

	@Autowired
	private ProblemService problemService;

	@Autowired
	private BaseClient baseClient;

	@GetMapping("label/{labelId}")
	public Result test(@PathVariable String labelId) {
		return baseClient.findById(labelId);
	}
	
	@GetMapping("newlist/{labelId}/{page}/{size}")
	public Result newList(@PathVariable String labelId,@PathVariable int page,@PathVariable int size) {
		Page<Problem> pageList = problemService.newList(labelId,page,size);
		return Result.success(new PageResult<>(pageList.getTotalElements(), pageList.getContent()));
	}
	
	@GetMapping("hotlist/{labelId}/{page}/{size}")
	public Result hotList(@PathVariable String labelId,@PathVariable int page,@PathVariable int size) {
		Page<Problem> pageList = problemService.hotList(labelId,page,size);
		return Result.success(new PageResult<>(pageList.getTotalElements(), pageList.getContent()));
	}
	
	@GetMapping("waitlist/{labelId}/{page}/{size}")
	public Result waitList(@PathVariable String labelId,@PathVariable int page,@PathVariable int size) {
		Page<Problem> pageList = problemService.waitList(labelId,page,size);
		return Result.success(new PageResult<>(pageList.getTotalElements(), pageList.getContent()));
	}

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return Result.success(problemService.findAll());
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return Result.success(problemService.findById(id));
	}

	/**
	 * 分页+多条件查询
	 * 
	 * @param searchMap 查询条件封装
	 * @param page      页码
	 * @param size      页大小
	 * @return 分页结果
	 */
	@RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
	public Result findSearch(@RequestBody Map<String, Object> searchMap, @PathVariable int page,
			@PathVariable int size) {
		Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
		return Result.success(new PageResult<>(pageList.getTotalElements(), pageList.getContent()));
	}

	/**
	 * 根据条件查询
	 * 
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Result findSearch(@RequestBody Map<String, Object> searchMap) {
		return Result.success(problemService.findSearch(searchMap));
	}

	/**
	 * 增加
	 * 
	 * @param problem
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result add(@RequestBody Problem problem) {
		problemService.add(problem);
		return Result.success();
	}

	/**
	 * 修改
	 * 
	 * @param problem
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@RequestBody Problem problem) {
		problemService.update(problem);
		return Result.success();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		problemService.deleteById(id);
		return Result.success();
	}
}