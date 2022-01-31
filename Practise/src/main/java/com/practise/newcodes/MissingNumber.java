package com.practise.newcodes;

public class MissingNumber {
	public static void main(String[] args) {
		int[] array = { 0,2,3,1,5 };
		int number = missingNumber(array);
		System.out.println(number);
	}

	public static int missingNumber(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			int correctIndex = arr[i];
			if (arr[i] < arr.length && arr[i] != arr[correctIndex]) {
				int temp = arr[i];
				arr[i] = arr[correctIndex];
				arr[correctIndex] = temp;
			} else {
				i++;
			}
		}

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] != j) {
				return j;
			}
		}
		return arr.length;
	}
}
