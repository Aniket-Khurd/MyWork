package com.practice.codes;

public class RemoveLetter {
	public static void main(String[] args) {
		String s ="Hello";
		char c='l';
		removeChar(s, c);
	}
	
	public static void removeChar(String st, char ch) {
		int j=0, count =0, n=st.length();
		char[]t = st.toCharArray();
		for(int i=j=0; i<n; i++) {
			if(t[i]!=ch) {
				t[j++]=t[i];
			}
			else {
				count++;
			}
		}
		System.out.println(t);
		while(count>0) {
			t[j++]='\0';
			count--;
		}
		System.out.println(t);
	}
}
