package com.Task_Manager.ApiService;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Task_Manager.Repo.RepoInf;
// creating a manual Session Storage
@Service
public class AuthServices {

	@Autowired
	private RepoInf repoInfo;
	
	 //manual session tracking 
	private Set<String> loggedInPins=new HashSet<>();
	
	//if the pin exist in DB it will add to the set
	public boolean login(String Pin)
	{
		boolean exist=repoInfo.existsByPinid(Pin);
		
		if(exist)
		{
			loggedInPins.add(Pin);
		}
		return exist;
	}
	
	// it will remove from the set when you logout
	public void logout(String pin)
	{
		loggedInPins.remove(pin);
	}
	
	//to check where loggedIn
	public boolean isLoggedIn(String pin)
	{
		return loggedInPins.contains(pin);
	}
}
