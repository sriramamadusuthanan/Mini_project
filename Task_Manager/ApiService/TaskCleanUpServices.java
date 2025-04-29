package com.Task_Manager.ApiService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.Task_Manager.EntityModels.TaskEntity;
import com.Task_Manager.Repo.TaskRepo;

@Service
public class TaskCleanUpServices {
	
	@Autowired
	private TaskRepo taskrepo;
	
	@Scheduled(cron="0 0 22 * * ?")
	public void deleteCompletedTask()
	{
		List<TaskEntity> completedTask=taskrepo.findByIsCompletedTrue();
		if(!completedTask.isEmpty())
		{
			taskrepo.deleteAll(completedTask);
		}
	}
}
