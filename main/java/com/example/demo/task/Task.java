package com.example.demo.task;

import java.util.Date;

import lombok.Data;

@Data
public class Task {
	private String taskId;
	private String title;
	private String description;
	private Date startdate;
	private Date deadline;
	private int priority;
	private int status;
}
