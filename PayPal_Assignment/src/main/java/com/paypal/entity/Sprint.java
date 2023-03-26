package com.paypal.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sprintId;
	
	@NotNull
	private String sprintDescription;
	
    private LocalDate sprintStartDate;
    
    private LocalDate sprintDueDate;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "sprint")
	private List<Task> tasklist=new ArrayList<Task>();
	
}