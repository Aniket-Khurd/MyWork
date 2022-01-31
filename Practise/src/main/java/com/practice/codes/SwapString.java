package com.practice.codes;

public class SwapString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Aniket";  
		String b = "Khurd";  
		System.out.println("Before swap: " + a + " " + b);  
		a = a + b;  
		b = a.substring(0, a.length() - b.length());  
		a = a.substring(b.length());  
		System.out.println("After : " + a + " " + b);  

	}

}
