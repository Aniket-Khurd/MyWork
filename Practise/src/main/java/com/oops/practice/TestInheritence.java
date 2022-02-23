package com.oops.practice;

public class TestInheritence {
	
	public static void main(String[] args) {
		Developer dev = new Developer(15000, 5000);
		System.out.println("Salary of Developer is: "+(dev.salary+dev.bonus));
		dev.work();
		
		Tester test = new Tester(13000, 3000);
		System.out.println("Salary of Tester is: "+(test.salary+test.bonus));
		test.work();
		
		Employee employee = new Employee(12000);
		System.out.println(employee);
		System.out.println("hello");
	}

}
