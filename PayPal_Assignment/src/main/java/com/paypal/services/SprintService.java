package com.paypal.services;

import java.util.List;


import com.paypal.DTO.SprintDTO;
import com.paypal.entity.Sprint;
import com.paypal.entity.Task;
import com.paypal.exceptation.SprintException;
import com.paypal.exceptation.TaskExceptation;



public interface SprintService {
	
	public Sprint createSprint(Sprint sprint)throws SprintException;
	public List<Task> addTaskToSprint(Integer taskID,Integer sprintID) throws TaskExceptation,SprintException;
	public List<Task> viewAllTaskInSprint(Integer sprintID) throws SprintException,TaskExceptation;
	
}