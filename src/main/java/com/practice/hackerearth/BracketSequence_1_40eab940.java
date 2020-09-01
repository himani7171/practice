package com.practice.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class BracketSequence_1_40eab940 {
	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); // Reading input
		 * from STDIN System.out.println("Hi, " + name + "."); // Writing output to
		 * STDOUT
		 */
		// Scanner
		Scanner s = new Scanner(System.in);
		String d = s.nextLine();
		char[] a = d.toCharArray();
		System.out.println(getBracketCount(a, a.length));

	}

	private static Integer getBracketCount(char[] a, int len) {
		int returnCount = 0;
		if (len % 2 != 0) {
			return 0;
		}

		for (int i = 0; i < len; i++) {
			int check = 0;
			int k = 0;
			if (a[i] == ')')
				continue;
			for (int j = i; k < len && check >= 0; j = (j + 1) % len, ++k) {
				if (a[j] == '(') {
					++check;
				} else {
					--check;
				}
			}
			if (check == 0) {
				++returnCount;
			}
		}
		return returnCount;

	}
}
