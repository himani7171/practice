package com.practice.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class SwapNode {

	/*
	 * Complete the swapNodes function below.
	 */
	static int[][] swapNodes(int[][] indexes, int[] queries) {
		int[][] result = new int[queries.length][indexes.length];
		for (int m = 0; m < queries.length; m++) {
			int k = queries[m];
			int i = 1, k_i = k;

			while (k_i < indexes[indexes.length - 1][0]) {
				for (int j = 0; j < indexes.length; j++) {
					if (indexes[j][0] == k_i) {
						int temp = indexes[j][1];
						indexes[j][1] = indexes[j][2];
						indexes[j][2] = temp;
					}
				}
				++i;
				k_i = i * k;
			}

			infixExp(0, indexes, result);
			y = 0;
			++x;
		}
		return result;
		/*
		 * Write your code here.
		 */

	}

	private static int x = 0, y = 0;

	public static void infixExp(int node, int[][] indexes, int[][] a) {
		if (indexes[node][1] > 0) {
			infixExp(indexes[node][1] - 1, indexes, a);
			// ++y;
		}
		a[x][y] = node + 1;
		++y;
		if (indexes[node][2] > 0) {
			infixExp(indexes[node][2] - 1, indexes, a);
			// ++y;
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(scanner.nextLine().trim());

		int[][] indexes = new int[n][3];
		indexes[0][0] = 1;
		for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
			String[] indexesRowItems = scanner.nextLine().split(" ");

			for (int indexesColumnItr = 1; indexesColumnItr <= 2; indexesColumnItr++) {
				int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr - 1].trim());
				indexes[indexesRowItr][indexesColumnItr] = indexesItem;
				if (indexesItem != -1) {
					indexes[indexesItem - 1][0] = indexes[indexesRowItr][0] + 1;
				}
			}
		}

		int queriesCount = Integer.parseInt(scanner.nextLine().trim());

		int[] queries = new int[queriesCount];

		for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
			int queriesItem = Integer.parseInt(scanner.nextLine().trim());
			queries[queriesItr] = queriesItem;
		}

		int[][] result = swapNodes(indexes, queries);
		System.out.println(result);

		for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
			for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
				System.out.print(String.valueOf(result[resultRowItr][resultColumnItr]));

				if (resultColumnItr != result[resultRowItr].length - 1) {
					System.out.print(" ");
				}
			}

			if (resultRowItr != result.length - 1) {
				System.out.print("\n");
			}
		}
//
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
	}
}
