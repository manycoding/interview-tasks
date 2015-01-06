package algorithms;

public class Quicksort {
	int numbers[];

	public void sort(int[] inputs) {
		if (inputs == null || inputs.length == 0)
			return;

		this.numbers = inputs;
		quicksort(0, inputs.length - 1);
	}

	private void quicksort(int low, int high) {
		int i = low;
		int j = high;

		int pivot = numbers[(low + high) / 2];

		while (i <= j) {
			while (numbers[i] < pivot)
				i++;
			while (numbers[j] > pivot)
				j--;

			if (i <= j) {
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;

				i++;
				j--;
			}
		}

		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}
}
