package com.Task_Manager.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Task_Manager.EntityModels.UserEntity;

@Repository
public interface RepoInf extends JpaRepository<UserEntity, Integer>{

	//method to check the pin exist 
	boolean existsByPinid(String pin);
}
