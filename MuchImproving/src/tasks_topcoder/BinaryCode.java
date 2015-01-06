package tasks_topcoder;

public class BinaryCode {

	public String[] decode(String input) {
		String[] result = new String[2];
		result[0] = "NONE";
		result[1] = "NONE";
		int[] buffer = new int[input.length()];
		int[] buffer1 = new int[input.length()];
		buffer[0] = 0;
		buffer1[0] = 1;

		if (input.length() == 1) {
			if (Integer.valueOf(input) < 2)
				result[Integer.valueOf(input)] = input;

		}

		for (int i = 0; i < buffer.length - 1; i++) {
			if (buffer[i] > 1)
				break;
			int nextValue = Integer.valueOf(input.charAt(i + 1)) - buffer[i];
			int j = i + 1;

			while (nextValue > 0 && j - i < 4 && j < buffer.length) {
				buffer[j] = 1;
				j++;
				nextValue--;
			}
			if (i == buffer.length - 2) {
				buffer[i + 1] = (input.charAt(i + 1) - buffer[i]);
				StringBuffer stringBuffer = new StringBuffer();
				for (int n : buffer) {
					stringBuffer.append(n);
				}
				result[0] = stringBuffer.toString();
			}
		}

		return result;
	}
}
