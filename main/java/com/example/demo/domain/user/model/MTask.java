package com.example.demo.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class MTask {
    private String taskId;
    private String userId;
    private String title;
    private String description;
    private Date startDate;
    private Date deadline;
    private Integer priority; // Integer 型に変更
    private int status;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDeleted;
	public void setPassword(Object object) {}

}