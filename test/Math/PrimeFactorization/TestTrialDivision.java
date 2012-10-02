package test.Math.PrimeFactorization;

import java.util.*;
import main.Math.PrimeFactorization.TrialDivision;

public class TestTrialDivision {

	public static boolean success = true;

	public static void main(String[] args) {
		testOne(true);
		if (!success) {
			System.out.println("FAILED: TestTrialDivision");
			System.exit(1);
		} else {
			System.exit(0);
		}
	}

	public static void testOne(boolean printDebug) {
		TrialDivision pf = new TrialDivision();

		ArrayList<Long> factors = pf.doPrimeFactorization(2L);
		if (factors.size() != 1 || factors.get(0) != 2) {
			standardFactorsResult(printDebug, 2);
		}

		factors = pf.doPrimeFactorization(200560490130L);
		if (factors.size() != 11 || factors.get(0) != 2 || factors.get(1) != 3
				|| factors.get(2) != 5 || factors.get(3) != 7
				|| factors.get(4) != 11 || factors.get(5) != 13
				|| factors.get(6) != 17 || factors.get(7) != 19
				|| factors.get(8) != 23 || factors.get(9) != 29
				|| factors.get(10) != 31 || factors.size() != 11) {
			standardFactorsResult(printDebug, 200560490130L);
		}

		factors = pf.doPrimeFactorization(401120980260L);
		if (factors.size() != 12 || factors.get(0) != 2 || factors.get(1) != 2
				|| factors.get(2) != 3 || factors.get(3) != 5 || factors.get(4) != 7
				|| factors.get(5) != 11 || factors.get(6) != 13
				|| factors.get(7) != 17 || factors.get(8) != 19
				|| factors.get(9) != 23 || factors.get(10) != 29
				|| factors.get(11) != 31) {
			standardFactorsResult(printDebug, 401120980260L);
		}

		factors = pf.doPrimeFactorization(1087945631773L);
		if (factors.size() != 11 || factors.get(0) != 7 || factors.get(1) != 7
				|| factors.get(2) != 11 || factors.get(3) != 11
				|| factors.get(4) != 13 || factors.get(5) != 13
				|| factors.get(6) != 13 || factors.get(7) != 17
				|| factors.get(8) != 17 || factors.get(9) != 17
				|| factors.get(10) != 17) {
			standardFactorsResult(printDebug, 1087945631773L);
		}
	}

	private static void standardFactorsResult(boolean printDebug, long value) {
		success = false;
		if (printDebug) {
			System.out.println("FAILED: public ArrayList<Long> "
					+ "TrialDivision.doPrimeFactorization(long x)(" + value + ")");
		}
	}
}
