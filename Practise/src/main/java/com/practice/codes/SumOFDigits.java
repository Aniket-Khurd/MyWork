package com.practice.codes;

import java.util.Scanner;

public class SumOFDigits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = scan.nextInt();
		System.out.println("Given number: "+num);
		
		int sumOFDigits = 0;
		int temp= 0;

		while(num>0) {

			temp = num%10;
			sumOFDigits = sumOFDigits+temp;
			num = num/10;
		}
		System.out.println("Sum of digits of given number : "+sumOFDigits);

	}

}


