package com.practice.project;

import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App {
	private static final char CLOSING_BRACE = ')';

	private static final char OPENING_BRACE = '(';

	public static void main(String[] args) {
		System.out.println(infix);
		//compute();
		evaluatePostFix();
	}

	static String infix = "((a+b)*(c-d))/(e+f)";

	static Stack<Character> stack = new Stack<Character>();

	public static void compute() {
		char[] arr = infix.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isLetterOrDigit(arr[i])) {
				System.out.print(arr[i]);
			} else if (arr[i] == OPENING_BRACE) {
				stack.push(arr[i]);
			} else if (arr[i] == App.CLOSING_BRACE) {
				while (!stack.isEmpty()) {
					Character popped = stack.pop();
					if (popped == App.OPENING_BRACE) {
						break;
					}
					System.out.print(popped);
				}
			} else {
				// operator

				char operator = arr[i];
				// pop until precdence is higher or ( encountered
				while (!stack.isEmpty()) {
					char fromStack = stack.peek();
					if (precedence(operator) >= precedence(fromStack)) {
						System.out.print(stack.pop());
					} else {
						break;
					}
				}

				stack.push(arr[i]);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	static int precedence(char operator) {
		if (operator == '!') {
			return 0;
		}
		if (operator == '*' || operator == '/') {
			return 1;
		}
		if (operator == '+' || operator == '-') {
			return 2;
		}
		return 3;
	}

	static Stack<String> opStacks = new Stack<String>();
	static String postfix = "ab+cd-*ef+/";

	static void evaluatePostFix() {
		
		for (int i = 0; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);
			if(Character.isLetterOrDigit(ch)){
				opStacks.push(ch+"");
			}else{
				//Assumption : all operators are binary operators
				String operand1 = opStacks.pop();
				String operand2 = opStacks.pop();
				String s = operand2 + ch + operand1;
				opStacks.push(OPENING_BRACE+s+CLOSING_BRACE);
			}
		}
		System.out.println(opStacks.pop());
	}
}
