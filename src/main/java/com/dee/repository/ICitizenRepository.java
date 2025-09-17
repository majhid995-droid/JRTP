package com.dee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dee.entity.Citizen;

public interface ICitizenRepository extends JpaRepository<Citizen, Integer>
{
	@Query("SELECT DISTINCT(plan_Name) FROM Citizen")
	public List<String> getPlansName();
	@Query("select distinct(plan_Status) from Citizen ")
	public List<String> getPlanStatus();
}
