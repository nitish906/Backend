package com.paypal.servicesImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.entity.Sprint;
import com.paypal.entity.Task;
import com.paypal.exceptation.SprintException;
import com.paypal.exceptation.TaskExceptation;
import com.paypal.repositery.SprintRepo;
import com.paypal.repositery.TaskRepo;
import com.paypal.services.SprintService;


@Service
public class SprintServiceImpl implements SprintService {
	
	@Autowired
	private SprintRepo sprintRepo;
	
	@Autowired
	private TaskRepo taskRepo;
	

	@Override
	public Sprint createSprint(Sprint sprint) throws SprintException {
		return sprintRepo.save(sprint);
	}

	@Override
	public List<Task> addTaskToSprint(Integer taskID, Integer sprintID) throws TaskExceptation, SprintException {
		
		Optional<Sprint> opt=sprintRepo.findById(sprintID);
		
		if(opt.isEmpty())
		{
			throw new SprintException("No sprint found with given id");
		}
		
		 Optional<Task> opt2=taskRepo.findById(taskID);
			
			if(opt2.isEmpty())
			{
				throw new SprintException("No task found with given id");
			}
			opt2.get().setSprint(opt.get());
			taskRepo.save(opt2.get());
			Sprint spr=opt.get();
			spr.getTasklist().add(opt2.get());
			
			Sprint sprints=sprintRepo.save(spr);
			return sprints.getTasklist();
	}

	@Override
	public List<Task> viewAllTaskInSprint(Integer sprintID) throws SprintException, TaskExceptation {
		Optional<Sprint> opt=sprintRepo.findById(sprintID);
		
		if(opt.isEmpty())
		{
			throw new SprintException("Sprint Not found with given id");
		}
		if(opt.get().getTasklist()==null)
		{
			throw new TaskExceptation("Task Not found in the sprint");
		}
		return opt.get().getTasklist();
	}

}
