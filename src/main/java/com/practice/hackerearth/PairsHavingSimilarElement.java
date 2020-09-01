package com.practice.hackerearth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class PairsHavingSimilarElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_A = br.readLine().split(" ");
         int[] A = new int[N];
         for(int i_A=0; i_A<arr_A.length; i_A++)
         {
         	A[i_A] = Integer.parseInt(arr_A[i_A]);
         }

         long out_ = SimilarElementsPairs(A,N);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static long SimilarElementsPairs(int[] A,int N){
    	
    	Arrays.sort(A);
    	
    	int n=1,k=1,s=0;
    	for(int i=1;i<N;i++) {
    		if((A[i]==A[i-1]+1) || (A[i-1]==A[i]+1) ) {
    			++n;
    		}
    		else if(A[i]==A[i-1]) {
    			++n;
    			++k;
    		}else {
    			if(k!=n) {
    				s+= (n*(n-1))/2;
    			}
    			n=1;k=1;
    		}
    		
    	}
    	if( n>k) {
    		s+=(n*(n-1))/2;
    	}
    	return s;
    	
    	
//   	int max = Integer.MIN_VALUE;
//    	for(int i = 0; i< N ; i++) {
//    		if(max < a[i]) {
//    			max = a[i];
//    		}
//    	}
//    	int pairCount= 0;
    	
//    	Map<Integer, Integer> m = new HashMap<Integer, Integer>();
//    	for(int i = 0; i< N ; i++) {
//			
//			if (m.get(a[i]) == null) {
//				m.put(a[i], 1);
//			} else {
//				m.put(a[i], m.get(a[i]) + 1);
//			}
//    	}
  
//    	for(int i=0;i<N-1;i++) {
//    		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
//			for (int k = i+1; k < N; k++) {
//				if (m.get(A[k]) == null) {
//					m.put(A[k], 1);
//				} else {
//					m.put(A[k], m.get(A[k]) + 1);
//				}
//			}
//    		Integer no = m.get(A[i]+1);
//			if(no!=null && no>0) {
//    			pairCount+=no;
//    			no = m.get(A[i]);
//    			if(no!=null && no>0) {
//    				pairCount+=no;
//    			}
//    			no = m.get(A[i]+2);
//    			if (no!=null && no>0) {
//    				pairCount+=no;
//    			}
//    		}
//			 no = m.get(A[i]-1);
//    		if(no!=null && no>0) {
//    			pairCount+=no;
//    			no = m.get(A[i]);
//    			if(no!=null && no>0) {
//    				pairCount+=no;
//    			}
//    			no = m.get(A[i]-2);
//    			if (no!=null && no>0) {
//    				pairCount+=no;
//    			}
//    		}
//    	}
    	/*
    	int[] byValue = new int[max+2];
    	for(int i = 1; i<= N ; i++) {
    		byValue[a[i-1]] = i;
    	}
    	for(int i=0;i<N;i++) {
    		if(byValue[a[i]+1]>i+1) {
    			++pairCount;
    			if(byValue[a[i]]>i+1) {
    				++pairCount;
    			}
    			if (byValue[a[i]+2]>i+1) {
    				++pairCount;
    			}
    		}
    		if(byValue[a[i]-1]>i+1) {
    			++pairCount;
    			if(byValue[a[i]]>i+1) {
    				++pairCount;
    			}
    			if (byValue[a[i]-2]>i+1) {
    				++pairCount;
    			}
    		}
    	}
    	*/
		
        // Write your code here
		
    }
}