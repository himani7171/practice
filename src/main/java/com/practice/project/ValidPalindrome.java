package com.practice.project;

import java.util.Arrays;
import java.util.Stack;

class ValidPalindrome {
	
	public static void main ( String a []) {
		System.out.println(validPalindrome("abcda"));
	}
	public static boolean validPalindrome(String s) {
		int j = s.length() - 1;
		Stack<Character> stk = new Stack<Character>();
		int i = 0;
		boolean isNotMatched = false;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				j--;
				i++;
			} else if (!isNotMatched && s.charAt(i) == s.charAt(j - 1)) {
				isNotMatched=true;
				i++;
				j = j - 2;
			} else if (!isNotMatched &&  i-1 > s.length() && s.charAt(i - 1) == s.charAt(j)) {
				isNotMatched=true;
				i=i+2;
				j--;
			} else {
				return false;
				
			}
		}
		//if (i < j) {
			return true;
//		}
//		return false;
	}

}