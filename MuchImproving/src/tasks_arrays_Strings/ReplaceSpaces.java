package tasks_arrays_Strings;

public abstract class ReplaceSpaces {
	public static char[] replaceSpaces(char[] str, int length) {
		int spaceCount = 0;
		int newIndex;

		for (int i = 0; i < length; i++)
			if (str[i] == ' ')
				spaceCount++;

		newIndex = length + spaceCount * 2;
		// str[newLength] = '\0';
		for (int i = length - 1; i >= 0; i--) {

			if (str[i] == ' ') {
				str[newIndex - 1] = '0';
				str[newIndex - 2] = '2';
				str[newIndex - 3] = '%';
				newIndex -= 3;

				if (--spaceCount == 0)
					break;
			} else {
				str[newIndex - 1] = str[i];
				newIndex--;
			}
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(replaceSpaces("foo bar$  ".toCharArray(), 8));
	}
}

// 1.4 Write a method to replace all spaces in a string with '%20'. You may
// assume that the string has sufficient space at the end of the string to
// hold the additional characters, and that you are given the "true" length
// of the string. (Note: if implementing in Java, please use a character
// array so that you can perform this operation in place.)
