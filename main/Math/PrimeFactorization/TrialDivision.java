package main.Math.PrimeFactorization;
import java.util.*;

public class TrialDivision
{

	public ArrayList<Long> doPrimeFactorization(long x)
	{
		ArrayList<Long> factors = new ArrayList<Long>();
		long counter;

		while((x%2) == 0) {
			factors.add(new Long(2));
			x = x/2;
		}

		long i = 3;

		while(i < (x/2) + 1) {
			if((x % i) == 0) {
				factors.add(i);
				x = x/i;
			} else {
				i = i + 2;
			}
		}

		if (x > 1) {
			factors.add(x);
		}

		return factors;
	}
}
