package com.example.demo.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRegisterForm {
	
	@NotBlank(groups = ValidGroup1.class)
	@Size(min = 1, max = 100, groups = ValidGroup2.class)
    private String title;
	
	@Size(min = 0, max = 10000, groups = ValidGroup2.class)
    private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;
}
