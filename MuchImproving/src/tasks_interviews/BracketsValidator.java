package tasks_interviews;

import java.util.HashMap;
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

	public static boolean checkBrackets(String input) {
		Stack<Character> openedBrackets = new Stack<Character>();
		HashMap<Character, Character> brackets = new HashMap<Character, Character>();
		brackets.put('(', ')');
		brackets.put('{', '}');
		brackets.put('[', ']');

		char[] inputs = input.toCharArray();
		int x = 0;
		for (char c : inputs) {
			if (brackets.containsKey(c)) {
				openedBrackets.push(c);
			} else if (brackets.containsValue(c)) {
				if (openedBrackets.isEmpty())
					return false;
				if (brackets.get(openedBrackets.pop()) != c)
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