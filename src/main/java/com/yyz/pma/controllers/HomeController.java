package com.yyz.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yyz.pma.dao.EmployeeRepository;
import com.yyz.pma.dao.ProjectRepository;
import com.yyz.pma.entities.Employee;
import com.yyz.pma.entities.Project;



@Controller
public class HomeController {
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projectList = proRepo.findAll();
		List<Employee> employeeList = empRepo.findAll();
		model.addAttribute("projectList",projectList);
		model.addAttribute("employeeList", employeeList);
		return "main/home";
	}
}
