package main.DivideAndConquerAlgorithms;

import java.util.*;

public class QuickSelect {
	/*
	 * Select the kth lowest value in an unsorted array in O(n) time. The list is zero based.
	 */
	public static double quickSelect(ArrayList<Double> list, int k) {
		int left = 0;
		int right = list.size() - 1;

		while (true) {
			int pivotNewIndex = partition(list, left, right, (left + right) / 2);

			if (pivotNewIndex == k) {
				return list.get(pivotNewIndex);
			} else if (k < pivotNewIndex) {
				right = pivotNewIndex - 1;
			} else {
				left = pivotNewIndex + 1;
			}
		}
	}

	private static int partition(ArrayList<Double> list, int left, int right, int pivotIndex) {
		double pivotVal = list.get(pivotIndex);
		
		Collections.swap(list, pivotIndex, right);
		int storeIndex = left;

		for (int i = left; i < right; ++i) {
			if (list.get(i) <= pivotVal) {
				Collections.swap(list, i, storeIndex);
				++storeIndex;
			}
		}

		Collections.swap(list, storeIndex, right);

		return storeIndex;
	}
}
