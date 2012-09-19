import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class Permutations
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		while(true)
		{
			System.out.println("Which algo?  1 = BottomUp, 2 = BottomUpMinChange, 3 = JohnsonTrotter, 4 = Lexicographic, 0 = Quit");
			int w = scan.nextInt();
			if(w == 0) return;

			System.out.println("How many items?");
			int n = scan.nextInt();

			boolean print = false;

			System.out.println("Print results (y means yes)?");
			String s = scan.next();
			if(s.equals("y"))
				print = true;
			

			List<String> list = new ArrayList<String>();

			for(int i = 0; i < n; i++)
				list.add((char)('A' + i) + "");

			List<List<String>> result = new ArrayList<List<String>>();

			long startTime = System.currentTimeMillis();

			switch(w)
			{
				case 1:
					result = BottomUp(list);
					break;				
				case 2:
					result = BottomUpMinChange(list);
					break;				
				case 3:
					result = JohnsonTrotter(list);
					break;				
				case 4:
					result = lexicographic(list);
					break;
			}

			long stopTime = System.currentTimeMillis();

			if(print)
			{
				for(List<String> permutation : result)
				{
					System.out.print("Result:  { ");
					for(String x : permutation)
					{
						System.out.print(x + " ");
					}
					System.out.println("}");
				}
			}	

			System.out.println("Time:  " + (stopTime - startTime));
		}
	}

	public static <T> List<List<T>> BottomUp(List<T> items)
	{
		List<List<T>> results = new ArrayList<List<T>>();

		List<T> initial = new ArrayList<T>();
		initial.add(items.get(0));

		results.add(initial);

		for(int i = 1; i < items.size(); i++)
		{
			List<List<T>> nextLengthResults = new ArrayList<List<T>>();

			for(List<T> permutation : results)
			{
				for(int j = 0; j <= permutation.size(); j++)
				{
					ArrayList<T> tempPerm = new ArrayList<T>(permutation);

					tempPerm.add(j, items.get(i));

					nextLengthResults.add(tempPerm);
				}
			}
			results = nextLengthResults;
		}
		return results;
	}

	public static <T> List<List<T>> BottomUpMinChange(List<T> items)
	{
		List<List<T>> results = new ArrayList<List<T>>();

		List<T> initial = new ArrayList<T>();
		initial.add(items.get(0));

		results.add(initial);

		for(int i = 1; i < items.size(); i++)
		{
			List<List<T>> nextLengthResults = new ArrayList<List<T>>();
			boolean rightToLeft = true;

			for(List<T> permutation : results)
			{
				int increment = rightToLeft ? -1 : 1;
				int start = rightToLeft ? permutation.size() : 0;
				int stopper = rightToLeft ? -1 : permutation.size()+1;				

				for(int j = start; j != stopper; j += increment)
				{
					ArrayList<T> tempPerm = new ArrayList<T>(permutation);

					tempPerm.add(j, items.get(i));

					nextLengthResults.add(tempPerm);
				}

				rightToLeft = !rightToLeft;			
			}

			results = nextLengthResults;

		}
		return results;
	}

	public static <T> List<List<T>> JohnsonTrotter(List<T> items)
	{
		List<List<T>> result = new ArrayList<List<T>>();

		int n = items.size();

		Integer[] permutation = new Integer[n];
		for(int i = 0; i < n; i++) { permutation[i] = i; }

		boolean[] arrows = new boolean[n]; // false means left arrow
		
		while(true)
		{
			result.add(new ArrayList<T>(items));

			// Find largest mobile arrow
			int largestMobile = -1;
			int largestMobileIndex = -1;

			for(int i = 0; i < n; i++)
			{
				if(permutation[i] > largestMobile && isMobile(permutation, arrows, i))
				{
					largestMobileIndex = i;
					largestMobile = permutation[i];
				}
			}

			if(largestMobileIndex == -1) break;

			int swapIndex = largestMobileIndex + (arrows[largestMobileIndex] ? 1 : -1);

			int temp = permutation[largestMobileIndex];
			permutation[largestMobileIndex] = permutation[swapIndex];
			permutation[swapIndex] = temp;

			boolean temp2 = arrows[largestMobileIndex];
			arrows[largestMobileIndex] = arrows[swapIndex];
			arrows[swapIndex] = temp2;

			Collections.swap(items, swapIndex, largestMobileIndex);

			for(int i = 0; i < n; i++)
			{
				if(permutation[i] > largestMobile)
				{
					arrows[i] = !arrows[i];
				}
			}
		}

		return result;
	}

	public static <T> List<List<T>> lexicographic(List<T> items)
	{
		List<List<T>> result = new ArrayList<List<T>>();

		int n = items.size();
		result.add(new ArrayList<T>(items));

		Integer[] current = new Integer[n];
		for(int i = 0; i < n; i++) { current[i] = i; }

		while(getNext(current, items))
		{
			result.add(new ArrayList<T>(items));
		}

		return result;
	}

	public static <T> boolean getNext(Integer[] Value, List<T> items)
	{
		int N = items.size();
		int i = N - 1;

		if(i-1 < 0) return false;

		while (Value[i-1] >= Value[i]) 
		{
			i = i-1;
			if(i-1 < 0) return false;
		}

		int j = N;
		while (Value[j-1] <= Value[i-1]) j = j-1;

		// swap values at positions (i-1) and (j-1)
		int temp = Value[i-1];
  		Value[i-1] = Value[j-1];
		Value[j-1] = temp;  
		Collections.swap(items, i-1, j-1);

  		i++; j = N;

  		while (i < j)
  		{
			// swap values at positions (i-1) and (j-1)

			int temp2 = Value[i-1];
  			Value[i-1] = Value[j-1];
			Value[j-1] = temp2;  
			Collections.swap(items, i-1, j-1);

    			i++; j--;
  		}

		return true;
	}

	public static boolean isMobile(Integer[] permutation, boolean[] arrows, int index)
	{
		if(index == 0 && !arrows[index])
		{
			return false;
		}
		if(index == permutation.length - 1 && arrows[index])
		{
			return false;
		}

		int thisNum = permutation[index];
		int compareNum = permutation[index + (arrows[index] ? 1 : -1)];

		return thisNum > compareNum;
	}
}
