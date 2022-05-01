package com.greatlearning.balancebracket.main;

import java.util.*;

/**
 * @author Ankita Shukla
 *
 */
public class BalancedBrackets {

	/*
	 * method to validate if given String has balanced brackets or not
	 */

	public static boolean checkBalancedBrackets(String brackets) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < brackets.length(); i++) {
			char ch = brackets.charAt(i);

			if (ch == '(' || ch == '[' || ch == '{') {
				// Push the opening brackets in the stack
				stack.push(ch);
				continue;
			}

			if (stack.isEmpty())
				return false;
			char check;
			switch (ch) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		return (stack.isEmpty());

	}

	public static void main(String[] args) {

		String[] inputs = { "([[{}]])", "([[{}]]))" };

		for (String str : inputs) {
			if (checkBalancedBrackets(str)) {
				System.out.println("The entered String has Balanced Brackets " + str);
			} else {
				System.out.println("The entered Strings do not contain Balanced Brackets " + str);
			}
		}
	}

}
