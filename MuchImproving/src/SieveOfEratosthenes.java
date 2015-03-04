public class SieveOfEratosthenes {

	public static int countPrimes(int num) {
		int result = 0;
		Boolean[] primes = new Boolean[num + 1];

		for (int i = 2; i < primes.length; i++)
			primes[i] = true;

		for (int i = 2; i < Math.sqrt(num); i++)
			if (primes[i] == true)
				for (int j = i * i; j <= num; j += i)
					primes[j] = false;

		for (int i = 2; i < primes.length; i++)
			if (primes[i] == true)
				result++;
		return result;
	}
}