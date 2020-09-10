package com.yyz.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yyz.pma.dao.EmployeeRepository;
import com.yyz.pma.entities.Employee;
import com.yyz.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping
	public String displayEmployee(Model model) {
		List<Employee> employees = empService.getAll();
		model.addAttribute("employees", employees);
		return "employee/list-employees";
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {

		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);
		return "employee/new-employee";
	}

	@PostMapping("/save")
	public String createProject(Model model, @Valid Employee employee,  Errors error) {
		
		if(error.hasErrors()) {
			return "employees/new-employee";
		}
		// this should handle saving to the database
		this.empService.save(employee);
		
		// to prevent duplicatesubmission
		return "redirect:/employees/new";
	}
	
	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long theId, Model model) {
		
		Employee theEmp = empService.findByEmployeeId(theId);
		
		model.addAttribute("employee", theEmp);
		System.out.println("&&&&&&& here");
		
		return "employee/new-employee";
	}
	
	@GetMapping("delete")
	public String deleteEmployee(@RequestParam("id") long theId, Model model) {
		Employee theEmp = empService.findByEmployeeId(theId);
		empService.delete(theEmp);
		return "redirect:/employees";
	}
}
