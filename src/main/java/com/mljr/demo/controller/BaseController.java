package com.mljr.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mljr.demo.consts.Consts;

/**
 * @Description:控制器基类
 * @Author:Sine Chen
 * @Date:Mar 18, 2015 11:01:06 AM
 * @Copyright: All Rights Reserved. Copyright(c) 2015
 */
public class BaseController {
	public ModelAndView view(String view) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(view);
		return mv;
	}

	public ModelAndView view(String view, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(view);
		mv.addAllObjects(model.asMap());
		return mv;
	}

	/**
	 * AJAX请求成功
	 * @param msg
	 * @return
	 */
	public String ajaxSuccess() {
		return "{\"status\": " + Consts.STATUS_SUCCESS + "}";
	}

	/**
	 * 获取request对象
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
