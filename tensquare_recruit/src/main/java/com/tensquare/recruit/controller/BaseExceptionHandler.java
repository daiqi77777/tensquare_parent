package com.tensquare.recruit.controller;

import entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result error(Exception e) {
		e.printStackTrace();
		return Result.error();
	}

}
