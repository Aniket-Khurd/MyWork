package com.practice.codes;

import java.util.Scanner;

public class ArmstrongNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = input.nextInt();
//		isArmstrong(number);
		listOfArmstrongNumbers(number);
	}
	
	public static void isArmstrong(int number) {
		int num = number;
		int sum =0;
		int digit = 0;
		while(num>0) {
			digit = num%10;
			sum = sum+(digit*digit*digit);
			num = num/10;
		}
		
		if(sum==number) {
			System.out.println(number+" is Armstrong number");
		}else {
			System.out.println(number+" is not a Armstrong number");
		}
	}
	
	public static void listOfArmstrongNumbers(int number) {
		int num = number;
		
		int currentNumber =0;
		int count = 0;
		while(count<=num){
			currentNumber = count;
			int sum =0;
			int digit = 0;
			while(currentNumber>0) {
				digit = currentNumber%10;
				sum = sum + (digit*digit*digit);
				currentNumber = currentNumber/10;
			}
			if(sum==count) {
				System.out.print(count+", ");
				
			}
			count++;
		}
		System.out.println("these are the Armstrong numbers upto "+number);
	}
}
