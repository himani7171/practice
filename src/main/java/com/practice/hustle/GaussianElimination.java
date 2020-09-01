package com.practice.hustle;

import java.util.Arrays;

public class GaussianElimination {

	public static void main(String[] args) {
		int countMoves = Integer.MAX_VALUE;

		byte[][] inputMatrix = new byte[3][3];
		inputMatrix[0][0] = 0;
		inputMatrix[0][1] = 1;
		inputMatrix[0][2] = 1;
		inputMatrix[1][0] = 0;
		inputMatrix[1][1] = 0;
		inputMatrix[1][2] = 0;
		inputMatrix[2][0] = 0;
		inputMatrix[2][1] = 1;
		inputMatrix[2][2] = 1;
		int N = inputMatrix.length;
		int M = inputMatrix[0].length;

		int maxSize = Math.min(N, M);

		for (int j = 2; j <= maxSize; ++j) { // loop for every possible square size
			byte[][] a = new byte[N * M][(N * M) + 1];

			for (int i = 0; i < N * M; i++) { // logic for square wise toggle for every element of N*M elements

				byte seq[] = new byte[N * M + 1];
				int index_i = i / M;
				int index_j = i % M;
				if (index_i <= N - j && index_j <= M - j) {
					for (int c = 0; c < j; c++) {
						for (int k = 0; k < j; k++) {
							seq[i + k + M * c] = 1;
						}
					}
					a[i] = seq;
				} else {
					if (index_i > N - j) {
						seq = Arrays.copyOf(a[i - M], N * M + 1);
					} else {
						seq = Arrays.copyOf(a[i - 1], N * M + 1);
					}
				}
				seq[N * M] = inputMatrix[index_i][index_j];
				a[i] = seq;

			}
			System.out.println("\nSolving for square size = " + j);
			print(a, N * M);

			int movesPerSquareSize = gaussian(a);
			if (movesPerSquareSize != 0) {
				countMoves = Math.min(countMoves, movesPerSquareSize);
			}
		}
		System.out.println(countMoves);
	}

	public static int gaussian(byte a[][]) {
		// n X n+1 matrix
		int N = a.length;
		for (int k = 0; k < N - 1; k++) {

			// Finding pivot element
			int max_i = k, max_value = a[k][k];
			for (int i = k + 1; i < N; i++) {
				if (a[i][k] > max_value) {
					max_value = a[i][k];
					max_i = i;
				}
			}

			// swap max row with kth row
			byte[] temp = a[k];
			a[k] = a[max_i];
			a[max_i] = temp;

			// convert to 0 all cells below pivot in the column
			

			for (int i = 0; i < N; i++) {
				// int scalar = a[i][k] + a[k][k]; // probability of a divide by zero
				if(i!=k )
				if (a[i][k] == 1) {
					for (int j = 0; j <= N; j++) {
						if (a[i][j] == a[k][j]) {
							a[i][j] = 0;
						} else {
							a[i][j] = 1;
						}
					}
				}
			}
		}

		System.out.println("\n\tAfter applying gaussian elimination :  ");
		print(a, N);

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (a[i][N] == 1)
				++count;
		}
		return count;
	}

	private static void print(byte[][] a, int N) {
		for (int i = 0; i < N; i++) {
			System.out.print("\t ");
			for (int j = 0; j < N + 1; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

}
