package com.oops.practice;

public class Employee {
	float salary;
	
	Employee(float salary){
		this.salary = salary;
	}
	
	void work() {
		System.out.println("All employees work as a team");
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + "]";
	}
}
