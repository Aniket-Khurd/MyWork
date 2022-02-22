package com.oops.practice;

public class Developer extends Employee {
	
	float bonus;
	
	Developer(float salary, float bonus) {
		super(salary);
		this.bonus = bonus;
	}
	
	void work() {
		System.out.println("Developers develops software");
	}
	
}
