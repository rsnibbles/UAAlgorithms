package main.Combinatorics;

import java.util.ArrayList;

/*
 * k * n // building initial a....
 */
public class DeBruijn {
	public static ArrayList<Integer> deBruijn(int k, int n) {
		ArrayList<Integer> a = new ArrayList<Integer>(k * n),
			sequence = new ArrayList<Integer>(k * n);
		for(int i = 0; i < k * n; ++i)
			a.add(0);
		deBruijn_h(1, 1, k, n, a, sequence);
		return sequence;
	}

	private static void deBruijn_h(int t, int p, int k, int n,
			ArrayList<Integer> a, ArrayList<Integer> sequence) {
		if(t > n) {
			if(n % p == 0)
				for(int j = 1; j < p + 1; ++j)
					sequence.add(a.get(j));
		} else {
			a.set(t, a.get(t - p));
			deBruijn_h(t + 1, p, k, n, a, sequence);
			for(int j = a.get(t - p) + 1; j < k; ++j) {
				a.set(t, j);
				deBruijn_h(t + 1, t, k, n, a, sequence);
			}
		}
	}
}
