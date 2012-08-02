import java.util.*;

public class PrimeFactorization
{
	long[] doPrimeFactorization(long x)
	{
		ArrayList<Long> factors = new ArrayList<Long>();
		long counter;

		while((x%2) == 0) {
			factors.add(2);
			x = x/2;
		}

		i = 3;

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
