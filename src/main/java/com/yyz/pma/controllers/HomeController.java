package com.yyz.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyz.pma.dao.EmployeeRepository;
import com.yyz.pma.dao.ProjectRepository;
import com.yyz.pma.dto.ChartData;
import com.yyz.pma.dto.EmployeeProject;
import com.yyz.pma.entities.Employee;
import com.yyz.pma.entities.Project;



@Controller
public class HomeController {
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		List<Project> projectList = proRepo.findAll();
		model.addAttribute("projectList",projectList);
		
		
		List<EmployeeProject> employeeProjectCnt = empRepo.employeeProjects();
		model.addAttribute("employeeListCount", employeeProjectCnt);
		
		
		Map<String, Object> map = new HashMap<>();
		
		List<ChartData> projectData = proRepo.getProjectStatus();
		//convert projectData object into a json structure
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		//[{"value":1,"label":"COMPLETED"},{"value":2,"label":"INPROGRESS"},{"value":1,"label":"NOTSTARTED"}]
		model.addAttribute("projectStatusCnt", jsonString);
		
		return "main/home";
	}
}
