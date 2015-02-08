package tasks_arrays_Strings;

import java.util.Arrays;

public abstract class StringsPermutation {
	public static boolean isPermutationWithSort(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		return sort(s1).equals(sort(s2));
	}

	private static String sort(String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);

		return new String(content);
	}

	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		int[] letters = new int[256];

		char[] s1Array = s1.toCharArray();
		for (char c : s1Array) {
			letters[c]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			int c = (int) s2.charAt(i);
			if (--letters[c] < 0)
				return false;
		}

		return true;
	}

}
