package com.dee.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil 
{
	@Autowired
	private JavaMailSender mailSender;
	@Value("${spring.mail.username}")
	private String fromMail;
	public boolean sendMail(String subject,String body,String toMail,File file)
	{
		try {
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
		helper.setSubject(subject);
		helper.setText(body, true);
		helper.addAttachment("Plan_info", file);
		helper.setTo(toMail);
		
		mailSender.send(mimeMessage);
		file.delete();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
				
	}
}
