package com.practice.hackerearth;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class FindTargetInASortedArray {

	public static void main(String som[]) {

		Scanner s = new Scanner(new InputStreamReader(System.in));
		int T = Integer.parseInt(s.nextLine());
		int N = Integer.parseInt(s.nextLine());
		int[] a = new int[T];
		String[] split = s.nextLine().split(" ");
		s.close();
		for (int i = 0; i < T; i++) {
			a[i] = Integer.parseInt(split[i]);
		}

		Arrays.sort(a);
		int i = 0, j = T - 1;
		while (i < j) {
			if (a[i] + a[j] == N) {
				System.out.println("TRUE");
				return;
			}
			if (a[i] + a[j] < N) {
				++i;
			}
			if (a[i] + a[j] > N) {
				--j;
			}
		}
		System.out.println("FALSE");

	}
}
