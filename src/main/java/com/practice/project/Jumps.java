package com.practice.project;

import java.util.List;
import java.util.stream.Collectors;

public class Jumps {

	public static void main(String bb[]) {
		int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
			//{ 1, 2, 0, 0, 1 };
		char[] ii = {'1','2','3'};
		String string =  "a";
		List<Object> l = string.chars() 				// IntStream
				.mapToObj(e -> (char)e) 	// Stream<Character>
				.collect(Collectors.toList());
		int n = a.length, i = 0;
		System.out.println(countJump(a, i, n));

	}

	public static int countJump(int a[], int i, int n) {

		if (i == n - 1) {
			return 0;
		}
		if (a[i] == 0) {
			return -1;
		}
		int count = Integer.MAX_VALUE;
		for (int j = i + 1; j <= i + a[i] && j < n; j++) {
			int countJump = countJump(a, j, n);
			if (countJump == -1) {
				continue;
			}
			int countPerPath = 1 + countJump;
			if (countPerPath < count && countPerPath != -1) {
				count = countPerPath;
			}
		}
		return count;

	}

}
