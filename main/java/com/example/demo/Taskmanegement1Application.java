package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.repository") 
public class Taskmanegement1Application {

	public static void main(String[] args) {
		SpringApplication.run(Taskmanegement1Application.class, args);
	}

}
