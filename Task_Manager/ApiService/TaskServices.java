package com.Task_Manager.ApiService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task_Manager.EntityModels.TaskEntity;
import com.Task_Manager.Repo.TaskRepo;


@Service
public class TaskServices {

	@Autowired
	private TaskRepo taskrepo;
	
	public List<TaskEntity> getAllTask() {
		return taskrepo.findAll();
	}
	
	public void addTask(TaskEntity taskentity)
	{
		taskrepo.save(taskentity);
	}

	public boolean markTaskAsCompleted(int taskId)
	{
		Optional<TaskEntity> optionalTask=taskrepo.findById(taskId);
		if(optionalTask.isPresent())
		{
			TaskEntity task= taskrepo.findById(taskId).get();
			task.setCompleted(true);
			taskrepo.save(task);
			return true;
		}else
		{
			return false;
		}
	}

	
}
