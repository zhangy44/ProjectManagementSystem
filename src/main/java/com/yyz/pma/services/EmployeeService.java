package com.yyz.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyz.pma.dao.EmployeeRepository;
import com.yyz.pma.dto.EmployeeProject;
import com.yyz.pma.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;

	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}

	public List<Employee> getAll() {
		return empRepo.findAll();
	}

	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}

	public Employee findByEmployeeId(long theId) {
		// TODO Auto-generated method stub
		return empRepo.findByEmployeeId(theId);
	}

	public void delete(Employee theEmp) {
		empRepo.delete(theEmp);

	}
}
