package com.mailSender.DTOClass;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MailEntity {
	
	private List<String> recipients;
	private String subject;
	private String content;
	private byte[] image;
	
	
}
