package tasks_interviews;

import java.util.Stack;

public class BracketsValidator {
	// Exercise 1: Write a program that validates whether all of the braces,
	// brackets,
	// and parentheses are closed and properly nested.
	// [{}] - True
	// [{(})] - False
	// [(] - False

	private final static String openingBrackets = "([{<";
	private final static String closingBrackets = ")]}>";

	public static boolean checkBrackets(String input) {
		Stack<Character> bracketsBuffer = new Stack<Character>();
		char[] inputs = input.toCharArray();
		for (char c : inputs) {
			if (openingBrackets.indexOf(c) != -1) {
				bracketsBuffer.push(c);
			} else if (closingBrackets.indexOf(c) != -1) {
				if (bracketsBuffer.isEmpty())
					return false;
				if (Math.abs(bracketsBuffer.pop() - c) > 2)
					return false;
			}
		}

		return bracketsBuffer.isEmpty();
	}

	public static void main(String[] args) {
		assert checkBrackets("[{}]") == true;
		assert checkBrackets("[{(})]") == false;
		assert checkBrackets("[(]") == false;
		assert checkBrackets("") == true;
		assert checkBrackets("((((((((") == false;
		assert checkBrackets("}}}}}}") == false;
		assert checkBrackets("{}") == true;
		assert checkBrackets("}{") == false;
		assert checkBrackets(")") == false;
		assert checkBrackets("(") == false;
	}

}
