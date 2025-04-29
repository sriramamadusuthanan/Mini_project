package com.Task_Manager.ApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Task_Manager.ApiService.AuthServices;
import com.Task_Manager.DTOs.LoginDTO;

import jakarta.validation.Valid;

@RestController
public class AuthController {

	@Autowired
	private AuthServices authServices;
	//later add logging 
	//private static Logger logger=LoggerFactory.getLogger(AuthController.class);
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDto)
	{
		try {
			boolean success= authServices.login(loginDto.getPin());
			if(success)
			{
				return ResponseEntity.ok("Login Successful !");
			}else
			{
				return ResponseEntity.status(401).body("Invalid Pin . Login Failed");
			}
		}catch(Exception e)
		{
			return ResponseEntity.status(500).body("Internal Server error"+e);
		}
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(@Valid @RequestBody LoginDTO loginDto)
	{
		authServices.logout(loginDto.getPin());
		return ResponseEntity.ok("Logout Successful");
	}
}
