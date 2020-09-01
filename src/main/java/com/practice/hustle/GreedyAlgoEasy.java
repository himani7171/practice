package com.practice.hustle;

import java.util.Arrays;

public class GreedyAlgoEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input2 = {2,5,1};
		System.out.println(maxMarks(5, input2));
	}
	
	public static int maxMarks(int input1, int[] input2) {
		if(input1==0) return 0;
		if(input1==1) return input2[0];
		Arrays.sort(input2);

		int sum = input2[0];
	
		for(int i = 1 ; i< input1; i++) {
			if(input2[i] <= input2[i-1] ) {
				input2[i] = input2[i-1]+1;
			}
			sum +=input2[i] ;
		}
		return sum;
		
	}

}
