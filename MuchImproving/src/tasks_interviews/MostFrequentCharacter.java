package tasks_interviews;

public abstract class MostFrequentCharacter {

	public static char getMostFrequentChar(String input) {
		if (input == "")
			return (char) Integer.MIN_VALUE;

		char[] inputs = input.toCharArray();
		int[] dictionary = new int[128];
		int max = dictionary[0];
		int characterId = 0;

		for (int i = 0; i < inputs.length; i++) {
			int count = ++dictionary[inputs[i]];
			if (count > max) {
				max = count;
				characterId = inputs[i];
			}
		}
		return (char) characterId;
	}

	public static void main(String[] args) {
		assert (getMostFrequentChar("aaabbbcde") != 'x') != true;
	}

}
