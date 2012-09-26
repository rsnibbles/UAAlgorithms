package main.Math.GreatestCommonDenominator;

import java.util.*;

public class GCD {
	/* r0 >= r1 Must be true. Swap values if needed
	 * 
	 */
	public static int EuclidGCD(int r0, int r1) {
		int r2 = r0 % r1;
		
		while (r2 != 0) {
			r0 = r1;
			r1 = r2;
			r2 = r0 % r1;
		}

		return r1;
	}
}
