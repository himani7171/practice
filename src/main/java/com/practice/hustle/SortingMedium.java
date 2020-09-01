package com.practice.hustle;

import java.util.Arrays;

public class SortingMedium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input2 = { 2, 0 };
		System.out.println(buses(2, input2, 3, 20));

	}

	public static int buses(int input1, int[] input2, int input3, int input4) {
		if (input1 == 0 || input4 == 0 || input3 == 0) {
			return 0;
		}
		Arrays.sort(input2);
		for (int i = 0; i < input3; i++) {
			if (input2[input1 - 1] > 0) {
				input2[input1 - 1] = input2[input1 - 1] - input4;
				Arrays.sort(input2);
			} else {
				// All passengers accommodated.
				return 0;
			}

		}
		int sum = 0;
		for (int i = 0; i < input1; i++) {
			if (input2[i] > 0)
				sum += input2[i];
		}
		return sum;

	}

}
