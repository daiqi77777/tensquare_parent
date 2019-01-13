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

import com.tensquare.article.pojo.Channel;
import com.tensquare.article.service.ChannelService;

import entity.PageResult;
import entity.Result;

/**
 * 控制器层
 * 
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/channel")
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return Result.success(channelService.findAll());
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return Result.success(channelService.findById(id));
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
		Page<Channel> pageList = channelService.findSearch(searchMap, page, size);
		return Result.success(new PageResult<Channel>(pageList.getTotalElements(), pageList.getContent()));
	}

	/**
	 * 根据条件查询
	 * 
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Result findSearch(@RequestBody Map<String, Object> searchMap) {
		return Result.success(channelService.findSearch(searchMap));
	}

	/**
	 * 增加
	 * 
	 * @param channel
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result add(@RequestBody Channel channel) {
		channelService.add(channel);
		return Result.success();
	}

	/**
	 * 修改
	 * 
	 * @param channel
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@RequestBody Channel channel) {
		channelService.update(channel);
		return Result.success();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		channelService.deleteById(id);
		return Result.success();
	}
}
