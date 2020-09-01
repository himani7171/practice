package com.practice.hackerrank;
import java.util.Scanner;

public class LeftRotations {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);


        String[] aItems1 = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        for (int i = 0; i < n; i++) {
//            int aItem = Integer.parseInt(aItems1[i]);
//            a[i] = aItem;
//        }
        int i=0;
        String[] aItems = new String [n];
        for( ;i< n-d ; i++){
        	aItems[i-d] = aItems1[i];
        }

        for(int j=0 ;j< d ; j++){
        	aItems[i] = aItems1[j];
        }
        System.out.println(String.join(" " , aItems));
        scanner.close();
    }
}
