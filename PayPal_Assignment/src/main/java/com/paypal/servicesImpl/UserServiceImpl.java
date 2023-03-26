package com.paypal.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.DTO.UserDTO;
import com.paypal.entity.Task;
import com.paypal.entity.User;
import com.paypal.exceptation.TaskExceptation;
import com.paypal.exceptation.UserException;

import com.paypal.repositery.UserRepo;
import com.paypal.services.UserService;

import springfox.documentation.swagger2.mappers.ModelMapper;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User createUser(User user) throws UserException {
		return userRepo.save(user);
	}
	
//	@Override
//	public User addTask(Integer UserID, Task task) throws UserException {
//		Optional<User> user =  userRepo.findById(UserID);
//		
//		if(user.isEmpty()) {
//			 throw new UserException("user not found with id " + UserID);
//		 }
//		User user1 = user.get();
//
//		user.get().getTasklist().add(task);
//				
//		return user1;
//	}
	
	
	
	
	@Override
	public List<Task> viewAllTaskOfUser(Integer userID) throws UserException, TaskExceptation {
		Optional<User> optional=userRepo.findById(userID);
		if(optional.isEmpty())
		{
			throw new UserException("User Not found with given id");
		}
		if(optional.get().getTasklist()==null)
		{
			throw new TaskExceptation("Task Not found for the particular user");
		}
		return optional.get().getTasklist();
	}




	
	

}
