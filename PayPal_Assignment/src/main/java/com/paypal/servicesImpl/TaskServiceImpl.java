package com.paypal.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.ennum.Status;
import com.paypal.entity.Task;
import com.paypal.entity.User;
import com.paypal.exceptation.TaskExceptation;
import com.paypal.exceptation.UserException;
import com.paypal.repositery.TaskRepo;
import com.paypal.repositery.UserRepo;
import com.paypal.services.TaskService;

@Service
public class TaskServiceImpl  implements TaskService{
	
	@Autowired
	private TaskRepo taskRepo;
	@Autowired
	private UserRepo userRepo;

	@Override
	public Task createTask(Task task) throws TaskExceptation {
		return taskRepo.save(task);
	}

	@Override
	public List<Task> addAssigneeToTask(Integer taskID, Integer userID) throws TaskExceptation, UserException {
		Optional<Task> opt=taskRepo.findById(taskID);
		if(opt.isEmpty())
		{
			throw new TaskExceptation("Task Not found with given task id");
		}
		
		Optional<User> opt2=userRepo.findById(userID);
		if(opt.isEmpty())
		{
			throw new TaskExceptation("Assignee Not found with given user id");
		}
		
		//opt2.get().setSprint(opt.get());
		opt.get().setAssignee(opt2.get());
		taskRepo.save(opt.get());
		User usr=opt2.get();
		usr.getTasklist().add(opt.get());
		
		User us=userRepo.save(usr);
		return us.getTasklist();
	}

	@Override
	public Task updateTaskStatus(Integer taskID, Status taskStatus) throws TaskExceptation {
		Optional<Task> opt=taskRepo.findById(taskID);
		if(opt.isEmpty())
		{
			throw new TaskExceptation("Task Not found with given task id");
		}
		opt.get().setTaskStatus(taskStatus);
		return taskRepo.save(opt.get());
	}

	

}
