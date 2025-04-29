package com.Task_Manager.ApiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Task_Manager.ApiService.UserSwervices;
import com.Task_Manager.EntityModels.UserEntity;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserSwervices userservice;
	
	private static Logger logger=LoggerFactory.getLogger(UserController.class.getName());
	
	@PostMapping("/add")
	public ResponseEntity<String> postuser(@Valid @RequestBody  UserEntity user)
	{
		logger.info("Received the model from the service");
		try {
			
			userservice.adduser(user);
			logger.info("user added");
			return ResponseEntity.ok("User Added Successfully");
		}catch(Exception e)
		{
			logger.error("Unable to add the user");
			return ResponseEntity.status(500).body("Failed to add user");
		}
	}
}
