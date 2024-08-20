package com.example.demo.application.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.demo.task.Task;
import com.example.demo.task.TaskRepository;

@Service
public class TaskApplicationService {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TaskRepository repository;
	
	/**タスクを1件取得する*/
	public Task getTask(String id) {
		//検索
		Map<String, Object> map = repository.findById(id);
		
		if (map == null) {
	        // IDに対応するタスクが存在しない場合、nullを返すか、例外を投げる
	        return null; // または例外を投げる
	    }
		
		//Mapから値を取得
		String taskId = (String) map.get("id");
		String title = (String) map.get("title");
		String description = (String) map.get("description");
		Date start_date = (Date) map.get("start_date");
		Date deadline = (Date) map.get("deadline");
		int priority = (int) map.get("priority");
		int status = (int) map.get("status");
		
		//taskクラスに値をセット
		Task task = new Task();
		task.setTaskId(taskId);
		task.setTitle(title);
		task.setDescription(description);
		task.setStartdate(start_date);
		task.setDeadline(deadline);
		task.setPriority(priority);
		task.setStatus(status);
		
		return task;
	}
	

}
