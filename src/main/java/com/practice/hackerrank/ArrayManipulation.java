package com.practice.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
		long max = 0;
		for (int i = 1; i <= n; i++) {
			long value = 0;
			for (int j = 0; j < queries.length; j++) {
				if (queries[j][0] <= i && queries[j][1] >= i)
					value += queries[j][2];
			}
			if (max < value) {
				max = value;
			}
		}
		return max;
	}
	
	static long arrayManipulation2(int n, int[][] queries) {
		long max = 0;
		int m = queries.length;
		long a[] = new long [n+1];
		for (int i = 0; i <m; i++) {
			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				
					a[j] += queries[i][2];
					if (max < a[j] ) {
						max = a[j];
					}
			}
			
		}
		return max;
	}
	
	static long arrayManipulation3(int n, int[][] queries) {
		long max = 0;
		int m = queries.length;
		long a[] = new long [n+1];
		for (int i = 0; i <m; i++) {
			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				
					a[j] += queries[i][2];
					if (max < a[j] ) {
						max = a[j];
					}
			}
			
		}
		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];
		int[] result = new int[n+2];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
				int a = Integer.parseInt(queriesRowItems[0]);
				int b = Integer.parseInt(queriesRowItems[1]);
				long k = Long.parseLong(queriesRowItems[2]);
				result[a] += k;
				result[b+1] -= k;
							
		}

		long sum=0 ,res = 0;
		for(int i = 1 ;i <=n ; i++) {
			sum+=result[i];
			res= Math.max(res, sum);
		}

		System.out.println(result);

		scanner.close();
	}
}
