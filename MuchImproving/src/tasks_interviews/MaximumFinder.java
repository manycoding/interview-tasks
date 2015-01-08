package tasks_interviews;

public abstract class MaximumFinder {
	public static int findMaximum(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			return 0;
		if (numbers.length == 1)
			return numbers[0];

		int first = 0;
		int last = numbers.length;
		int medium = (last - first) / 2;

		int leftMax = findMaximum(getHalf(numbers, first, medium));
		int rightMax = findMaximum(getHalf(numbers, medium, last));

		if (leftMax > rightMax)
			return leftMax;
		return rightMax;
	}

	private static int[] getHalf(int[] array, int first, int last) {
		int[] halfArray = new int[last - first];
		for (int i = 0; i < halfArray.length; i++)
			halfArray[i] = array[i + first];
		return halfArray;
	}

}
