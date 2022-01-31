package com.practise.newcodes;

import java.util.Arrays;

public class OrderAgnosticsBS {
	public static void main(String[] args) {
		int[] arrayAscending = { 1, 2, 4, 6, 8, 12, 14, 15, 25, 30, 45, 50 };
		int target = 30;
		int ans = orderAgnosticsBinarySearch(arrayAscending, target);
		System.out.println(ans);

		int[] arrayDescending = { 50, 45, 30, 25, 15, 14, 12, 8, 6, 4, 2, 1 };
		int search = 30;
		int result = orderAgnosticsBinarySearch(arrayDescending, search);
		System.out.println(result);

	}

	public static int orderAgnosticsBinarySearch(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;

		// find whether array is sorted ascending or descending
		boolean isAscending;
		if (array[start] < array[end]) {
			isAscending = true;
		} else {
			isAscending = false;
		}

		while (start <= end) {
			// find mid point
			int mid = start + (end - start) / 2;

			if (array[mid] == target) {
				return mid;
			}

			if (isAscending) {
				if (target < array[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target > array[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

		}
		return -1;
	}
}
