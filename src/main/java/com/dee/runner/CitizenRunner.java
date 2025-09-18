package com.dee.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dee.entity.Citizen;
import com.dee.repository.ICitizenRepository;

//@Component
public class CitizenRunner implements CommandLineRunner {

	@Autowired
	private ICitizenRepository repo;
	@Override
	public void run(String... args) throws Exception 
	{
		repo.deleteAll();

		Citizen c1 = new Citizen();
		c1.setCitizen_Name("John Doe");
		c1.setGender("Male");
		c1.setPlan_Name("Food");
		c1.setPlan_Status("Approved");
		c1.setPlane_Start_Date(LocalDate.of(2025,1,1));
		c1.setPlan_End_Date(LocalDate.of(2025,6,30));
		c1.setBenefit_Amount(1500.0);
		
		Citizen c2 = new Citizen();
		c2.setCitizen_Name("Alice Smith");
		c2.setGender("Female");
		c2.setPlan_Name("Food");
		c2.setPlan_Status("Denied");
		c2.setDenial_Resason("Income above limit");
		
		Citizen c3 = new Citizen();
		c3.setCitizen_Name("Robert Brown");
		c3.setGender("Male");
		c3.setPlan_Name("Food");
		c3.setPlan_Status("Terminated");
		c3.setPlane_Start_Date(LocalDate.of(2025, 2, 1));
		c3.setPlan_End_Date(LocalDate.of(2025, 5, 31));
		c3.setBenefit_Amount(1200.0);
		c3.setTermination_Date(LocalDate.of(2025, 4, 15));
		c3.setTermination_Reason("Fraudulent claim");
		
		Citizen c4 = new Citizen();
		c4.setCitizen_Name("Emma Wilson");
		c4.setGender("Female");
		c4.setPlan_Name("Cash");
		c4.setPlan_Status("Approved");
		c4.setPlane_Start_Date(LocalDate.of(2025, 3, 1));
		c4.setPlan_End_Date(LocalDate.of(2025, 8, 31));
		c4.setBenefit_Amount(2000.0);
		
		Citizen c5 = new Citizen();
		c5.setCitizen_Name("David Johnson");
		c5.setGender("Male");
		c5.setPlan_Name("Cash");
		c5.setPlan_Status("Denied");
		c5.setDenial_Resason("Missing documents");
		
		Citizen c6 = new Citizen();
		c6.setCitizen_Name("Sophia Miller");
		c6.setGender("Female");
		c6.setPlan_Name("Cash");
		c6.setPlan_Status("Terminated");
		c6.setPlane_Start_Date(LocalDate.of(2025, 1, 15));
		c6.setPlan_End_Date(LocalDate.of(2025, 4, 30));
		c6.setBenefit_Amount(1000.0);
		c6.setTermination_Date(LocalDate.of(2025, 3, 10));
		c6.setTermination_Reason("Policy violation");
		
		Citizen c7 = new Citizen();
		c7.setCitizen_Name("Liam Davis");
		c7.setGender("Male");
		c7.setPlan_Name("Medical");
		c7.setPlan_Status("Approved");
		c7.setPlane_Start_Date(LocalDate.of(2025, 2, 1));
		c7.setPlan_End_Date(LocalDate.of(2025, 12, 31));
		c7.setBenefit_Amount(5000.0);
		
		Citizen c8 = new Citizen();
		c8.setCitizen_Name("Olivia White");
		c8.setGender("Female");
		c8.setPlan_Name("Medical");
		c8.setPlan_Status("Denied");
		c8.setDenial_Resason("Pre-existing condition");
		
		Citizen c9 = new Citizen();
		c9.setCitizen_Name("James Anderson");
		c9.setGender("Male");
		c9.setPlan_Name("Medical");
		c9.setPlan_Status("Terminated");
		c9.setPlane_Start_Date(LocalDate.of(2025, 4, 1));
		c9.setPlan_End_Date(LocalDate.of(2025, 10, 31));
		c9.setBenefit_Amount(3500.0);
		c9.setTermination_Date(LocalDate.of(2025, 6, 15));
		c9.setTermination_Reason("Violation of treatment rules");
		
		Citizen c10 = new Citizen();
		c10.setCitizen_Name("Charlotte Moore");
		c10.setGender("Female");
		c10.setPlan_Name("Employment");
		c10.setPlan_Status("Approved");
		c10.setPlane_Start_Date(LocalDate.of(2025, 5, 1));
		c10.setPlan_End_Date(LocalDate.of(2026, 4, 30));
		c10.setBenefit_Amount(3000.0);
		
		Citizen c11 = new Citizen();
		c11.setCitizen_Name("William Harris");
		c11.setGender("Male");
		c11.setPlan_Name("Employment");
		c11.setPlan_Status("Denied");
		c11.setDenial_Resason("Not eligible");
		
		Citizen c12 = new Citizen();
		c12.setCitizen_Name("Amelia Clark");
		c12.setGender("Female");
		c12.setPlan_Name("Employment");
		c12.setPlan_Status("Terminated");
		c12.setPlane_Start_Date(LocalDate.of(2025, 3, 1));
		c12.setPlan_End_Date(LocalDate.of(2025, 9, 30));
		c12.setBenefit_Amount(2500.0);
		c12.setTermination_Date(LocalDate.of(2025, 7, 10));
		c12.setTermination_Reason("Resigned from job");
		
		Citizen c13 = new Citizen();
		c13.setCitizen_Name("Noah Martin");
		c13.setGender("Male");
		c13.setPlan_Name("Food");
		c13.setPlan_Status("Approved");
		c13.setPlane_Start_Date(LocalDate.of(2025, 7, 1));
		c13.setPlan_End_Date(LocalDate.of(2025, 12, 31));
		c13.setBenefit_Amount(1800.0);
		
		Citizen c14 = new Citizen();
		c14.setCitizen_Name("Isabella Lewis");
		c14.setGender("Female");
		c14.setPlan_Name("Food");
		c14.setPlan_Status("Denied");
		c14.setDenial_Resason("Incomplete application");
		
		Citizen c15 = new Citizen();
		c15.setCitizen_Name("Mason Hall");
		c15.setGender("Male");
		c15.setPlan_Name("Food");
		c15.setPlan_Status("Terminated");
		c15.setPlane_Start_Date(LocalDate.of(2025, 3, 1));
		c15.setPlan_End_Date(LocalDate.of(2025, 9, 30));
		c15.setBenefit_Amount(1400.0);
		c15.setTermination_Date(LocalDate.of(2025, 8, 15));
		c15.setTermination_Reason("Misuse of benefits");
		
		Citizen c16 = new Citizen();
		c16.setCitizen_Name("Mia Allen");
		c16.setGender("Female");
		c16.setPlan_Name("Cash");
		c16.setPlan_Status("Approved");
		c16.setPlane_Start_Date(LocalDate.of(2025, 6, 1));
		c16.setPlan_End_Date(LocalDate.of(2025, 12, 31));
		c16.setBenefit_Amount(2500.0);
		
		Citizen c17 = new Citizen();
		c17.setCitizen_Name("Lucas Young");
		c17.setGender("Male");
		c17.setPlan_Name("Cash");
		c17.setPlan_Status("Denied");
		c17.setDenial_Resason("Exceeded asset limit");
		
		Citizen c18 = new Citizen();
		c18.setCitizen_Name("Harper King");
		c18.setGender("Female");
		c18.setPlan_Name("Cash");
		c18.setPlan_Status("Terminated");
		c18.setPlane_Start_Date(LocalDate.of(2025, 1, 1));
		c18.setPlan_End_Date(LocalDate.of(2025, 7, 31));
		c18.setBenefit_Amount(1200.0);
		c18.setTermination_Date(LocalDate.of(2025, 6, 10));
		c18.setTermination_Reason("Moved out of state");
		
		Citizen c19 = new Citizen();
		c19.setCitizen_Name("Ethan Scott");
		c19.setGender("Male");
		c19.setPlan_Name("Medical");
		c19.setPlan_Status("Approved");
		c19.setPlane_Start_Date(LocalDate.of(2025, 5, 1));
		c19.setPlan_End_Date(LocalDate.of(2026, 4, 30));
		c19.setBenefit_Amount(4500.0);
		
		Citizen c20 = new Citizen();
		c20.setCitizen_Name("Ava Green");
		c20.setGender("Female");
		c20.setPlan_Name("Medical");
		c20.setPlan_Status("Denied");
		c20.setDenial_Resason("Insurance overlap");
		
		Citizen c21 = new Citizen();
		c21.setCitizen_Name("Benjamin Baker");
		c21.setGender("Male");
		c21.setPlan_Name("Medical");
		c21.setPlan_Status("Terminated");
		c21.setPlane_Start_Date(LocalDate.of(2025, 2, 15));
		c21.setPlan_End_Date(LocalDate.of(2025, 8, 31));
		c21.setBenefit_Amount(3000.0);
		c21.setTermination_Date(LocalDate.of(2025, 7, 5));
		c21.setTermination_Reason("Violation of treatment plan");
		
		Citizen c22 = new Citizen();
		c22.setCitizen_Name("Elijah Adams");
		c22.setGender("Male");
		c22.setPlan_Name("Employment");
		c22.setPlan_Status("Approved");
		c22.setPlane_Start_Date(LocalDate.of(2025, 8, 1));
		c22.setPlan_End_Date(LocalDate.of(2026, 7, 31));
		c22.setBenefit_Amount(3200.0);
		
		Citizen c23 = new Citizen();
		c23.setCitizen_Name("Emily Carter");
		c23.setGender("Female");
		c23.setPlan_Name("Employment");
		c23.setPlan_Status("Denied");
		c23.setDenial_Resason("No prior experience");
		
		Citizen c24 = new Citizen();
		c24.setCitizen_Name("Henry Ramirez");
		c24.setGender("Male");
		c24.setPlan_Name("Employment");
		c24.setPlan_Status("Terminated");
		c24.setPlane_Start_Date(LocalDate.of(2025, 4, 1));
		c24.setPlan_End_Date(LocalDate.of(2025, 10, 31));
		c24.setBenefit_Amount(2700.0);
		c24.setTermination_Date(LocalDate.of(2025, 9, 1));
		c24.setTermination_Reason("Left program voluntarily");
		
		List<Citizen> list=List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24);
		
		repo.saveAll(list);
	}

}
