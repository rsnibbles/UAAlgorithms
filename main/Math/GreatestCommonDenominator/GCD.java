package main.Math.GreatestCommonDenominator;

import java.util.*;

public class GCD {
	/* r0 >= r1 Must be true. Swap values if needed
	 * 
	 */
	public static int EuclidGCD(int r0, int r1) {
		/*
		 * only runs on the first iteration.
		 * 
		 * if (r0 < r1) {
		 *     int temp = r1;
		 *	   r1 = r0;
		 *	   r0 = temp;
		 * }
		 */
		
		int r3 = r0 % r1;

		if (r3 == 0 ) {
			return r1;
		}
		else {
			return EuclidGCD(r1, r3);
		}
	}
}
