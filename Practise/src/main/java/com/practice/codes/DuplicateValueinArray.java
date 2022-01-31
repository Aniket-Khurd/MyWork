package com.practice.codes;

import java.util.ArrayList;
import java.util.List;

public class DuplicateValueinArray {

	public static void main(String[] args) {
		int a[] = {1,1,2,4,5,6,7,2};
		List<Integer> duplicateNumber = new ArrayList<Integer>();
		boolean duplicateExist = false;
		
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]==a[j]) {
					
					if(duplicateNumber.contains(a[j])) {
						
						continue;
					}
					else {
						duplicateNumber.add(a[j]);
						duplicateExist = true;
					}
				}
			}
		}
		if(duplicateExist==true) {
			System.out.println("Duplicate numbers: "+duplicateNumber);
		}
		else {
			System.out.println("Duplicate numbers not available in an array");
		}
		

	}

}
