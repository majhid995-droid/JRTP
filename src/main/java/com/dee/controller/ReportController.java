package com.dee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dee.request.SearchRequest;
import com.dee.service.ReportServiceImpl;

@Controller
public class ReportController {

	@Autowired
	private ReportServiceImpl service;
	@PostMapping("/searchInfo")
	public String searchResult(@ModelAttribute("search") SearchRequest request,Model model) 
	{
		System.out.println(request);
		init(model);
		return "index";
	}
	@GetMapping("/")
	public String indexPage(@ModelAttribute("search") SearchRequest searchInfo ,Model model)
	{
		init(model);
		return "index";
	}
	private void init(Model model) {
		model.addAttribute("plan", service.getAllPlanNames());
		model.addAttribute("status", service.getAllPlanStatus());
	}
	
}
