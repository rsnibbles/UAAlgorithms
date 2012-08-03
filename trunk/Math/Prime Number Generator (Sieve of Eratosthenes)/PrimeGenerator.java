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
	
	ArrayList<Integer> generate(int n)
	{
		int[] line = new int[n];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		if(n <= 2){
			System.err.println("n is too small, must be >2.");
			return null;
		}
		line[0] = 1; //Not really necessary, because they're out of scope of the loop
		line[1] = 1; //but they're also not prime.
		
		for(int i = 2; i < line.length; ++i)
		{
			if(line[i] != 0) continue;
			for(int j = 2*i; j < line.length; j+=i)
			{
				line[j] = 1;
			}
			primes.add(new Integer(line[i]));
		}
		return primes;
	}
}