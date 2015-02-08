package tasks_topcoder;

public class Main {

	public static void main(String[] args) {
		BinaryCode code = new BinaryCode();
		String[] test = code.decode("232");

		for (String str : test)
			System.out.println(str);

	}

}
