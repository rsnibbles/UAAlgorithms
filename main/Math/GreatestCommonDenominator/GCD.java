package main.Math.GreatestCommonDenominator;

import java.util.*;

public class GCD {
	public static int EuclidGCD(int r0, int r1) {
		if (r0 < r1) {
			int temp = r0;
			r0 = r1;
			r1 = temp;
		}
		
		int r2 = r0 % r1;
		
		while (r2 != 0) {
			r0 = r1;
			r1 = r2;
			r2 = r0 % r1;
		}

		return r1;
	}
}
