package com.practice.hackerrank;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem1 {

	/*
	 * Complete the 'dynamicArray' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY queries
	 */

	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

		return null;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int q = Integer.parseInt(firstMultipleInput[1]);

		List<Integer>[] sequence = new ArrayList[n];
		List<Integer> result = new ArrayList<Integer>();
		Integer lastAnswer = 0;
		int i = 0;
		while (i < q) {
			String[] split = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			int x = Integer.parseInt(split[1]);
			int y = Integer.parseInt(split[2]);
			int index = (x ^ lastAnswer) % n;
			if (split[0].equals("1")) {
				if (sequence[index] == null) {
					sequence[index] = new ArrayList<Integer>(0);
				}
				sequence[index].add(y);
			} else {
				if (sequence[index] == null) {
					sequence[index] = new ArrayList<Integer>(0);
				}
				int index2 = y % (sequence[index].size());
				lastAnswer = sequence[index].get(index2);
				result.add(lastAnswer); 
			}

			i++;
		}


		System.out.println(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		
	}
}
