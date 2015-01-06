package tasks_arrays_Strings;

public abstract class ReplaceSpaces {
	public static char[] replaceSpaces(char[] str, int length) {
		int spaceCount = 0;
		int newLength;

		for (int i = 0; i < length; i++)
			if (str[i] == ' ')
				spaceCount++;

		newLength = length + spaceCount * 2;
		//str[newLength] = '\0';
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength -= 3;
			} else {
				str[newLength - 1] = str[i];
				newLength--;
			}
		}
		return str;
	}

}
