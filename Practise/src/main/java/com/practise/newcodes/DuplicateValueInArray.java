package com.practise.newcodes;

import java.util.ArrayList;
import java.util.List;


public class DuplicateValueInArray 
{
	public static void main(String[] args) 
	{
		int[] array = {1,2,3,1,4,2,5,3,6,7};
		List<Integer> duplicateValues = duplicateNumbersInArray(array);
		System.out.println(duplicateValues);
	}
	
	public static List<Integer> duplicateNumbersInArray(int[] array)
	{
		List<Integer> duplicateNumber = new ArrayList<Integer>();
		List<Integer> nonDuplicateNumbers = new ArrayList<Integer>();
		for(int i=0; i<array.length; i++)
		{
			if(!nonDuplicateNumbers.contains(array[i]))
			{
				nonDuplicateNumbers.add(array[i]);
			}
			else
			{
				duplicateNumber.add(array[i]);
			}
		}
		return duplicateNumber;
	}
}
