package com.practice.codes;

public class StringReverse {

	public static void main(String[] args) {
		String oldString = "Testrig", newString = "";
		char a;
		
		System.out.println("String before reverse: "+oldString);
		
		for(int i=0; i<oldString.length(); i++) {
			a = oldString.charAt(i);
			newString = a + newString;
		}
		System.out.println("String after Reverse: "+newString);
		
		char[] b = oldString.toCharArray();
		System.out.println(b.length);
		for(int i = b.length-1; i>=0; i-- ) {
			
			System.out.print(b[i]);
		}

	}

}
