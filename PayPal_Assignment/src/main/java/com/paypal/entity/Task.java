package com.paypal.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paypal.ennum.Status;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskId;
    
	@NotNull
	private String taskdescription;
	
    private LocalDate taskstartDate;
    
    private LocalDate taskendDate;
   
    private LocalDate taskupdateDate;
    
    @Embedded
    private Status taskStatus;
   // private String taskStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Sprint sprint;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private User assignee;
	
	

	
	
}