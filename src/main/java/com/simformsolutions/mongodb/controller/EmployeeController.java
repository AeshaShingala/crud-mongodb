package com.simformsolutions.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simformsolutions.mongodb.entity.Employee;
import com.simformsolutions.mongodb.implementation.EmployeeServiceImplementation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceImplementation employeeServiceImplementation;
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeServiceImplementation.save(employee);
	}
	
	@PostMapping("/addemployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees)
	{
		return employeeServiceImplementation.saveAll(employees);
	}
	
	@GetMapping(value= {"/{pageNo}","/{pageNo}/{sortBy}"})
	public List<Employee> showEmployees(@PathVariable("pageNo") int pageNo, @PathVariable("sortBy") Optional<String> sortBy)
	{
		int pageSize=5;
		Page<Employee> page= employeeServiceImplementation.findEmployee(pageNo, pageSize,sortBy.orElse("name"));
		return page.getContent();
	}
	
	@GetMapping("/find/{id}")
	public Employee findEmployee(@PathVariable("id") String id)
	{
		return employeeServiceImplementation.findEmployeeById(id);
	}
	
	@PutMapping(value ="/update")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		return employeeServiceImplementation.updateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") String id )
	{
		employeeServiceImplementation.deleteEmployee(id);
		return "successfull";
	}
	
	@GetMapping("/start/{regexp}")
	public List<Employee> startWith(@PathVariable("regexp") String name)
	{
		return employeeServiceImplementation.findByNameStarting(name);
	}

	@GetMapping("/salaryrange/{lt}/{gt}")
	public List<Employee> salaryRange(@PathVariable("lt") int lt,@PathVariable("gt") int gt)
	{
		return employeeServiceImplementation.findBySalaryBet(lt, gt);
	}
}
