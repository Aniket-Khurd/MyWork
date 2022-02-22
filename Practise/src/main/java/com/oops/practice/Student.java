package com.oops.practice;

public class Student {

	int rollNumber;
	String name;
	int marks;

	Student() {
		this.rollNumber = 11;
		this.name = "Aniket";
		this.marks = 87;
	}

	Student(int rollNumber, String name, int marks) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.marks = marks;
	}
	
	Student(Student student)
	{
		this.rollNumber = student.rollNumber;
		this.name = student.name;
		this.marks = student.marks;
	}

	public static void main(String[] args) {
		//calling default constructor
		Student student1 = new Student();
		System.out.println(student1.rollNumber);
		System.out.println(student1.name);
		System.out.println(student1.marks);

		System.out.println();
		
		//calling constructor with parameterized values
		Student student2 = new Student(10, "Tony", 92);
		System.out.println(student2.rollNumber);
		System.out.println(student2.name);
		System.out.println(student2.marks);
		
		System.out.println();
		
		//calling constructor with object as parameter
		Student randomStudent = new Student(new Student(18, "Edward", 85));
		System.out.println(randomStudent.rollNumber);
		System.out.println(randomStudent.name);
		System.out.println(randomStudent.marks);
	}

}
