package com.practice.hustle;

public class DPEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input2 = {{14,16,10,12},{8,5,6,1}};
		System.out.println(minCost(2, input2));
	}

	public static int minCost(int input1, int[][] input2) {

		if (input1 == 0) {
			return 0;
		}
		if (input1 == 1) {
			return Math.min(input2[0][1], Math.min(input2[0][2], Math.min(input2[0][3], input2[0][0])));
		}
		int[][] dp = new int[4][input1];

		for (int i = 0; i < 4; i++) {
			dp[i][0] = input2[0][i];
		}

		for (int j = 1; j < input1; j++) {
			// for i=0
			dp[0][j] = input2[j][0] + Math.min(dp[1][j - 1], Math.min(dp[2][j - 1], dp[3][j - 1]));

			// for i=1
			dp[1][j] = input2[j][1] + Math.min(dp[0][j - 1], Math.min(dp[2][j - 1], dp[3][j - 1]));

			// for i=2
			dp[2][j] = input2[j][2] + Math.min(dp[0][j - 1], Math.min(dp[1][j - 1], dp[3][j - 1]));
			// for i=3
			dp[3][j] = input2[j][3] + Math.min(dp[0][j - 1], Math.min(dp[1][j - 1], dp[2][j - 1]));

		}

		return Math.min(dp[0][input1 - 1], Math.min(dp[1][input1 - 1], Math.min(dp[2][input1 - 1], dp[3][input1 - 1])));

	}
}
