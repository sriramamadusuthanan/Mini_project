package com.Task_Manager.ApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task_Manager.EntityModels.UserEntity;
import com.Task_Manager.Repo.RepoInf;

@Service
public class UserSwervices {

	
	@Autowired
	private RepoInf repoinfo;
	
	public void adduser(UserEntity user)
	{
		repoinfo.save(user);
	}
}
