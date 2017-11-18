package tasks_interviews;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Problem
//Given a pattern and a list of filenames, return the filenames which match the
//given pattern in a separate list. The pattern should support two wild card
//characters ‘?’ and ‘*’, in which ‘?’ can match one or zero character and ‘*’ can
//match any number of characters.
//Instruction
//Please find the skeleton implementation in Glob.java and implement the match
//static method. Also, please avoid using the regex library.
//For instance,
//Glob.match("?abc*", new String[] {"abcd", "dabc", "abc", "efabc"})
//# should return ["abcd", "dabc", "abc"]

public class RegularExpressionsMatching {

	private static boolean testHarness(String patt, String str) {
		Pattern pattern = Pattern.compile(patt);
		Matcher matcher = pattern.matcher(str);

		return matcher.find();
	}

	public static boolean arrayEquals(String[] array1, String[] array2) {
		if (array1.length != array2.length) {
			return false;
		}
		for (int i = 0; i < array1.length; i++) {
			if (!array1[i].equals(array2[i])) {
				return false;
			}
		}
		return true;
	}

	public static String[] match(String pattern, String[] filenames) {

		ArrayList<String> matchedNames = new ArrayList<String>();
		boolean mismatch = false;

		if (pattern == "") {
			for (String filename : filenames) {
				if (filename == pattern)
					matchedNames.add(filename);
			}
			return (String[]) matchedNames.toArray(new String[matchedNames
					.size()]);
		}

		for (String filename : filenames) {
			boolean wasAsteriks = false;
			int freeSpace = 0;
			int skippedSymbolsNumber = 0;
			int j = 0;
			mismatch = false;

			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) == '*') {
					freeSpace = -1;
				} else if (pattern.charAt(i) == '?' && freeSpace != -1)
					freeSpace++;

				if (i == pattern.length() - 1) {
					if (j != filename.length() - 1 && freeSpace != -1
							&& freeSpace < filename.length()) {
						mismatch = true;
						break;
					}
				}

