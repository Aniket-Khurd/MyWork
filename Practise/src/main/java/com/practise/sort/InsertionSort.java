package com.practise.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] array = { 3, 4, 2, 5, 1 };
		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void insertionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				} else {
					break;
				}
			}
		}
	}
}
