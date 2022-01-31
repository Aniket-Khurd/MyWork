package com.practice.codes;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a String: ");
		
		String str = scan.nextLine();
		checkPalindrome(str);

	}
	
	public static void checkPalindrome(String input) {
		boolean result = true;
		int length = input.length();
		
		for(int i=0; i<length/2; i++) {
			if(input.charAt(i)!= input.charAt(length-i-1)) {
				result = false;
				break;
			}
		}
		
		System.out.println(input+" is palindrome = "+result);
		
	}

}
