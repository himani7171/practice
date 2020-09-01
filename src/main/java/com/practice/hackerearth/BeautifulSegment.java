package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.OffsetDateTime;

class BeautifulSegment {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		while (T > 0) {
			System.out.println(OffsetDateTime.now());
			int totalSegments = 0;
			int N = Integer.parseInt(br.readLine().trim());
			if (N == 0) {
				System.out.println(0);
				--T;
				continue;
			}
			if (N < 3) {
				br.readLine();
				System.out.println(0);
				--T;
				continue;
			}
			String[] arr = br.readLine().split(" ");
			int[] a = new int[N];
//			String arr = br.readLine();
//			a= Stream.of(arr.split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(arr[i]);
			}
			System.out.println(OffsetDateTime.now());

			int i = 0;
			while (i < N - 1) {
				int strt = i, mid = i, end = i;
				while (i < N - 1 && a[i + 1] >= a[i]) {
					++mid;
					++i;
				}
				end = mid;
				if (strt < mid) {
					while (i < N - 1 && a[i + 1] < a[i]) {
						++end;
						++i;
					}
				}
				if (end > mid && mid > strt) {
					totalSegments += Math.min((mid - strt), (end - mid));
				}
				if(totalSegments==0) {
					++i;
				}
			}
			System.out.println(OffsetDateTime.now());
			System.out.println(totalSegments);
			--T;
		}

	}
}
