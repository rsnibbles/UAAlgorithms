package main.DynamicProgramming;

import java.util.*;

/*
 * O(nm) where n is number of items and m is the total capacity
 */
public class Knapsack {
	public long knapsack(ArrayList<Item> items, int cap) {
		long[][] backpack = new long[items.size()][cap + 1];
		
		for (int i = 0; i < items.size(); ++i) {
			Item c = items.get(i);
			
			// assumes no items are of weight zero
			for (int j = 1; j < cap + 1; ++j) {
				// first item
				if (i == 0) {
					// item fits
					if (j - c.weight >= 0) {
						backpack[i][j] = c.value;
					// item does not fit
					} else {
						backpack[i][j] = 0;
					}		
				} else {
					// item fits
					if (j - c.weight >= 0) {
						long back = backpack[i][j - 1];
						long up = backpack[i - 1][j];
						long diag = c.value + backpack[i - 1][j - c.weight];
						
						backpack[i][j] = Math.max(back, Math.max(up, diag));
					}
					else {
						backpack[i][j] = backpack[i - 1][j];
					}
				}
			}
		}
		
		return backpack[items.size() - 1][cap];
	}
	
	public class Item {
		public long value;
		public int weight;
		
		public Item( int w, long v) {
			value = v;
			weight = w;
		}
	}
}
