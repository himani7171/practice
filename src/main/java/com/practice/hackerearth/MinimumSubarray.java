package com.netent.platform.frws.common;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class MinimumSubarray {

    /*
     * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/tired-of-trying/description/
     * 
     * Given an array of length , report the minimum value of the following where :
     * 
     * 
     * Input Format
     * 
     * First-line has , number of test cases.
     * 
     * Second-line of every test case has , the length of array .
     * 
     * Third-line of every test case has space-separated integers denoting array .
     * 
     * Output Format
     * 
     * Print the minimum value.
     */
    public static void main(String args[]) throws Exception {
        int a[] = { 0, 36, -56, 12, 43, 0 };
        long sum[] = new long[6];
        sum[0] = a[0] - 1;
        long sumMin1 = Long.MAX_VALUE, sumMax1 = Long.MIN_VALUE;
        for (int i = 1; i < 6; i++) {
            sum[i] = sum[i - 1] + a[i];
            if (sumMin1 > (sum[i] - i)) {
                sumMin1 = (sum[i] - i);
            }
            if (sumMax1 < (sum[i] - i)) {
                sumMax1 = (sum[i] - i);
            }
        }

        System.out.println(sumMin1 - sumMax1);
    }
}
