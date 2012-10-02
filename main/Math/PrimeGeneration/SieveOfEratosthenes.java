package main.Math.PrimeGeneration;

import java.util.*;

public class SieveOfEratosthenes {

	/*
	This method doesn't cut off at the square root of n-1 because we want to
	grab all the primes and put them into a list, so we need to touch them at
	some point. The time complexity is still n*log(n), but if for whatever reason
	you don't need to pull all the primes into a list (e.g. you're looking for
	a specific prime) then make sure you add that simple optimization.
	 */
	public boolean[] generate(int n) {
		boolean[] primeList = new boolean[n + 1];

		if (n <= 2) {
			return null;
		}

		primeList[0] = true; //Not really necessary, because they're out of scope of the loop
		primeList[1] = true; //but they're also not prime.

		for (int i = 2; i * i <= n; ++i) {
			if (!primeList[i]) {
				for (int j = i; i * j <= n; ++j) {
					primeList[i * j] = true;
				}
			}
		}
		
		return primeList;
	}
}
