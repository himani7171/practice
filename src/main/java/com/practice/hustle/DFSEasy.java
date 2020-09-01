package com.practice.hustle;

public class DFSEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input3 = { { 1, 1, 0, 0 }, { 0, 1, 1, 1 }, { 0, 1, 0, 0 }, { 1, 1, 0, 1 }, { 0, 0, 1, 0 } };
		System.out.println(findPatch(5, 4, input3));

	}

	public static int findPatch(int input1, int input2, int[][] input3) {

		if (input1 == 1 && input2 == 1) {
			return input3[0][0];
		}

		// for 0,0
		int count = 0;
		for (int i = 0; i < input1; i++) {
			for (int j = 0; j < input2; j++) {
				if (input3[i][j] == 1) {
					// thenCheckforPatch
					checkAdj(i, j, input3, input1, input2);
					++count;

				}
			}
		}

		return count;
	}

	public static void checkAdj(int i, int j, int[][] input3, int input1, int input2) {
		if (input3[i][j] == 1) {
			input3[i][j] = 2;
			if (i + 1 < input1)
				checkAdj(i + 1, j, input3, input1, input2);
			if (i - 1 >= 0)
				checkAdj(i - 1, j, input3, input1, input2);
			if (j + 1 < input2)
				checkAdj(i, j + 1, input3, input1, input2);
			if (j - 1 >= 0)
				checkAdj(i, j - 1, input3, input1, input2);
		}
	}

}
