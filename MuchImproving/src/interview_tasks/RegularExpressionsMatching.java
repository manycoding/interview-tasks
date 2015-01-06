package interview_tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsMatching {

	public static void main(String[] args) {

		System.out.println(testHarness("cat*cat", "ccat"));
	}

	private static boolean testHarness(String patt, String str) {
		Pattern pattern = Pattern.compile(patt);
		Matcher matcher = pattern.matcher(str);

		return matcher.find();
	}
}
