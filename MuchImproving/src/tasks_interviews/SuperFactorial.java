package tasks_interviews;

public abstract class SuperFactorial {
	public static long getFactorial(int x) {
		if (x == 1)
			return 1;

		int result = 1;

		for (int i = 2; i < x + 1; i++) {
			result = result * i;
		}

		return result;
	}

	public static long getSuperFactorial(int x) {
		if (x == 1)
			return 1;

		return getSuperFactorial(x - 1) * getFactorial(x);
	}

	public static long getSuperFactorial2(int x) {
		if (x == 0)
			return 0;
		if (x == 1)
			return 1;

		long result = 1;

		for (int i = 2; i < x + 1; i++) {
			result = result * getFactorial(i);
		}

		return result / (int) Math.pow(2, x - 1);
	}

	public static void main(String[] args) {
		System.out.println(getSuperFactorial(7));
	}
}
