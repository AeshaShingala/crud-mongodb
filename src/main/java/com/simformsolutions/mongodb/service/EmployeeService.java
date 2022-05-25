package com.simformsolutions.mongodb.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.simformsolutions.mongodb.entity.Employee;

@Service
public interface EmployeeService {
	
	public Employee save(Employee employee);
	
	public List<Employee> saveAll(List<Employee> employees);

	public List<Employee> showAll();
	
	public Employee findEmployeeById(String id);
	
	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployee(String id);
	
	public Page<Employee> findEmployee(int pageNo, int pageSize,String sortBy);
	
	public List<Employee> findByNameStarting(String regexp);
	
	public List<Employee> findBySalaryBet(int salaryLT, int salaryGT);
}
