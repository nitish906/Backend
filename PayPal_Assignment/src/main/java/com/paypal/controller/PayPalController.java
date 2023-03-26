package com.paypal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.ennum.Status;
import com.paypal.entity.Sprint;
import com.paypal.entity.Task;
import com.paypal.entity.User;
import com.paypal.exceptation.SprintException;
import com.paypal.exceptation.TaskExceptation;
import com.paypal.exceptation.UserException;
import com.paypal.services.SprintService;
import com.paypal.services.TaskService;
import com.paypal.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PayPalController {
	

	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private SprintService sprintService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUserHandler(@RequestBody User user) throws UserException{
		User addUser=userService.createUser(user);
		return new ResponseEntity<User>(addUser,HttpStatus.CREATED);
	}
	
	@PostMapping("/createTask")
	public ResponseEntity<Task> createTaskHandler(@RequestBody Task task) throws TaskExceptation{
		Task addTask=taskService.createTask(task);
		return new ResponseEntity<Task>(addTask,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/createSprint")
	public ResponseEntity<Sprint> createSprintHandler(@RequestBody Sprint sprint) throws SprintException{
		Sprint addSprint=sprintService.createSprint(sprint);
		return new ResponseEntity<Sprint>(addSprint,HttpStatus.CREATED);
	}
	
	@PutMapping("/addAssigneeToTask/{taskid}/{userid}")
    public ResponseEntity<List<Task>>addAssigneeToTaskHandler(@PathVariable("taskid") Integer taskid,@PathVariable("userid") Integer userid) throws TaskExceptation, UserException{
    	
    	return new ResponseEntity<List<Task>>(taskService.addAssigneeToTask(taskid, userid), HttpStatus.OK);
    }
	
	@PutMapping("/addTaskToSprint/{taskid}/{sprintid}")
    public ResponseEntity<List<Task>>	addTaskToSprintHandler(@PathVariable("taskid") Integer taskid,@PathVariable("sprintid") Integer sprintid) throws TaskExceptation, SprintException{
    	
    	return new ResponseEntity<List<Task>>(sprintService.addTaskToSprint(taskid, sprintid), HttpStatus.OK);
    }
	
	@PutMapping("/updateTaskStatus/{taskid}/{taskstatus}")
    public ResponseEntity<Task> updateTaskStatusHandler(
    		@PathVariable("taskid") Integer taskid,@PathVariable("taskStatus") Status taskstatus) throws TaskExceptation {

        return new ResponseEntity<Task>(taskService.updateTaskStatus(taskid, taskstatus),HttpStatus.OK);
        		//updateTaskStatus(taskid, taskStatus),HttpStatus.OK);
    }
	
	
	@GetMapping("/viewAllTaskOfUser/{userid}")
	public ResponseEntity<List<Task>> viewAllTaskOfUserHandler(@PathVariable("userid") Integer userid) throws UserException, TaskExceptation{
		
        return new ResponseEntity<List<Task>>(userService.viewAllTaskOfUser(userid), HttpStatus.FOUND);

		
	}
	
	@GetMapping("/viewAllTaskInSprint/{sprintid}")
	public ResponseEntity<List<Task>> viewAllTaskInSprintHandler(@PathVariable("sprintid") Integer sprintid) throws SprintException, TaskExceptation{
		
        return new ResponseEntity<List<Task>>(sprintService.viewAllTaskInSprint(sprintid), HttpStatus.FOUND);

		
	}
	

}
