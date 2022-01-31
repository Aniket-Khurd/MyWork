package com.practise.newcodes;

import java.util.Arrays;

public class CeilingNumberAndFloorNumber {
	// Ceiling number : first largest number than given number
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 3, 6, 8, 14, 18, 16, 20 };
		int target = 15;
		System.out.println(Arrays.toString(array));

		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int ans = ceilingNumber(array, target);
		System.out.println(ans);

		int result = floorNumber(array, target);
		System.out.println(result);
	}

	public static int ceilingNumber(int[] array, int target) {

		if (target > array[array.length - 1]) {
			return -1;
		}
		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target > array[mid]) {
				start = mid + 1;
			} else if (target < array[mid]) {
				end = mid - 1;
			} else {
				return array[mid];
			}
		}

		return array[start];
	}

	public static int floorNumber(int[] array, int target) {
		if (target < array[0]) {
			return -1;
		}

		int start = 0;
		int end = array.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (target > array[mid]) {
				start = mid + 1;
			} else if (target < array[mid]) {
				end = mid - 1;
			} else {
				return array[mid];
			}
		}
		return array[end];
	}
}
