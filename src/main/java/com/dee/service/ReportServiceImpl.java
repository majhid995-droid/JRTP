package com.dee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
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
	@Cacheable(value = "plan")
	public List<String> getAllPlanNames() {
		List<String> planName=repo.getPlansName();
		return planName;
	}

	@Override
	@Cacheable(value = "status")
	public List<String> getAllPlanStatus() {
		List<String> status=repo.getPlanStatus();
		return status;
	}

	@Override
	public List<Citizen> search(SearchRequest request) 
	{
		Citizen czen=new Citizen();
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			czen.setPlan_Name(request.getPlanName());
		}
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			czen.setPlan_Status(request.getPlanStatus());
		}
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			czen.setGender(request.getGender());
		}
		if(null!=request.getStartDate()) {
			czen.setPlane_Start_Date(request.getStartDate());
		}
		if(null!=request.getEndDate()) 
		{
			czen.setPlan_End_Date(request.getEndDate());
		}
		
		
		List<Citizen> citizens=repo.findAll(Example.of(czen));		
		
		return citizens;
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
