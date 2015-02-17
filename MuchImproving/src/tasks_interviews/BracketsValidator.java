package tasks_interviews;

import java.util.Stack;

public class BracketsValidator {
	// Exercise 1: Write a program that validates whether all of the braces,
	// brackets, and parentheses are closed and properly nested.
	// [{}] - true
	// [{(})] - false
	// [(] - false
	// a(b) - true
	// [(] - false
	// }{ - false
	// g([{}-[]]{e}) - true
	// "" - true

	private final static String openingBrackets = "([{<";
	private final static String closingBrackets = ")]}>";

	public static boolean checkBrackets(String input) {
		Stack<Character> openedBrackets = new Stack<Character>();
		
		char[] inputs = input.toCharArray();
		int x = 0;
		for (char c : inputs) {
			if (openingBrackets.indexOf(c) != -1) {
				openedBrackets.push(c);
			} else if (closingBrackets.indexOf(c) != -1) {
				if (openedBrackets.isEmpty())
					return false;
				if (Math.abs(openedBrackets.pop() - c) > 2)
					return false;
			}

			x++;
			if (openedBrackets.size() > inputs.length - x)
				return false;
		}

		return openedBrackets.isEmpty();
	}

	public static void main(String[] args) {
		assert checkBrackets("abcdeq((){})") == true;
		assert checkBrackets("g([{}-[]]{y})") == true;
		assert checkBrackets("[(abc]") == false;
		assert checkBrackets("((())())()") == true;
		assert checkBrackets("[{(})]") == false;
		assert checkBrackets("[(]") == false;
		assert checkBrackets("") == true;
		assert checkBrackets("(((") == false;
		assert checkBrackets("}}}}}}") == false;
		assert checkBrackets("{}") == true;
		assert checkBrackets("}{") == false;
		assert checkBrackets(")") == false;
		assert checkBrackets("(") == false;
	}
}