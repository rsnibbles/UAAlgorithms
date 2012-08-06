package test.Math.PrimeGeneration;
import java.util.*;
import main.Math.PrimeGeneration.SieveOfEratosthenes;

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
		SieveOfEratosthenes pf = new SieveOfEratosthenes();
		success = false;
	}
}
