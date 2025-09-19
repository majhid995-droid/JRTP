package com.dee.service;

import java.awt.Color;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.dee.entity.Citizen;
import com.dee.repository.ICitizenRepository;
import com.dee.request.SearchRequest;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

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
	public boolean exportExcel( HttpServletResponse response) throws Exception {
		
		List<Citizen> citizens=repo.findAll();
		
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
		
		ServletOutputStream outStream=response.getOutputStream();
		workbook.write(outStream);
		workbook.close();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response)throws Exception {
		
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Font titleFont = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		titleFont.setSize(30);
		titleFont.setColor(BaseColor.BLUE);
				
		Paragraph p=new Paragraph("Citizen Plan Info",titleFont);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		p.setSpacingAfter(20f);
		document.add(p);
		PdfPTable table=new PdfPTable(11);
		table.addCell("Id");
		table.addCell("Name");
		table.addCell("Gender");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Benefit Amount");
		table.addCell("Denial Resason");
		table.addCell("Termination Date");
		table.addCell("Termination Reason");
		
		List<Citizen> citizens=repo.findAll();
		
		for(Citizen c: citizens) 
		{
			table.addCell(String.valueOf(c.getCitizen_Id()));
			table.addCell(c.getCitizen_Name());
			table.addCell(c.getGender());
			table.addCell(c.getPlan_Name());
			table.addCell(c.getPlan_Status());
			if(null !=c.getPlane_Start_Date()) {
				table.addCell(c.getPlane_Start_Date()+"");				
			}
			else {
				table.addCell("");
			}
			if(null !=c.getPlan_End_Date()) {
				table.addCell(c.getPlan_End_Date()+"");			
			}
			else {
				table.addCell("");
			}
			if(null !=c.getBenefit_Amount()) {
				table.addCell(c.getBenefit_Amount()+"");			
			}
			else {
				table.addCell("");
			}
			
			table.addCell(c.getDenial_Resason());
			
			if(null !=c.getTermination_Date()) {
				table.addCell(c.getPlane_Start_Date()+"");				
			}
			else {
				table.addCell("");
			}
			
			table.addCell(c.getTermination_Reason());
		}
		document.add(table);
		document.close();
		
		return true;
	}
	
	

}
