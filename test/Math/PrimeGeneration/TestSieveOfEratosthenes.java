package test.Math.PrimeGeneration;
import java.util.*;
import main.Math.PrimeGeneration.SieveOfEratosthenes;
import main.Math.PrimeFactorization.TrialDivision;

public class TestSieveOfEratosthenes
{
	public static boolean success = true;
	public static void main(String[] args)
	{
		testOne(true);
		if(!success)
		{
			System.out.println("FAILED: TestSieveOfEratosthenes");
			System.exit(1);
		}
		else
		{
			System.exit(0);
		}
	}

	public static void testOne(boolean printDebug)
	{
		SieveOfEratosthenes soe = new SieveOfEratosthenes();
		
		ArrayList<Integer> primes = soe.generate(300000000);

		TrialDivision td = new TrialDivision();
		ArrayList<Long> factors;

		for(int i = 0; i < 5; ++i) {
			factors = td.doPrimeFactorization(primes.get(i));

			if (factors.size() > 1) {
				success = false;
				break;
			}
		}
	}
}
