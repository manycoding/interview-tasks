package tasks_arrays_Strings;

public abstract class UniqueChars {
	public static boolean isUniqueChars(String str) {
		if (str.length() > 256)
			return false;

		boolean[] chars = new boolean[256];

		for (int i = 0; i < str.length(); i++) {
			int value = str.charAt(i);
			if (chars[value])
				return false;
			chars[value] = true;
		}

		return true;
	}

	public static boolean isUniqueCharsBit(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}
}
