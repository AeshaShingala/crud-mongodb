package com.simformsolutions.mongodb.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.simformsolutions.mongodb.entity.Employee;
import com.simformsolutions.mongodb.repository.EmployeeRepository;
import com.simformsolutions.mongodb.service.EmployeeService;

@Component
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> saveAll(List<Employee> employees) {
		return employeeRepository.saveAll(employees);
	}

	@Override
	public List<Employee> showAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(String id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee emp = employeeRepository.findById(employee.getId()).orElse(null);
		emp.setContact(employee.getContact());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		return employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployee(String id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Page<Employee> findEmployee(int pageNo, int pageSize,String sortBy) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize,Sort.by(Direction.ASC, sortBy));
		return  employeeRepository.findAll(pageable);
	}

	@Override
	public List<Employee> findByNameStarting(String regexp) {
		return employeeRepository.findByNameStartingWith(regexp);
	}

	@Override
	public List<Employee> findBySalaryBet(int salaryLT, int salaryGT) {
		return employeeRepository.findBySalaryBetween(salaryLT,salaryGT);
	}

}