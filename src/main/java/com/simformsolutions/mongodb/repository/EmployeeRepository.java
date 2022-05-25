package com.simformsolutions.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.simformsolutions.mongodb.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

	public List<Employee> findByNameStartingWith(String regexp);

	public List<Employee> findBySalaryBetween(int i, int j);

}
