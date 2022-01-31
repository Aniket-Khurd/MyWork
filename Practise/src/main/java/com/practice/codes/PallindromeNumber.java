package com.practice.codes;

public class PallindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 19091;
		int oldNum = num;
		System.out.println("Integer before reverse: "+num);
		//System.out.println(num%10);
		int reverseNum = 0;
		int temp= 0;

		while(num>0) {

			temp = num%10;
			reverseNum = reverseNum*10+temp;
			num = num/10;
		}
		System.out.println("Integer after reverse: "+reverseNum);
		
		int newNum = reverseNum;
		
		if(oldNum == newNum) {
			System.out.println("Given number is Pallindrome number: "+oldNum);
		}
		else {
			System.out.println("Given number is not a Pallindrome number: "+oldNum);
		}


	}

}


