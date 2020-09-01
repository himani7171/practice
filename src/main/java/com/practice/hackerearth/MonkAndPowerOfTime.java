package com.practice.hackerearth;

import java.io.*;
import java.util.*;

class MonkAndPowerOfTime {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine().trim());
		String[] arr_A = br.readLine().split(" ");

		int[] b = new int[N + 1];
		for (int i_A = 0; i_A < arr_A.length; i_A++) {
			b[Integer.parseInt(arr_A[i_A])] = i_A;
		}

		arr_A = br.readLine().split(" ");
		int[] a = new int[N];
		for (int i_A = 0; i_A < arr_A.length; i_A++) {
			a[i_A] = Integer.parseInt(arr_A[i_A]);
		}

		long timetaken = 0;
		

		for (int j = 0; j < N; j++) {
			int k = b[a[j]] - j;
			if (k > 0) {
				timetaken += k;
				for (int m = 0; m < N; m++) {
					int i = b[a[m]];
					if (i >= j)
						b[a[m]] = ((N - j + i - j - k) % (N - j)) + j;
				}

			}
			timetaken++;
		}

		System.out.println(timetaken);
	}
}
