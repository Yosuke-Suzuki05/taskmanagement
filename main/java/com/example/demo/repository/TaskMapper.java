package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.user.model.MTask;

@Mapper
public interface TaskMapper {
	
	/**タスク登録*/
	int insertOne(MTask task);
	
	/**タスク取得*/
	public List<MTask> findMany();
	
	/**タスク取得（1件)*/
	public MTask findOne(String taskId);

	/**タスクIDの最大値を取得する**/
	String getMaxTaskId();
	
	/**タスク更新（1件)*/
	public void updateOne(@Param("taskId")String taskId, 
			@Param("title") String title, 
			@Param("description") String description, 
			@Param("startDate") Date startDate, 
			@Param("deadline") Date deadline, 
			@Param("priority") int priority, 
			@Param("status") int status );
	
	/**タスク削除*/
	public int deleteOne(@Param("taskId")String taskId);
}
