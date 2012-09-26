package main.Math.LeastCommonMultiple;

public class LCM {	
	public static long lcm(long a, long b) {
		if (a < b) {
			long temp = a;
			a = b;
			b = temp;
		}
		
		long num1 = a;
		long num2 = b;

		long c = a % b;

		while (c != 0) {
			a = b;
			b = c;
			c = a % b;
		}

		return (num1 / b) * num2;
	}
}
