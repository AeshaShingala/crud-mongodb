package com.simformsolutions.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

	@Id
	private String id;
	private String name;
	private int salary;
	private long contact;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public Employee(String id, String name, int salary, long contact) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.contact = contact;
	}
	public Employee() {
		super();
	}
	
}
