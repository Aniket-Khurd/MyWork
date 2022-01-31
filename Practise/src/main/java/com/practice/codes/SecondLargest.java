package com.practice.codes;

public class SecondLargest {

	public static void main(String[] args) {
		int[] a = { 1, 10, 20, 15 };
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			if (temp < a[i]) {
				temp = a[i];
			} else {
				continue;
			}
		}
		System.out.println(temp);

		// to get second largest number
		int secondLargest = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != temp) {
				if (a[i] > secondLargest) {
					secondLargest = a[i];
				} else {
					continue;
				}
			}
		}
		System.out.println("Second largest number is: " + secondLargest);
	}

}
