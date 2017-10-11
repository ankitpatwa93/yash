package com.yash.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yash.model.Shop;

@Controller
public class AppController
{
		
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public  String  testMethod1(ModelMap model)
	{	
		model.addAttribute("message","Great! its working");
		return "hello";
	}
	
	@RequestMapping(value="/getJson",method=RequestMethod.GET)
	public @ResponseBody Shop  getJson()
	{		
		Shop shop=new Shop();
		shop.setId("1");
		shop.setName("amit");
		return shop;
	}
	
	@RequestMapping(value="/putJson",method=RequestMethod.POST,consumes="applicatoin/json")
	public @ResponseBody Shop  putJson(@RequestBody Shop shop)
	{
		System.out.println("I m in putJson");
		return shop;
	}

	
	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name+" Yes");

		return model;

	}
}
