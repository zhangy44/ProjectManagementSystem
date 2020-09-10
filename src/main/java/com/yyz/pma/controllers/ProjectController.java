package com.yyz.pma.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yyz.pma.dao.EmployeeRepository;
import com.yyz.pma.dao.ProjectRepository;
import com.yyz.pma.entities.Employee;
import com.yyz.pma.entities.Project;
import com.yyz.pma.services.EmployeeService;
import com.yyz.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		Iterable<Employee> employees = empService.getAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		
		proService.save(project);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects ";
		
	}
	
	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long theId,  Model model) {
		
		Project theProj = proService.findByProjectId(theId);
		
		List<Employee> selectedEmp = theProj.getEmployees();
		
		Set<Long> selectedEmpId = new HashSet<>();
		for(Employee emp : selectedEmp) {
			selectedEmpId.add(emp.getEmployeeId());
		}
		Iterable<Employee> employees = empService.getAll();
		
		model.addAttribute("project", theProj);
		model.addAttribute("allEmployees", employees);
		model.addAttribute("selectedEmpId", selectedEmpId);
		
		
		return "projects/new-project";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long theId, Model model) {
		Project theProj = proService.findByProjectId(theId);
		proService.delete(theProj);
		return "redirect:/projects";
	}
}
