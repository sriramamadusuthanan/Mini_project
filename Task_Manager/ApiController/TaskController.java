package com.Task_Manager.ApiController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Task_Manager.ApiService.AuthServices;
import com.Task_Manager.ApiService.TaskServices;
import com.Task_Manager.EntityModels.TaskEntity;

import jakarta.validation.Valid;

@RestController
public class TaskController {
	
	@Autowired
	private TaskServices taskService;
	
	@Autowired
	private AuthServices authService;
	
	private static Logger logger= LoggerFactory.getLogger(TaskController.class);
	
	@GetMapping("/gettask")
	public List<TaskEntity> getTasks()
	{
		return taskService.getAllTask();
	}
	
	@PostMapping("/addtask")
	public ResponseEntity<String> addTasks(@Valid @RequestBody TaskEntity taskentity ,@RequestParam String pin )
	{
		try {
			if(authService.isLoggedIn(pin))
			{
				taskService.addTask(taskentity);
				logger.info("task added successfully");
				return ResponseEntity.ok("Task added successfully");
			}
				logger.info("Log in to add Task");
				return ResponseEntity.status(401).body("LogIn to Add Task");
		
			
		}catch(Exception e)
		{
			logger.error("unable to the Task"+ e);
			return ResponseEntity.status(500).body("unable to add user"+ e);
		}
	}
	
	@PostMapping("/completed")
	public ResponseEntity<String> deleteTasks(@Valid @RequestParam int taskId ,@RequestParam String pin )
	{
		try {
			if(authService.isLoggedIn(pin))
			{
				taskService.markTaskAsCompleted(taskId);
				logger.info("task completed successfully");
				return ResponseEntity.ok("Task completed successfully");
			}
				logger.info("Log in to completed Task");
				return ResponseEntity.status(401).body("LogIn to completed Task");
		
			
		}catch(Exception e)
		{
			logger.error("unable to delete the Task"+ e);
			return ResponseEntity.status(500).body("unable to delete user"+ e);
		}
	}

}
