package com.practise.newcodes;

public class BinarySearch {
	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 6, 8, 12, 14, 15, 25, 30, 45, 50 };
		int target = 50;
		int ans = binarySearch(array, target);
		System.out.println(target+" found at index number: "+ans);

	}

	// return index if found
	// return -1 if not found
	public static int binarySearch(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			// find mid point
			int mid = start + (end - start) / 2;

			if (target < array[mid]) {
				end = mid - 1;
			} else if (target > array[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}

		}
		return -1;
	}
}
