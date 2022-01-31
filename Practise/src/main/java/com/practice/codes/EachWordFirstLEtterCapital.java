package com.practice.codes;

public class EachWordFirstLEtterCapital {

	public static void main(String[] args) {
		String input = "good morning";
		String output = capitalizeFirstChar(input);
		System.out.println(output);
	}

	public static String capitalizeFirstChar(String inputString) {
		String[] words = inputString.split(" ");
		String capitalizeWord = "";
		for (String word : words) {
			String firstLetter = word.substring(0, 1);
			String remainingString = word.substring(1);

			capitalizeWord = capitalizeWord + firstLetter.toUpperCase() + remainingString + " ";

		}

		return capitalizeWord;
	}
}
