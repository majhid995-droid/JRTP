package com.dee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dee.entity.Citizen;
import com.dee.repository.ICitizenRepository;
import com.dee.request.SearchRequest;
@Service
public class ReportServiceImpl implements IReportService
{

	@Autowired
	private ICitizenRepository repo;

	@Override
	public List<String> getAllPlanNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllPlanStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Citizen> search(SearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
