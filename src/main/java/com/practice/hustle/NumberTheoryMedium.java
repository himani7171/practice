package com.practice.hustle;

public class NumberTheoryMedium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(niceGift(8, "x", "y", "xxyyxxyy"));
	}

	public static int niceGift(int input1, String input2, String input3, String input4) {

		if (input1 < 2) {
			return 0;
		}
		int i = 0;
		// while charater is x , keep counting them
		int lastCountOfX = 0;
		int finalCount = 0;
		while (i < input4.length()) {
			int countOfSequence = 0;
			int countx = 0;
			while (i < input4.length() && input4.charAt(i) == input2.charAt(0)) {
				++countx;
				++i;
			}
			if (countx > 0) {
				int county = 0;
				while (i < input4.length() && input4.charAt(i) == input3.charAt(0)) {
					++county;
					++i;
				}
				countOfSequence = countx * county;
				finalCount += countOfSequence + lastCountOfX * county;
			}
			lastCountOfX += countx;
			if (countx == 0) {
				// y is in the beginning so increment i
				++i;
			}
		}

		return finalCount;
	}

}
