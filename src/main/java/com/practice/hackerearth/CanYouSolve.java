package com.practice.hackerearth;
/* IMPORTANT: Multiple classes and nested static classes are supported */


//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class CanYouSolve {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            long[] A = new long[N];
            for(int i_A=0; i_A<arr_A.length; i_A++)
            {
            	A[i_A] = Long.parseLong(arr_A[i_A]);
            }

            long out_ = solve(A,N);
            System.out.println(out_);
         }
         wr.close();
         br.close();
    }

    static long solve(long[] A,int N){
        long max=Long.MIN_VALUE;
        for(int i =0;i<N;i++){
            for(int j=N-1; j>=0 ;j--){
                long value = Math.abs(A[i]-A[j]) +
                Math.abs(i-j) ; 
                if(value>max){
                    max=value;
                }
            }
        }
        return max;

    }
}
