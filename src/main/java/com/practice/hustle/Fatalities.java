package com.practice.hustle;

public class Fatalities {
    
    public static void main(String a[]) {
        
        int input1 = 6;
        int input2 = 3;
        int[] input3 = {1,2,3,4,5,6};
        int[] input4 = {1,3,2,6,4,5};
        System.out.println(countFatalities(input1, input2, input3, input4));
    }

    public static int countFatalities(int input1, int input2, int input3[], int input4[]) {
        if (input2 == 0 || input1 == 0) {
            return 0;
        }
        int totalFat = 0;
        int n = input1 / input2;

        for (int p = 0; p < n; p++) {
            // input3[p] to input3[p+1(input2) -1 ]
            int end = (p + 1) * input2;
            int start = p * input2;
            int index = -1;
            for (int i = start; i < end; i++) {
                if (input3[start] == input4[i]) {
                    index = i;
                    break;
                }
            }
            if (index < 0) {
                totalFat += input2;
                continue;
            }
            int shift = index - start;
            int i = 0;
            for (i = start; i < end; i++) {
                if (input4[(i + shift) % input2] != input3[i]) {
                    break;
                }
            }
            if (i < end) {
                totalFat += input2;
                continue;
            }
        }

        if (input1 % input2 != 0) {
            int start = n * input2;
            int end = input1;
            int index = -1;
            for (int i = start; i < end; i++) {
                if (input3[start] == input4[i]) {
                    index = i;
                    break;
                }
            }
            if (index < 0) {
                totalFat += input1 % input2;
                return totalFat;
            }
            int shift = index - start;
            int i = 0;
            for (i = start; i < end; i++) {
                if (input4[(i + shift) % input2] != input3[i]) {
                    break;
                }
            }
            if (i < end) {
                totalFat += input1 % input2;

            }
        }

        return totalFat;

    }
}
