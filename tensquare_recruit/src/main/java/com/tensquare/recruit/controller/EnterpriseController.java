package com.tensquare.recruit.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;

import entity.PageResult;
import entity.Result;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("enterprise")
public class EnterpriseController {

	@Autowired
	private EnterpriseService enterpriseService;

	@RequestMapping("search/hotlist")
	public Result hotList() {
		return Result.success(enterpriseService.hotList());
	}

	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return Result.success(enterpriseService.findAll());
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return Result.success(enterpriseService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map<String,Object> searchMap , @PathVariable int page, @PathVariable int size){
		Page<Enterprise> pageList = enterpriseService.findSearch(searchMap, page, size);
		return Result.success(new PageResult<Enterprise>(pageList.getTotalElements(), pageList.getContent()));
	}

	/**
	 * 根据条件查询
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public Result findSearch( @RequestBody Map<String,Object> searchMap){
		return Result.success(enterpriseService.findSearch(searchMap));
	}

	/**
	 * 增加
	 * @param enterprise
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Enterprise enterprise  ){
		enterpriseService.add(enterprise);
		return Result.success();
	}

	/**
	 * 修改
	 * @param enterprise
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Enterprise enterprise){
		enterpriseService.update(enterprise);		
		return Result.success();
	}

	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		enterpriseService.deleteById(id);
		return Result.success();
	}

}
