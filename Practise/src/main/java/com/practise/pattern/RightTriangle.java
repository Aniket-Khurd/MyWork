package com.practise.pattern;

public class RightTriangle {
	
	public static void main(String[] args) {
		rightTrianglePattern(6);
		leftTrianglePattern(6);
	}
	
	public static void rightTrianglePattern(int rows) {
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public static void leftTrianglePattern(int rows) {
		
		for(int i=0; i<rows; i++) {
			
			for(int j=0; j<rows-i-1; j++) {
				System.out.print("  ");
			}
			
			for(int k=0; k<=i; k++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

}
