package com.tensquare.article.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tensquare.article.pojo.Column;
import com.tensquare.article.service.ColumnService;

import entity.PageResult;
import entity.Result;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/column")
public class ColumnController {

	@Autowired
	private ColumnService columnService;


	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return Result.success(columnService.findAll());
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return Result.success(columnService.findById(id));
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
		Page<Column> pageList = columnService.findSearch(searchMap, page, size);
		return Result.success(new PageResult<Column>(pageList.getTotalElements(),pageList.getContent()));
	}

	/**
	 * 根据条件查询
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public Result findSearch( @RequestBody Map<String,Object> searchMap){
		return Result.success(columnService.findSearch(searchMap));
	}

	/**
	 * 增加
	 * @param column
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Column column){
		columnService.add(column);
		return Result.success();
	}

	/**
	 * 修改
	 * @param column
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Column column){
		columnService.update(column);		
		return Result.success();
	}

	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		columnService.deleteById(id);
		return Result.success();
	}
}