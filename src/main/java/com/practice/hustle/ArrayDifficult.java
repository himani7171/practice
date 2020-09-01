package com.practice.hustle;

public class ArrayDifficult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int exchanges(int input1, int input2, int input3) {
		if (input1 < 2 || input2 == input3 || input2<1 || input3<1) {
			return 0;
		}
		if(input1 ==2) {
			return 1;
		}
		if(input2/2==input3/2) {
			return 3;
		}
		
		 
		if(Math.max(input2, input3)/2 == Math.min(input2,input3)) {
			return 1;
		}
		
		int i = Math.max(input2, input3);
		int j = Math.min(input2, input3);
		int counthop= 0;
		while(i>0) {
			if(i/2==j) {
				i = i/2;
				break;
			}
			i=i/2;
			counthop++;
		}
		return ++counthop;
		
		//return input3;

	}
}
