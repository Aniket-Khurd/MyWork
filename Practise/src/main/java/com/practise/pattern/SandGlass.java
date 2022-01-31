package com.practise.pattern;

public class SandGlass {

	public static void main(String[] args) {

		sandGlassPattern(5);

	}

	public static void sandGlassPattern(int rows) {

		for (int i = 0; i <= rows - 1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}

			for (int k = 0; k < rows - i; k++) {
				System.out.print("* ");
			}

			System.out.println();
		}

		for (int l = 0; l <= rows - 1; l++) {

			for (int m = 0; m < rows - l - 1; m++) {
				System.out.print(" ");
			}

			for (int n = 0; n <= l; n++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
