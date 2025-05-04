package com.mailSender.ServiceClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mailSender.DTOClass.MailEntity;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(MailEntity mail) throws MessagingException
	{
		for(String recipient:mail.getRecipients())
		{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setTo(recipient);
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getContent());
			
			if(mail.getImage()!=null & mail.getImage().length>0)
			{
				helper.addInline("inlineImage", new ByteArrayResource(mail.getImage()),"image/png");
			}
			
			mailSender.send(message);
		}
	}
}
