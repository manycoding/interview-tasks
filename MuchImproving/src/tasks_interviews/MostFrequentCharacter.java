package tasks_interviews;

// Write a function that accepts a string, and returns the character that occurs the most.
// Parallelize it

public class MostFrequentCharacter extends Thread {
	private String input;

	public MostFrequentCharacter(String input) {
		this.input = input;
	}

	public void run() {
		System.out.println(getMostFrequentChar(input));
	}

	public static char getMostFrequentChar(String input) {
		if (input == "")
			return (char) Integer.MIN_VALUE;

		char[] inputs = input.toCharArray();
		int[] dictionary = new int[128];
		int max = dictionary[0];
		int characterId = 0;
		for (int i = 0; i < inputs.length; i++) {
			// Get number of occurences of char inputs[i]
			int count = ++dictionary[inputs[i]];
			if (count > max) {
				max = count;
				// Remember int representation of char
				characterId = inputs[i];
			}
		}
		return (char) characterId;
	}

	public static void main(String[] args) {
		MostFrequentCharacter instance = new MostFrequentCharacter(
				"abcdeaabbccddee");
		Thread thread = new Thread(instance);
		thread.start();

	}
}
