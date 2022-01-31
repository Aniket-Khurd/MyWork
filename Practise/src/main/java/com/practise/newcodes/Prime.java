package com.practise.newcodes;

import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		System.out.println(isPrime(number));
	}
	
	public static boolean isPrime(int number) {
		if(number<=1) {
			return false;
		}
		
		int c=2;
		while(c*c<=number) {
			if(number%c==0) {
				return false;
			}
			c++;
		}
		if(c*c>number) {
			return true;
		}
		return false;
	}

}
