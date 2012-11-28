package main.DynamicProgramming;
import java.util.*;

public class MaximumSubarray {
	public ArrayList<Long> findMaximumSubarray(long[] list) {
		long max = list[0];
		int maxStart = 0;
		int maxEnd = 0;
		int currentMaxStart = 0;
		int currentMaxEnd = 0;
		long currentMax = list[0];
		
		for (int i = 1; i < list.length; ++i) {
			if (currentMax > 0) {
				currentMaxEnd = i;
				currentMax += list[i];

			}
			else {
				currentMax = list[i];
				currentMaxStart = i;
				currentMaxEnd = i;
			}
			
			if (currentMax > max) {
				max = currentMax;
				maxStart = currentMaxStart;
				maxEnd = currentMaxEnd;
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
		long currentMax = list[0];
		
		for (int i = 1; i < list.length; ++i) {
			if (currentMax > 0) {
				currentMax += list[i];
			}
			else {
				currentMax = list[i];
			}
			
			max = Math.max(currentMax, max);
		}
		
		return max;
	}
}
