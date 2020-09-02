package com.yyz.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yyz.pma.dao.EmployeeRepository;
import com.yyz.pma.dao.ProjectRepository;


@SpringBootApplication
public class ProjectManagementApplication {

	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository projRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

}
