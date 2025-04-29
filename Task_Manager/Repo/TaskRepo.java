package com.Task_Manager.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Task_Manager.EntityModels.TaskEntity;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity, Integer> {

	List<TaskEntity> findByIsCompletedTrue();
}
