package com.paypal.services;

import java.util.List;

import com.paypal.DTO.UserDTO;
import com.paypal.entity.Task;
import com.paypal.entity.User;

import com.paypal.exceptation.TaskExceptation;
import com.paypal.exceptation.UserException;


public interface UserService {

	public User createUser(User user) throws UserException;
	//public User addTask( Integer UserID, Task task) throws UserException;
	public List<Task> viewAllTaskOfUser(Integer userID) throws UserException,TaskExceptation;
  
}
