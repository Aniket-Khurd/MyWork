package com.practice.codes;

import java.util.Scanner;

public class BarChart {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		
		for(int i=0; i<array.length; i++) {
			array[i]= scan.nextInt();
		}
		
		int max = 0;
		for(int i=0; i<array.length; i++) {
			if(max<array[i]) {
				max = array[i];
			}
		}
		
		for(int upper=max; upper>=1; upper--) {
			for(int i=0; i<array.length; i++) {
				if(array[i]>= upper) {
					System.out.print("*\t");
				}else {
					System.out.print("\t");
				}
			}
			
			System.out.println();
		}
		
	}
}
