package com.practice.codes;

import java.util.Stack;

public class CompleteBracketCountUsingStack {
	public static void main(String[] args) {
		String input = ")))()()()(((";

		int count = completeBracketCount(input);
		System.out.println("Complete bracket count: " + count);
	}

	public static int completeBracketCount(String input) {
		char[] inputArray = input.toCharArray();
		Stack<Object> st = new Stack<>();
		int count = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == '(') {
				st.push(inputArray[i]);
			} else if (inputArray[i] == ')') {
				if (!st.isEmpty()) {
					st.pop();
					count++;
				}
			}
		}
		return count;
	}
}
