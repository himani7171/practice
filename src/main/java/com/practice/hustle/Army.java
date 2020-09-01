package com.practice.hustle;

import java.util.Arrays;
import java.util.TreeSet;

public class Army {

	public static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int input1 = 10;
		int input2 = 4;
		int[] input3 = { 4, 3, 5, 2 };

		int[] findAliveSoldiers = findAliveSoldiers(input1, input2, input3);
		System.out.println(findAliveSoldiers);
	}

	public static int[] findAliveSoldiers(int input1, int input2, int[] input3) {
		int[] x = new int[input1 + 1];
		for (int i = 0; i <= input1; i++) {
			x[i] = i;
		}
		if (input1 == 0) {
			return new int[0];
		}

		int i = 0;
		int finalLength = input1;
		while (i < input2) {

			int k = input3[i];
			if (finalLength > k) {
				performDeletion(finalLength, k, x);
				finalLength = reorder(x, finalLength);
				print(x);
				System.out.println(" || " + finalLength);
			}
			++i;

		}
		System.out.println(finalLength);
		return Arrays.copyOfRange(x ,1, finalLength+1);

	}

	private static void performDeletion(int N, int k, int[] a) {

		if (k <= N && a[k] > 0) {
			a[k] = 0;
			int left = 2 * k;
			int right = 2 * k + 1;
			performDeletion(N, left, a);
			performDeletion(N, right, a);

		}
	}

	private static int reorder(int[] a, int N) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (a[i] == 0) {
				++count;
			}
		}
		for (int i = 1; i < N; i++) {
			int j = 0;
			while (a[i + j] == 0 && i + j < N) {
				++j;

			}
			int start = i;
			if (j > 0)
				for (int m = j + i; m <= N; m++) {
					if (m == N && a[N] == 0 && a[N - 1] != 0) {
					} else
						a[start] = a[m];
					++start;
				}

		}
//		count=a[N]==0?count+1:count;return N-count;
		return N - count;

	}

	public static void searchAndDelete(int k, BinaryTree b) {

		if (b == null) {
			return;
		}

		else if (k == b.value) {
			b = null;
			return;

		} else {
			searchAndDelete(k, b.left);
			searchAndDelete(k, b.right);
		}

	}

	public static BinaryTree createBTree(int i, int N) {

		if (i <= N) {
			BinaryTree b = new BinaryTree();
			b.value = i;
			b.left = createBTree(2 * i, N);
			b.right = createBTree(2 * i + 1, N);
			return b;
		}
		return null;
	}

	public static void print(int a[]) {
		System.out.println("");
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}

	/*
	 * 
	 * 
	 * 
	 * 1. print root
	 * 
	 * -- recursion -- 2. print left child 3. print right child 4. call func for
	 * left ch 5. call func for riht ch
	 * 
	 * 
	 * 
	 * 
	 */

}
