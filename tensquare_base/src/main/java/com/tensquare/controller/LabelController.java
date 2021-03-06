package com.tensquare.controller;

import com.tensquare.pojo.Label;
import com.tensquare.service.LabelService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("label")
public class LabelController {

	@Autowired
	private LabelService labelService;

	@GetMapping("")
	public Result findAll() {
		return Result.success(labelService.findAll());
	}

	@GetMapping("{labelId}")
	public Result findById(@PathVariable String labelId) {
		labelService.findById(labelId);
		return Result.success();
	}

	@PostMapping("")
	public Result save(@RequestBody Label label) {
		labelService.save(label);
		return Result.success();
	}

	@PutMapping()
	public Result update(@RequestBody Label label) {
		labelService.update(label);
		return Result.success();
	}

	@DeleteMapping("{labelId}")
	public Result deleteById(@PathVariable String labelId) {
		labelService.deleteById(labelId);
		return Result.success();
	}

	@PostMapping("search")
	public Result search(@RequestBody Label label) {
		return Result.success(labelService.findSearch(label));
	}
	
	@PostMapping("search/{page}/{size}")
	public Result searchPage(@RequestBody Label label,@PathVariable int page,@PathVariable int size) {
		Page<Label> searchPage = labelService.searchPage(label,page,size);
		return Result.success(new PageResult<>(searchPage.getTotalElements(),searchPage.getContent()));
	}
}
