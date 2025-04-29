package com.Task_Manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskManager {

	public static void main(String[] args) {
		SpringApplication.run(TaskManager.class, args);
	}

}
