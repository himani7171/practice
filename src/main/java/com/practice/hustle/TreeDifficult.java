package com.practice.hustle;

public class TreeDifficult {

	public static class Node {
		public static int preOrder = 0;
		int x;
		int y;
		int z;
		Node left;
		Node right;

		public static Node buildTree(int strt, int end, int[] input2, int[] input3, int[][] input4) {
			int inOrder = -1;
			if (preOrder >= input3.length || strt > end)
				return null;

			int D = input3[preOrder++];

			Node n = new Node();
			n.x = input4[D - 1][0];
			n.y = input4[D - 1][1];
			if (strt == end) {
				n.z = n.x - n.y;
				System.out.println(n.z);
				return n;
			}
			// find in input2
			for (int i = strt; i <= end; i++) {
				if (input2[i] == D) {
					inOrder = i;
					break;
				}
			}

			if (inOrder > 0)
				n.left = buildTree(strt, inOrder - 1, input2, input3, input4);
			if (inOrder < input3.length - 1)
				n.right = buildTree(inOrder + 1, end, input2, input3, input4);

			n.x = n.x + (n.left != null ? n.left.x : 0);
			n.y = n.y + (n.left != null ? n.left.y : 0);
			n.z = n.x - n.y;
			System.out.println(n.z);
			return n;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input2 = { 4, 2, 1, 3 };

		int[] input3 = { 1, 2, 4, 3 };

		int[][] input4 = { { 6, 2 }, { 7, 4 }, { 8, 6 }, { 9, 8 } };
		newTree(4, input2, input3, input4);

	}

	public static int[] newTree(int input1, int[] input2, int[] input3, int[][] input4) {
		int[] output = new int[input1];
		Node buildTree = Node.buildTree(0, input1 - 1, input2, input3, input4);
		inorderTraverse(buildTree, output);
		return output;

	}

	public static int i = 0;

	public static void inorderTraverse(Node n, int[] a) {
		if (n == null) {
			return;
		}
		inorderTraverse(n.left, a);
		a[i] = n.z;
		++i;
		inorderTraverse(n.right, a);
	}

}
