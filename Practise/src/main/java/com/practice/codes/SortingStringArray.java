package com.practice.codes;

import java.util.Arrays;

public class SortingStringArray {

	public static void main(String[] args) {
		
		String[] strArray = {"Green","Black","Yellow","Blue"};
		int sizeOfArray = strArray.length;
		
		comparisionSorting(strArray, sizeOfArray);
		System.out.println();
		usingSortMethod(strArray);

	}
	
	public static void comparisionSorting(String[] strArray, int sizeOfArray) {
		String temp = null;
		
		for(int i=0; i<sizeOfArray; i++) {
			for(int j=1; j<sizeOfArray-i; j++) {
				if(strArray[j-1].compareToIgnoreCase(strArray[j])>0) {
					temp = strArray[j-1];
					strArray[j-1] = strArray[j];
					strArray[j] = temp;
				}
			}
		}
		
		for(String s: strArray) {
			System.out.print(s+" ");
		}
	}
	
	public static void usingSortMethod(String[] strArray) {
		Arrays.sort(strArray);
		
		for(String s: strArray) {
			System.out.print(s+" ");
		}
	}

}
