package test.Math.GreatestCommonDenominator;

import java.util.*;
import main.Math.GreatestCommonDenominator.GCD;

public class TestGCD {
	public static boolean success = true;
	
	public static void main(String[] args) {
		testOne();
		
		if (!success) {
			System.out.println("FAILED: TestGCD");
			System.exit(1);
		}
		else {
			System.exit(0);
		}
	}

	public static void testOne() {
		if (GCD.EuclidGCD(1989, 867) != 51) {
			success = false;
		}
		
		if (GCD.EuclidGCD(54, 24) != 6) {
			success = false;
		}
		
		if (GCD.EuclidGCD(4, 2) != 2) {
			success = false;
		}
		
		if (GCD.EuclidGCD(1234567, 9876) != 1) {
			success = false;
		}
		
		if (GCD.EuclidGCD(987654321, 234657) != 9) {
			success = false;
		}
	}
}
