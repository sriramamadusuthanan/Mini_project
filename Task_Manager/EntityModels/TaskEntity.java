package com.Task_Manager.EntityModels;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class TaskEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int task_Id;
	
	@NotBlank
	private String task_Description;
	
	@Column(nullable=false, columnDefinition="BOOLEAN DEFAULT FALSE")
	private boolean isCompleted;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateandTime;
}
