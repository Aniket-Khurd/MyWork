package com.practice.codes;

public class ReverseOfStringWithPreservedSpaces {

	public static void main(String[] args) {
		String input = "I am an automation tester";

		char[] inputArray = input.toCharArray();
		char[] result = new char[inputArray.length];

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == ' ') {
				result[i] = ' ';
			} else {
				continue;
			}
		}

		int k = result.length - 1;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] != ' ') {
				if (result[k] == ' ') {
					k--;
				}
				result[k] = inputArray[i];
				k--;

			}
		}

		System.out.println(result);

	}
}
