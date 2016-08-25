package com.mljr.demo.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mljr.demo.bean.User;

@RestController
@RequestMapping("/param/post")
public class PostParamController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(PostParamController.class);
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping(path = "/simple", method = RequestMethod.GET)
	public ModelAndView simple() {
		return view("/post_simple");
	}

	@RequestMapping(path = "/simple", method = RequestMethod.POST)
	public Object simple(String foo, String bar) {
		logger.info("dateParam foo = {},bar = {}", foo, bar);
		Map<String, String> data = Maps.newHashMap();
		data.put("foo", foo);
		data.put("bar", bar);
		return data;
	}

	@RequestMapping(path = "/vo", method = RequestMethod.GET)
	public ModelAndView vo() {
		return view("/post_vo");
	}

	@RequestMapping(path = "/vo", method = RequestMethod.POST)
	public Object vo(User vo) {
		logger.info("user = {}", vo);
		return vo;
	}

	@RequestMapping(path = "/array", method = RequestMethod.GET)
	public ModelAndView array() {
		return view("/post_array");
	}

	@RequestMapping(path = "/array", method = RequestMethod.POST)
	public Object vo(String[] color) {
		List<String> colorList = Lists.newArrayList(color);
		logger.info("colorList = {}", colorList);
		return colorList;
	}

	@RequestMapping(path = "/file", method = RequestMethod.GET)
	public ModelAndView file() {
		return view("/post_file");
	}

	@RequestMapping(path = "/file")
	public Object file(MultipartHttpServletRequest request, String foo, String bar) {
		Map<String, Object> data = Maps.newHashMap();
		Map<String, Object> imgMap = Maps.newHashMap();
		MultipartFile imgMultipartFile = request.getFile("img");
		imgMap.put("name", imgMultipartFile.getName());
		imgMap.put("contentType", imgMultipartFile.getContentType());
		imgMap.put("originalFilename", imgMultipartFile.getOriginalFilename());
		imgMap.put("size", imgMultipartFile.getSize());
		
		/*
		//save file
		File saveImgeFile = new File("/tmp/path/to/save/file");
		imgMultipartFile.transferTo(saveImgeFile);
		*/

		List<MultipartFile> fileList = request.getFiles("files");
		List<Map<String, Object>> fileInfoList = Lists.newArrayList();
		for (MultipartFile file : fileList) {
			Map<String, Object> fileMap = Maps.newHashMap();
			fileMap.put("name", file.getName());
			fileMap.put("contentType", file.getContentType());
			fileMap.put("originalFilename", file.getOriginalFilename());
			fileMap.put("size", file.getSize());
			fileInfoList.add(fileMap);
		}
		data.put("foo", foo);
		data.put("bar", bar);
		data.put("img", imgMap);
		data.put("fileList", fileInfoList);
		return data;
	}

}
