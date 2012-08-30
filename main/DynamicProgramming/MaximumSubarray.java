package main.DynamicProgramming;
import java.util.*;

public class MaximumSubarray {
	public ArrayList<Long> findMaximumSubarray(long[] list) {
		long max = list[0];
		int maxStart = 0;
		int maxEnd = 0;
		int currentStart = 0;
		int currentEnd = 0;
		long current = list[0];
		
		for (int i = 1; i < list.length; ++i) {
			if (list[i] < current + list[i]) {
				currentEnd = i;
				current += list[i];

			}
			else {
				current = list[i];
				currentStart = i;
				currentEnd = i;
			}
			
			if (current > max) {
					max = current;
					maxStart = currentStart;
					maxEnd = currentEnd;
			}
		}
		
		ArrayList<Long> subArray = new ArrayList<Long>();
		
		for (int i = maxStart; i <= maxEnd; ++i) {
			subArray.add(new Long(list[i]));
		}
		
		return subArray;
	}
	
	public long findMaximumSubarrayValue(long[] list) {
		long max = list[0];
		long current = list[0];
		
		for (int i = 1; i < list.length; ++i) {
			if (list[i] < current + list[i]) {
				current += list[i];
			}
			else {
				current = list[i];
			}
			
			max = current > max ? current : max;
		}
		
		return max;
	}
}
