package com.example.demo.domain.user.service;

import java.util.List;

import com.example.demo.domain.user.model.MTask;

public interface TaskService {
	
	/**タスク登録*/
	public void registerTaskOne(MTask task);
	
	/**タスク取得*/
	public List<MTask> getTasks();
	
	/**タスク取得(1件)*/
	public MTask getTaskOne(String taskId);
	
	/**タスク更新（1件）*/
	public void updateTaskOne(String taskId, String title, String description);
	
	/**タスク削除*/
	public void deleteTaskOne(String taskId);

}
