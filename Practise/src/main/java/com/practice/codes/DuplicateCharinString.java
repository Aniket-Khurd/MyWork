package com.practice.codes;

public class DuplicateCharinString {

	public static void main(String[] args) {

		String check = "abcadhafr";
		int count=0;
		char[] b = check.toCharArray();
		
		for(int i=0; i<b.length; i++) {
			if(b[i]=='a') {
				count++;
			}
		}
		System.out.println("'a' repeated "+count+" times");

	}

}
