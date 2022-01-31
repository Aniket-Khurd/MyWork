package com.practice.codes;

public class EvenAndOddDigitsInNumber {
	
	public static void main(String[] args) {
		int number = 12340;
		int evenDigitCounts = 0;
		int oddDigitCounts = 0;
		while(number>0) {
			int digit = 0;
			digit = number%10;
			
			number = number/10;
			
			if(digit == 0) {
				continue;
			}else if(digit%2==0) {
				evenDigitCounts++;
			}else {
				oddDigitCounts++;
			}
		}
		System.out.println("Even digits in number: "+evenDigitCounts);
		System.out.println("Odd digits in number: "+oddDigitCounts);
	}

}
