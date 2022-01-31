package com.practice.codes;

public class FactorialOFNumber {

	public static void main(String[] args) {
		int a = 4;
		if (a > 0) {
			factorial(a);
		} else {
			System.out.println("Please provide positive integer");
		}

	}

	public static void factorial(int number) {
		int num = number;
		int factorial = 1;
		while (num > 0) {
			factorial = factorial * num;
			num = num - 1;
		}

		System.out.println("Factorial of number " + number + " is: " + factorial);
	}

}
