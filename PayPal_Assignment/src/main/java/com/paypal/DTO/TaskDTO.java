package com.paypal.DTO;

import java.time.LocalDate;

import ch.qos.logback.core.status.Status;


public class TaskDTO {
	private int taskid;
    private String taskdescription;
    private LocalDate taskstartDate;
    private LocalDate taskendDate;
    private LocalDate taskupdateDate;
    private UserDTO user;
    private Status status;

}
