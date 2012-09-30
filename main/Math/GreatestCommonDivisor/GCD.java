//Time complexity O(logn) where n is the number of logarithm operations
package main.Math.GreatestCommonDivisor;

public class GCD {
	public static long EuclidGCD(long r0, long r1) {
		long r2 = r0 % r1;
		
		while (r2 != 0) {
			r0 = r1;
			r1 = r2;
			r2 = r0 % r1;
		}

		return r1;
	}
}

