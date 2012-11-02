package main.Combinatorics;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/*
 * O(2^n)
 */
public class Subsets {

	public static <T> List<Set<T>> bitRepresentationTrick(Set<T> originalSet) {
		List<Set<T>> result = new ArrayList<Set<T>>();

		int size = originalSet.size();
		List<T> originalList = new ArrayList<T>(originalSet);

		for (int i = 0; i < Math.pow(2, size); i++) {
			Set<T> set = new HashSet<T>();
			int temp = i;
			int j = 0;

			while (temp != 0) {
				if ((temp & (1 << j)) != 0) {
					temp ^= (1 << j);

					set.add(originalList.get(j));
				}

				j++;
			}

			result.add(set);
		}

		return result;
	}

	public static <T> List<Set<T>> bottomUp(Set<T> originalSet) {
		List<Set<T>> result = new ArrayList<Set<T>>();

		if (originalSet.isEmpty()) {
			result.add(new HashSet<T>());
			return result;
		}

		List<T> list = new ArrayList<T>(originalSet);

		T first = list.get(0);

		Set<T> remainder = new HashSet<T>(list.subList(1, list.size()));

		for (Set<T> without : bottomUp(remainder)) {
			Set<T> with = new HashSet<T>(without);
			with.add(first);

			result.add(without);
			result.add(with);
		}

		return result;
	}
}
