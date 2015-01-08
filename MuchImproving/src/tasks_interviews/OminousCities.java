package tasks_interviews;

public class OminousCities {

	public static void main(String[] args) {
		String[] cities = new String[] { "e", "ee", "te", "testttatt",
				"terefg", "test", "tes", "ttstt", "rrsrr", "F", "Ff" };
		String homeCity = "q";

		System.out.println(findOptimalCity(homeCity, cities));
	}

	public static String findOptimalCity(String homeCity, String[] cities) {
		if (homeCity == "" || cities.length == 1)
			return "NOT_FOUND";

		double homeRating = getRating(homeCity);
		double min = 0.0;
		String vacationCity = "";

		for (String city : cities) {
			if (city.compareTo(homeCity) != 0) {
				min = Math.abs(getRating(city) - homeRating);
				vacationCity = city;
				break;
			}
		}

		for (String city : cities) {
			if (city.compareTo(homeCity) == 0)
				continue;
			if (Math.abs(getRating(city) - homeRating) < min) {
				min = Math.abs(getRating(city) - homeRating);
				vacationCity = city;
			}
		}
		return vacationCity;
	}

	private static double getRating(String str) {
		str = str.toLowerCase();
		double consonantsNumber = 0;
		double vowelsNumber = 0;

		for (int i = 0; i < str.length(); i++) {
			if (isVowel(str.charAt(i)))
				vowelsNumber++;
			else
				consonantsNumber++;
		}

		if (vowelsNumber == 0)
			vowelsNumber = 0.01;

		return consonantsNumber / vowelsNumber;
	}

	private static Boolean isVowel(char letter) {
		final String vowels = "AEIOUaeiou";
		if (vowels.indexOf(letter) == -1)
			return false;
		return true;
	}

}
