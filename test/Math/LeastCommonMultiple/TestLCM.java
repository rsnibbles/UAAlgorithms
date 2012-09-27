package test.Math.LeastCommonMultiple;

import main.Math.LeastCommonMultiple.LCM;

public class TestLCM {
	public static boolean success = true;

	public static void main(String[] args) {
		testOne(true);

		if (!success) {
			System.out.println("FAILED: TestLCM");
			System.exit(1);
		}
		else {
			System.exit(0);
		}
	}

	public static void testOne(boolean printDebug) {
		if (LCM.lcm(20, 30) != 60) {
			success = false;
		}
		
		if (LCM.lcm(123456, 98765) != 12193131840l) {
			success = false;
		}
		
		if (LCM.lcm(99999999, 8888888) != 888888791111112l) {
			success = false;
		}
		
		if (LCM.lcm(2, 2) != 2) {
			success = false;
		}
		
		if (LCM.lcm(2, 3) != 6) {
			success = false;
		}
		
		if (LCM.lcm(200000000000l, 300000000000l) != 600000000000l) {
			success = false;
		}
		
		if (LCM.lcm(Long.MAX_VALUE, 1) != Long.MAX_VALUE) {
			success = false;
		}
		
		if (LCM.lcm(Long.MAX_VALUE, Long.MAX_VALUE) != Long.MAX_VALUE) {
			success = false;
		}
		
		if (LCM.lcm(17, 70) != 1190) {
			success = false;
		}
		
		if (LCM.lcm(10000001, 10000000) != 100000010000000l) {
			success = false;
		}
	}
}
