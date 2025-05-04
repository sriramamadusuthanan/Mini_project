package com.mailSender.ControllerClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mailSender.DTOClass.MailEntity;
import com.mailSender.ServiceClass.MailService;

@RestController
@RequestMapping("/mailsender")
public class MailController {

	@Autowired
	private MailService mailService;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendMails(@RequestBody MailEntity emails)
	{
		try {
			mailService.sendMail(emails);
			return ResponseEntity.ok("sent successful");
		}catch (Exception e)
		{
			return ResponseEntity.status(500).body("internal error"+e.getMessage());
		}
	}
}
