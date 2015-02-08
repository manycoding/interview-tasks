package tasks_interviews;

public class InterleavingMovies {

	public static void main(String[] args) {
		String[] movies1 = new String[] { "O", "O", "O", "O", "O", "O", "O" };
		String[] movies2 = new String[] { "V", "V", "V", "V", "V", "V", "V",
				"V", "V", "V", "V", "V", "V", "V"  };

		printArray(interleaveArrays(movies1, movies2));

	}

	public static String[] interleaveArrays(String[] arr1, String[] arr2) {
		if (arr1 == null || arr2 == null || arr1.length == 0
				|| arr2.length == 0)
			return null;

		if (arr1.length >= arr2.length)
			return interleave(arr1, arr2);
		return interleave(arr2, arr1);
	}

	public static String[] interleave(String[] bigArr, String[] smallArr) {
		String[] result = new String[bigArr.length + smallArr.length];

		int bigArrCounter = 0;
		int smallArrCounter = 0;
		int stepCounter = 0;
		double temp1 = bigArr.length;
		double temp2 = smallArr.length;

		double step = Math.ceil(temp1 / (temp2 + 1));

		for (int i = 0; i < result.length; i++) {
			if (stepCounter < step) {
				result[i] = bigArr[bigArrCounter++];
				stepCounter++;
				temp1--;
			} else {
				result[i] = smallArr[smallArrCounter++];
				stepCounter = 0;
				temp2--;
				if (temp2 > 0)
					step = Math.ceil(temp1 / (temp2 + 1));
			}
		}

		return result;
	}

	private static void printArray(String[] array) {
		if (array == null) {
			System.out.println("null");
			return;
		}
		for (String s : array)
			System.out.println(s);
	}
}
