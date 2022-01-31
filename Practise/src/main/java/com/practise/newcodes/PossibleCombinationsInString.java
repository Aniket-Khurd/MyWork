package com.practise.newcodes;

import java.util.HashSet;
import java.util.Set;

public class PossibleCombinationsInString {

	public static void main(String[] args) {
		String input = "sample test interview question";

		Set<String> possibleCombinations = possibleUniqueCombinations(input);
		System.out.println("Total possible combinations from input string are: " + possibleCombinations.size());
		System.out.println("Combinations are: ");
		for (String combination : possibleCombinations) {
			System.out.println(combination);
		}
	}

	public static Set<String> possibleUniqueCombinations(String input) {
		String[] inputArray = input.split(" ");
		Set<String> combinations = new HashSet<String>();

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray.length; j++) {

				if (!(inputArray[i].equalsIgnoreCase(inputArray[j]))) {
					combinations.add(inputArray[i] + " " + inputArray[j]);
				}
			}
		}
		return combinations;
	}

}
