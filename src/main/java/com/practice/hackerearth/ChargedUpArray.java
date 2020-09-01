package com.practice.hackerearth;
import java.io.*;
import java.util.*;


public class ChargedUpArray {
    public static void main(String[] args) throws IOException {
    	InputStream inputStream = 
    			ChargedUpArray.class.getClassLoader().getResourceAsStream("test.txt");
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

            int out_ = solve(A,N);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static int solve(long[] A,int N){
    	long l = Long.MIN_VALUE;
    	double subsetcount = 1;
    	double lastCount =1;
    	for(int i=1;i<=N-1 ; i++) {
    		lastCount = (lastCount * (N-i))/i;
    		subsetcount+= lastCount;
    	}
    	long countCharged=0;
    	for(int i=0;i<N;i++) {
    		if(A[i]>=subsetcount) {
    			countCharged=(countCharged+A[i])%1000000007;
    		}
    	}
    	
    	return (int)countCharged;
        // Write your code here
    
    }
}