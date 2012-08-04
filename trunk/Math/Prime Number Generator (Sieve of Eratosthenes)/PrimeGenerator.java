import java.util.*;

public class PrimeGenerator
{
	
	/*
		This method doesn't cut off at the square root of n-1 because we want to
		grab all the primes and put them into a list, so we need to touch them at
		some point. The time complexity is still n*log(n), but if for whatever reason
		you don't need to pull all the primes into a list (e.g. you're looking for
		a specific prime) then make sure you add that simple optimization.
	*/
	
	boolean notPrime = true; //true is used as notPrime because false is default
	
	ArrayList<Integer> generate(int n)
	{
		boolean[] line = new boolean[n];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		if(n <= 2){
			System.err.println("n is too small, must be >2.");
			return null;
		}
		line[0] = notPrime; //Not really necessary, because they're out of scope of the loop
		line[1] = notPrime; //but they're also not prime.
		
		for(int i = 2; i < line.length; ++i)
		{
			if(line[i]) continue;
			for(int j = 2*i; j < line.length; j+=i)
			{
				line[j] = notPrime;
			}
			primes.add(new Integer(i));
		}
		return primes;
	}
}