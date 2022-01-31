package com.practise.sort;

import java.util.Arrays;

public class CyclicSort {
	public static void main(String[] args) {
		int[] array = { 3, 2, 4, 1, 5 };
		cyclicSort(array);
		System.out.println(Arrays.toString(array));

		cyclicDescendingSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void cyclicSort(int[] arr) {
		int i = 0;

		while (i < arr.length) {
			int correctIndex = arr[i] - 1;
			if (arr[i] != arr[correctIndex]) {
				int temp = arr[i];
				arr[i] = arr[correctIndex];
				arr[correctIndex] = temp;
			} else {
				i++;
			}
		}
	}

	public static void cyclicDescendingSort(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			int correctIndex = arr.length - arr[i];
			if (arr[i] != arr[correctIndex]) {
				int temp = arr[i];
				arr[i] = arr[correctIndex];
				arr[correctIndex] = temp;
			} else {
				i++;
			}
		}
	}
}
