package tasks_interviews;

import java.util.HashMap;

public class MostFrequentInteger {

	public static void main(String[] args) {
		int[] test = new int[10];

		for (int i = 0; i < 10; i++) {
			if (i % 2 != 0)
				test[i] = Integer.MAX_VALUE;
			else
				test[i] = Integer.MIN_VALUE;

		}

		System.out.println(Integer.MAX_VALUE);
		System.out.println(foobar(test));
	}

	// What are the maximum allowable size of an input array and the maximum
	// value of integers?
	// Assume it's limited to Java's Integer.MAX_VALUE
	// Let's return a result in the long representation to avoid Java Integer
	// restrictions

	public static long foobar(int[] inputs) {
		if (inputs == null || inputs.length == 0)
			return Integer.MIN_VALUE;

		HashMap<Integer, Integer> dictionary = new HashMap<Integer, Integer>();
		int max = 1;
		int number = inputs[0];
		int frequency = 1;

		for (int i = 0; i < inputs.length; i++) {
			if (dictionary.containsKey(inputs[i])) {
				frequency = dictionary.get(inputs[i]) + 1;
				dictionary.replace(inputs[i], frequency);
			} else {
				frequency = 1;
				dictionary.put(inputs[i], 1);
			}

			if (frequency > max) {
				max = frequency;
				number = inputs[i];
			}
		}

		return (long) max * number;
	}
}
