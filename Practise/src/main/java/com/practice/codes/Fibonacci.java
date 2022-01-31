package com.practice.codes;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter how much values you want to print: ");
		int value = scan.nextInt();
		
		int a=1, b=0;
		int c = 0, count =0;
		while(count<value) {
			System.out.print(c+" ");
			c = a+b;
			a=b;
			b=c;
			count++;
		}
		

	}

}
