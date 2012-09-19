import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Subsets
{
        public static void main(String[] args)
        {
                Scanner scan = new Scanner(System.in);

                while(true)
                {
                        System.out.println("Which algo?  1 = BottomUp, 2 = bitRepresentationTrick, 0 = Quit");
                        int w = scan.nextInt();
                        if(w == 0) return;

                        System.out.println("How many items?");
                        int n = scan.nextInt();

                        boolean print = false;

                        System.out.println("Print results (y means yes)?");
                        String s = scan.next();
                        if(s.equals("y"))
                                print = true;

                        Set<Integer> list = new HashSet<Integer>();

                        for(int i = 0; i < n; i++)
                                list.add((i+1));

                        List<Set<Integer>> result = new ArrayList<Set<Integer>>();

                        long startTime = System.currentTimeMillis();

                        switch(w)
                        {
                                case 1:
                                        result = bottomUp(list);
                                        break;
                                case 2:
                                        result = bitRepresentationTrick(list);
                                        break;
                        }

                        long stopTime = System.currentTimeMillis();

                        if(print)
                        {
                                for(Set<Integer> subset : result)
                                {
                                        System.out.print("Result:  { ");
                                        for(Integer x : subset)
                                        {
                                                System.out.print(x + " ");
                                        }
                                        System.out.println("}");
				}
			}

			System.out.println("Time:  " + (stopTime - startTime));
		}
	}

	public static <T> List<Set<T>> bitRepresentationTrick(Set<T> originalSet)
	{
		List<Set<T>> result = new ArrayList<Set<T>>();

		int size = originalSet.size();
		List<T> originalList = new ArrayList<T>(originalSet);

		for(int i = 0; i < Math.pow(2, size); i++)
		{
			Set<T> set = new HashSet<T>();
			int temp = i;
			int j = 0;

			while(temp != 0)
			{
				if((temp & (1 << j)) != 0)
				{
					temp ^= (1 << j);

					set.add(originalList.get(j));
				}				

				j++;
			}

			result.add(set);
		}

		return result;
	}


	public static <T> List<Set<T>> bottomUp(Set<T> originalSet)
	{
		List<Set<T>> result = new ArrayList<Set<T>>();

		if(originalSet.size() == 0)
		{
			result.add(new HashSet<T>());
			return result;
		}

    		List<T> list = new ArrayList<T>(originalSet);

    		T first = list.get(0);

    		Set<T> remainder = new HashSet<T>(list.subList(1, list.size())); 

		for (Set<T> without : bottomUp(remainder)) 
		{
        		Set<T> with = new HashSet<T>(without);
			with.add(first);

        		result.add(without);
        		result.add(with);
    		}           

    		return result;
	}
}
