package com.example.demo.task;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object> findById(String id){
		
		//SELECT文
		String query = "SELECT * FROM task WHERE id=?";
		
		//検索実行
		Map<String, Object> task = jdbcTemplate.queryForMap(query, id);
		
		return task;
	}

}
