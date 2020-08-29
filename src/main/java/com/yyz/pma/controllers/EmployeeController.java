package com.yyz.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyz.pma.dao.EmployeeRepository;
import com.yyz.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);
		return "new-employee";
	}
	
	@PostMapping("/save")
	public String createProject(Employee employee, Model model) {
		//this should handle saving to the database
		this.empRepo.save(employee);
		System.out.println(employee.toString());
		//to prevent duplicatesubmission
		return "redirect:/employees/new";
	}
}