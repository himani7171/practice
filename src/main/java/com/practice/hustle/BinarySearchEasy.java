package com.practice.hustle;

import java.util.Arrays;

public class BinarySearchEasy {

//	public static class Pair {
//		public BinaryTree idx1;
//		public BinaryTree idx2;
//	}
	
	public static void main(String a[]) {
		int[] in  = {1,2};
		stickGame(1,in );
	}

	public static int stickGame(int input1, int[] input3) {
//		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		  input1 = 4;
		  int[] input2 = {1,2,3,9};
		if (input1 < 3) {
			return 0;
		}
		Arrays.sort(input2);
		int count = 0;
		for (int i = 2; i < input1; i++) {
			int length = input2[i];
			for (int j = 0; j < i; j++) {
				int index = Arrays.binarySearch(input2, j + 1, i, length - input2[j]);
				if (index >= 0 && j != index) {
//					Pair p = new Pair();
//					map.put(length, new );
					// ----- Raymond wins for length= input[2]
					count++;
					break;
				}
			}
		}
	//	System.out.println(count);
		return count;

	}

}
