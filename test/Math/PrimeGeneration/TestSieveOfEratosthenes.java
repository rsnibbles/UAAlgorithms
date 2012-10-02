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
		
		boolean[] primes = soe.generate(300000002);

		TrialDivision td = new TrialDivision();
		ArrayList<Long> factors;

		Random rand = new Random();
		
		for(int i = 0; i < 100; ++i) {
			int num = rand.nextInt(3000000) + 2;
			factors = td.doPrimeFactorization(num);

			if (primes[num] && factors.size() <= 1) {
				success = false;
				break;
			} else if (!primes[num] && factors.size() > 1) {
				success = false;
				break;
			}
		}
	}
}
