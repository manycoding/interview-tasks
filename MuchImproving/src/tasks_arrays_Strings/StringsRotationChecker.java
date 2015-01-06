package tasks_arrays_Strings;

public abstract class StringsRotationChecker {
	public static boolean isRotation(String s1, String s2) {
		int length = s1.length();
		if (length == s2.length() && length > 0) {
			String s1s1 = s1 + s1;
			return s1s1.contains(s2);
		}
		return false;
	}
}

//Assume you have a method isSubstring which checks if one word is a
//substring of another. Given two strings, s1 and s2, write code to check if s2 is
//a rotation of s1 using only one call to isSubstring (e.g.,"waterbottle" is a rotation
//of "erbottlewat").