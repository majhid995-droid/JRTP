package com.dee.service;

import java.util.List;

import com.dee.entity.Citizen;
import com.dee.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface IReportService 
{
	public List<String> getAllPlanNames();
	public List<String> getAllPlanStatus();
	public List<Citizen> search(SearchRequest request);
	public boolean exportExcel(HttpServletResponse response)throws Exception;
	public boolean exportPdf(HttpServletResponse response)throws Exception;
}
