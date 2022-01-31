package com.practice.codes;

public class completeSamllBracketCount {

	public static void main(String[] args) {
		String input = "(((((())))))";

		char[] inputArray = input.toCharArray();
		int count = 0;
		int openingCount = 0;
		int closingCount = 0;

		for (int i = 0; i < inputArray.length; i++) {
//			if (inputArray[i] == '(' && inputArray[i + 1] == ')') {
//				count++;
//			}
			if(inputArray[i]=='(') {
				openingCount++;
			}else if(inputArray[i]==')') {
				closingCount++;
			}
		}
		
		if(openingCount>closingCount) {
			System.out.println(closingCount);
		}else {
			System.out.println(openingCount);
		}

//		System.out.println(count);
//
//		// nested complete brackets  )))))))(((((((
//
		String nestedInput = "(((((())))))";

		char[] nestedInputArray = nestedInput.toCharArray();
		int totalCount = 0;

		for (int i = 0; i < nestedInputArray.length; i++) {
			if (nestedInputArray[i] == '(' && nestedInputArray[nestedInputArray.length - i - 1] == ')') {
				totalCount++;
			}
		}
		System.out.println(totalCount);

	}
}
