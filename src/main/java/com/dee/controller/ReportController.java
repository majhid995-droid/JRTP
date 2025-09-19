package com.dee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dee.entity.Citizen;
import com.dee.request.SearchRequest;
import com.dee.service.ReportServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private ReportServiceImpl service;
	@PostMapping("/searchInfo")
	public String searchResult(@ModelAttribute("search") SearchRequest request,Model model) 
	{
		List<Citizen> citizenList=service.search(request);
		model.addAttribute("cList", citizenList);
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
	
	@GetMapping("/excel")
	public  void getExcelReport(HttpServletResponse response) throws Exception
	{
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xlsx");
		service.exportExcel(response);
	}
	
	@GetMapping("/pdf")
	public void getPdfReport(HttpServletResponse response) throws Exception
	{
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition","attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	
}