				if (pattern.charAt(i) != '*' && pattern.charAt(i) != '?') {
					skippedSymbolsNumber = 0;

					if (filename == "") {
						mismatch = true;
						continue;
					}

					if (pattern.charAt(i) != filename.charAt(j))
						while (filename.charAt(j) != pattern.charAt(i)
								&& j < filename.length() - 1) {
							j++;
							skippedSymbolsNumber++;
						}
					if (i == pattern.length() - 1)
						if (j != filename.length() - 1) {
							mismatch = true;
							break;
						}
					if (pattern.charAt(i) != filename.charAt(j)) {
						mismatch = true;
					}
					if (pattern.charAt(i) == filename.charAt(j)
							&& j != filename.length() - 1)
						j++;
					if (freeSpace == -1 || freeSpace >= skippedSymbolsNumber)
						freeSpace = 0;
					else {
						mismatch = true;
						freeSpace = 0;
						break;
					}
				}
			}
			if (!mismatch)
				matchedNames.add(filename);
		}
		return (String[]) matchedNames.toArray(new String[matchedNames.size()]);
	}

	public static String[] matchSeparator(String pattern, String[] filenames) {
		int[] table = new int[256];

		ArrayList<String> result = new ArrayList<String>();
		String[] letters = pattern.split("\\*");
		showArray(letters);
		int asteriskCount = getCharacterCount(pattern, '*');
		System.out.println(asteriskCount);

		for (int i = 0; i < filenames.length; i++) {
			boolean foundAsterisk = false;
			boolean matches = true;
			int filenameIndex = filenames[i].length() - 1;

			for (int j = pattern.length(); j >= 0; j--) {
				if (pattern.charAt(j) == '*') {
					foundAsterisk = true;
					asteriskCount--;
				} else if (pattern.charAt(j) == '?') {
					continue;
				} else {
					if (foundAsterisk) {
						if (asteriskCount == 0)
							continue;
					} else {
						if (pattern.charAt(j) == filenames[i]
								.charAt(filenameIndex)) {
							filenameIndex--;
						} else {
							matches = false;
							break;
						}
					}
				}
			}

			if (matches)
				result.add(filenames[i]);

		}
		return (String[]) result.toArray(new String[result.size()]);
	}

	public static int getCharacterCount(String input, char symbol) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == symbol)
				count++;
		}
		return count;
	}

	private static boolean isMatched(String pattern, String input) {
		if (input.length() == 0) {
			// Match is true when regex is exhausted or it's last char is "*" -
			// allowing optional str
			return pattern.length() == 0
					|| pattern.charAt(pattern.length() - 1) == '*';
		}

		if (pattern.length() == 0) {
			// Match is true only if str is fully consumed
			return input.length() == 0;
		}

		Character curReg = pattern.charAt(0);
		Character nextReg = pattern.length() >= 2 ? pattern.charAt(1) : null;
		Character curStr = input.length() != 0 ? input.charAt(0) : null;

		if (nextReg == null || (nextReg != '*' && nextReg != '?')) {
			// This is a simple match - just take the first char from both regex
			// and str and recurse IFF current match is detected
			return isCharMatched(curReg, curStr)
					&& isMatched(pattern.substring(1), input.substring(1));
		} else {
			if (nextReg == '*') {
				// The current regex char is followed by "*" - create 2
				// branches:
				// - one with unmodified regex and reduced str IFF current match
				// detected - meaning to continue repetition if possible
				// - the other one with reduced regex and unmodified str -
				// meaning to try out the optional nature of "*"
				return (isCharMatched(curReg, curStr) && isMatched(pattern,
						input.substring(1)))
						|| isMatched(pattern.substring(2), input);
			} 
//			else if (nextReg == '?') {
//				// The current regex char is followed by "+" - reduce to 1
//				// branch with "*" instead of "+"
//				return isCharMatched(curReg, curStr)
//						&& isMatched(curReg + "*" + pattern.substring(2),
//								input.substring(1));
//			} 
			else {
				return false;
			}
		}
	}

	private static boolean isCharMatched(Character patternSymbol,
			Character inputSymbol) {
		return patternSymbol == inputSymbol
				|| (patternSymbol == '.' && inputSymbol >= 'a' && inputSymbol <= 'z');
	}

	public static void showArray(String[] inputs) {
		for (String s : inputs) {
			if (s.isEmpty())
				System.out.println("empty");
			else
				System.out.println(s);
		}
	}

	public static void main(String[] args) {

		System.out.println(isMatched("a*", "a"));

		// System.out.println(arrayEquals(new String[] { "abababa" },
		// match("*a", new String[] { "abababa", "", "c", "", "x" })));
		// System.out.println(arrayEquals(new String[] { "", "", "" },
		// match("", new String[] { "", "", "c", "", "x" })));
		// System.out.println(arrayEquals(new String[] { "", "cc", "c", "", "x"
		// },
		// match("??", new String[] { "", "cc", "c", "", "x" })));
		// System.out.println(arrayEquals(new String[] { "cccccc", "cc", "c" },
		// match("*c*", new String[] { "cccccc", "cc", "c", "", "x" })));
		// System.out.println(arrayEquals(
		// new String[] { "abcd", "dabc", "abc", "efabc", "eadd" },
		// match("?*", new String[] { "abcd", "dabc", "abc", "efabc",
		// "eadd" })));
		// System.out.println(arrayEquals(
		// new String[] { "abcd", "dabc", "abc", "efabc", "eadd" },
		// match("*?", new String[] { "abcd", "dabc", "abc", "efabc",
		// "eadd" })));
		// System.out.println(arrayEquals(
		// new String[] { "abcd", "dabc", "abc", "eadd" },
		// match("????", new String[] { "abcd", "dabc", "abc", "efabc",
		// "eadd" })));
		// System.out.println(arrayEquals(
		// new String[] { "abcd", "dabc", "abc", "efabc", "eadd" },
		// match("*", new String[] { "abcd", "dabc", "abc", "efabc",
		// "eadd" })));
		// System.out.println(arrayEquals(
		// new String[] {},
		// match("??", new String[] { "abcd", "dabc", "abc", "efabc",
		// "eadd" })));
		// System.out
		// .println(arrayEquals(
		// new String[] {},
		// match("", new String[] { "abcd", "dabc", "abc",
		// "efabc", "eadd" })));
		//
		// System.out.println(arrayEquals(
		// new String[] { "abcd", "dabc", "abc" },
		// match("?abc*", new String[] { "abcd", "dabc", "abc", "efabc",
		// "eadd" })));
		// System.out.println(arrayEquals(
		// new String[] { "abcd", "dabc", "abc" },
		// match("?a**c*", new String[] { "abcd", "dabc", "abc", "efabc",
		// "eadd" })));
		//
		// System.out.println(testHarness("cat*cat", "ccat"));
	}
}
