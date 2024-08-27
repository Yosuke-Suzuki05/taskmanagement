package com.example.demo.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.user.model.MTask;
import com.example.demo.domain.user.service.TaskService;
import com.example.demo.repository.TaskMapper;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskMapper mapper;
	
	
	/**タスク登録*/
	@Override
	public void registerTaskOne(MTask task) {
		
		// タスクIDを自動生成 (10桁)
		String taskId = generateTaskId();
		task.setTaskId(taskId); 
		mapper.insertOne(task);
	}
	
	private String generateTaskId() {
		// 現在の最大タスクIDを取得
		String maxTaskId = mapper.getMaxTaskId();
		if (maxTaskId == null) {
		    return "TASK000001";
		}
		// 最大タスクIDから数字部分を抽出してインクリメント
		int newId = Integer.parseInt(maxTaskId.substring(4).trim()) + 1;
		return String.format("TASK%06d", newId);
	}
	
	/**タスク取得*/
	@Override
	public List<MTask> getTasks(){
		return mapper.findMany();
	}
	
	/**タスク取得(1件)*/
	@Override
	public MTask getTaskOne(String taskId) {
		return mapper.findOne(taskId);
	}
	
	/**タスク更新*/
	@Override
	public void updateTaskOne(String taskId, String title, String description) {
		mapper.updateOne(taskId,title,description, null, null, 0, 0);	
	}
	
	/**タスク削除*/
	@Override
	public void deleteTaskOne(String taskId) {
		int count = mapper.deleteOne(taskId);
	}
    

}
