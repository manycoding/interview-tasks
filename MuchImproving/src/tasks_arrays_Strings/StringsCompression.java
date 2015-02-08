package tasks_arrays_Strings;

public abstract class StringsCompression {
	public static String compressBetter(String str) {
		StringBuffer buffer = new StringBuffer();
		if (str.length() < 2)
			return str;

		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last)
				count++;
			else {
				buffer.append(last);
				buffer.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}

		buffer.append(last);
		buffer.append(count);

		if (str.length() > buffer.length())
			return buffer.toString();
		else
			return str;
	}

}
