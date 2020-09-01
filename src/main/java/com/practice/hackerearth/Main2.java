package com.netent.platform.frws.common;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Main2 {

    public static void main(String[] args) throws JsonProcessingException {
        int a[] = { 0, 36, -56, 12, 43, 0 };
        int i = 0, j = 5;
        long min = 0;
        for (int k = 0; k < 6; k++) {
            min += a[k];
        }
        long actualSum = min;
        min = min + i - j - 1;
        while (i <= j) {
            actualSum = actualSum - a[i];
            i++;
            long intermediateSumValue = actualSum + i - j - 1;
            if (intermediateSumValue <= min) {
                min = intermediateSumValue;
            }
            System.out.println("index [ i = " + i + " ], [ j = " + j + " ] " +  ", [intermediateSumValue = " + intermediateSumValue);
            System.out.println("actualSum = " + actualSum);
            System.out.println("min = " + min);
            
            actualSum = actualSum - a[j];
            j--;
            intermediateSumValue = actualSum + i - j - 1;
            if ((intermediateSumValue) <= min) {
                min = intermediateSumValue;
            }
            
            System.out.println("index [ i = " + i + " ], [ j = " + j + " ] " +  ", [intermediateSumValue = " + intermediateSumValue);
            System.out.println("actualSum = " + actualSum);
            System.out.println("min = " + min);
        }
        System.out.println(min);
    }

}
