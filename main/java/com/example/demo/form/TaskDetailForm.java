package com.example.demo.form;

import java.util.Date;

import lombok.Data;

@Data
public class TaskDetailForm {
	private String taskId;
	private String title;
	private String description;
	private Date startDate;
	private Date deadline;
	private Integer priority;
	private Integer status;

}

