package com.practice.codes;

public class reverseofInteger {

	public static void main(String[] args) {

		int num = 123456654;
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

	}

}
