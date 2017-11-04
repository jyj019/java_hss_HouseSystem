package com.jyj019.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 *
 *@Author jyj019
 **/
@ControllerAdvice
public class MyExceptionAdvice {

	@ExceptionHandler({ Exception.class })
	public String toException(Model model) {
		return "error/hint";
	}
}
