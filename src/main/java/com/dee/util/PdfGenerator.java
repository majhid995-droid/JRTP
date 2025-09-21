package com.dee.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dee.entity.Citizen;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator 
{
	public boolean generate(HttpServletResponse response, List<Citizen> citizens,File file) throws Exception
	{
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
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
