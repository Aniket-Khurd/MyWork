package com.oops.practice;

public class Tester extends Employee {
	float bonus;
	
	Tester(float salary, float bonus){
		super(salary);
		this.bonus = bonus;
	}
	
	void work() {
		System.out.println("Tester tests software");
	}
}
