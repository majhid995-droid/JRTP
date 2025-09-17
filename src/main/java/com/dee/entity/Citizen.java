package com.dee.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Citizen_Plans_Info")
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer citizen_Id;
	private String citizen_Name;
	private String gender;
	private String plan_Name;
	private String plan_Status;
	private LocalDate plane_Start_Date;
	private LocalDate plan_End_Date;
	private Double benefit_Amount;
	private String denial_Resason;
	private LocalDate termination_Date;
	private String termination_Reason;

}
