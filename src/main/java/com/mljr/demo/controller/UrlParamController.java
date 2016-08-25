package com.mljr.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@RestController
@RequestMapping("/param/url")
public class UrlParamController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UrlParamController.class);
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping("/simple")
	public Object simple(String foo, String bar) {
		logger.info("dateParam foo = {},bar = {}", foo, bar);
		Map<String, String> data = Maps.newHashMap();
		data.put("foo", foo);
		data.put("bar", bar);
		return data;
	}

	@RequestMapping("/path_param/{num}")
	public Object pathParam(@PathVariable("num") Integer num) {
		logger.info("dateParam num = {}", num);
		return num;
	}

	@RequestMapping("/array_param")
	public Object arrayParam(Integer[] id) {
		List<Integer> idList = Lists.newArrayList();
		for (Integer i : id) {
			idList.add(i);
		}
		logger.info("idList = {}", idList);
		return idList;
	}

	@RequestMapping("/array_param1")
	public Object arrayParam1(Integer[] id) {
		List<Integer> idList = Lists.newArrayList();
		for (Integer i : id) {
			idList.add(i);
		}
		logger.info("idList = {}", idList);
		return idList;
	}

	@RequestMapping("/date/{date}")
	public Object dateParam(@PathVariable("date") Date date) {
		logger.info("dateParam date = {}", df.format(date));
		return df.format(date);
	}

}
