package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class UniqueSubarrays {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0 || N == 1) {
				System.out.println(N);
				continue;
			}
			String[] arr = br.readLine().split(" ");
			int[] a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(arr[i]);
			}
			long count =0;
			Map<Integer,Integer> m = new HashMap<>();
			int i =0;
			int lastfoundAtIndex = 0;
			while(i<N) {				
				int lengthOfLongestUniqueSubarray=0;
				if(m.get(a[i]) !=null) {
					lastfoundAtIndex= Math.max(m.get(a[i]), lastfoundAtIndex);
				}
				if(lastfoundAtIndex ==0) {
					lengthOfLongestUniqueSubarray = i+1;
				}else {
					lengthOfLongestUniqueSubarray = i-lastfoundAtIndex;
				}
				m.put(a[i], i);	
				count +=(lengthOfLongestUniqueSubarray*(lengthOfLongestUniqueSubarray+1))/2;
				++i;
			}
		System.out.println(count);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			Set<Integer> uniqueSet = new HashSet<Integer>();
//			for (int i = 0; i < N; i++) {
//				uniqueSet.add(a[i]);
//			}
//
//			long count = a.length;
//			
//			for (int i = 0; i < N; i++) {
//
//				int xOR;
//				for (int j = i + 1; j < N; j++) {
//					xOR = a[i] ^ a[j];
//					if (xOR == 0) {
//						break;
//					}
//					count += (j - i + 1);
//				}
//			}
//			System.out.println(count);
		}

	}
}
