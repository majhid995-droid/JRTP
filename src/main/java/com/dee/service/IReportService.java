package com.dee.service;

import java.util.List;

import com.dee.entity.Citizen;
import com.dee.request.SearchRequest;

public interface IReportService 
{
	public List<String> getAllPlanNames();
	public List<String> getAllPlanStatus();
	public List<Citizen> search(SearchRequest request);
	public boolean exportExcel();
	public boolean exportPdf();
}
