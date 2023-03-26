package com.paypal.services;

import java.util.List;

import com.paypal.DTO.TaskDTO;
import com.paypal.ennum.Status;
import com.paypal.entity.Task;
import com.paypal.entity.User;
import com.paypal.exceptation.SprintException;
import com.paypal.exceptation.TaskExceptation;

import com.paypal.exceptation.UserException;


public interface TaskService {
	
	public Task createTask(Task task) throws TaskExceptation;
	public List<Task> addAssigneeToTask(Integer taskID,Integer userID) throws TaskExceptation,UserException;
	
	public Task updateTaskStatus(Integer taskID, Status taskStatus) throws TaskExceptation;

	
	//public Task updateTaskStatus(Integer taskID,String taskStatus) throws TaskExceptation;
		
}
