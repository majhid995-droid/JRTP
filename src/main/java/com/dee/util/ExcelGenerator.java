package com.dee.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.dee.entity.Citizen;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator 
{
	public boolean generate(HttpServletResponse response,List<Citizen> citizens,File file) throws Exception
	{
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet=workbook.createSheet("Citizen Plan");
		Row headerRow=sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("End Date");
		headerRow.createCell(7).setCellValue("Benefit Amount");
		headerRow.createCell(8).setCellValue("Denial Resason");
		headerRow.createCell(9).setCellValue("Termination Date");
		headerRow.createCell(10).setCellValue("Termination Reason");
		
		int rowNum=1;
		for(Citizen c:citizens)
		{
			Row row=sheet.createRow(rowNum);
			row.createCell(0).setCellValue(c.getCitizen_Id());
			row.createCell(1).setCellValue(c.getCitizen_Name());
			row.createCell(2).setCellValue(c.getGender());
			row.createCell(3).setCellValue(c.getPlan_Name());
			row.createCell(4).setCellValue(c.getPlan_Status());
			
			if(null!=c.getPlane_Start_Date()) {
				row.createCell(5).setCellValue(c.getPlane_Start_Date()+"");				
			}
			else {
				row.createCell(5).setCellValue("N/A");								
			}
			if(null!=c.getPlan_End_Date()) {				
				row.createCell(6).setCellValue(c.getPlan_End_Date()+"");
			}
			else {
				row.createCell(6).setCellValue("N/A");								
			}
			if(null!=c.getBenefit_Amount()) {
				row.createCell(7).setCellValue(c.getBenefit_Amount());				
			}
			else {
				row.createCell(7).setCellValue("");
			}
			row.createCell(8).setCellValue(c.getDenial_Resason());
			if(null!=c.getTermination_Date()) {				
				row.createCell(9).setCellValue(c.getTermination_Date()+"");
			}
			else {
				row.createCell(9).setCellValue("N/A");								
			}
			row.createCell(10).setCellValue(c.getTermination_Reason());
			
			rowNum++;
		}
		
		FileOutputStream fout=new FileOutputStream(file);
		workbook.write(fout);
		fout.close();
		
		ServletOutputStream outStream=response.getOutputStream();
		workbook.write(outStream);
		workbook.close();
		return true;
	}
}
