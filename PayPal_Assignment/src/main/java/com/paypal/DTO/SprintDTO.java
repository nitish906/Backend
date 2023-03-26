package com.paypal.DTO;

import java.time.LocalDate;
import java.util.List;


public class SprintDTO {
	
	private int sprintid;
    private String sprintdescription;
    private LocalDate sprintstartDate;
    private LocalDate sprintdueDate;
    private List<TaskDTO> tasks;

}
