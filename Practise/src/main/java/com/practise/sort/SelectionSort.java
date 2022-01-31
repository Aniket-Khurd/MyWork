package com.practise.sort;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] array = {3,5,2,1,4};
		selctionSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void selctionSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			//find max in remaining array and swap with correct index
			int last = array.length-i-1;
			int maxIndex = getMaxIndex(array, 0, last);
			int temp = array[maxIndex];
			array[maxIndex] = array[last];
			array[last] = temp;
		}
	}

	private static int getMaxIndex(int[] array, int start, int end) {
		int max = start;
		for(int i=0; i<end; i++) {
			if(array[max]<array[i]) {
				max=i;
			}
		}
		return max;
	}
}
