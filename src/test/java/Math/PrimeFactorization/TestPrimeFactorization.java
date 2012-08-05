import java.util.*;

public class TestPrimeFactorization implements TestAlg {
	public void runTest(boolean printDebug) {
		PrimeFactorization pf = new PrimeFactorization();

		ArrayList<Long> factors = pf.doPrimeFactorization(2L);

		if(factors.size() != 1 || factors.get(0) != 2){
			standardFactorsResult(printDebug);
		}

		factors = pf.doPrimeFactorization(200560490130L);

		Collections.sort(factors);

		if(factors.get(0) != 2 || factors.get(1) != 3 || factors.get(2) != 5 || factors.get(3) != 7 || factors.get(4) != 11
		|| factors.get(5) != 13 || factors.get(6) != 17 || factors.get(7) != 19 || factors.get(8) != 23
		|| factors.get(9) != 29 || factors.get(10) != 31 || factors.size() != 11){
			standardFactorsResult(printDebug);
		}

		factors = pf.doPrimeFactorization(401120980260L);

		Collections.sort(factors);

		if(factors.get(0) != 2 || factors.get(1) != 2 || factors.get(2) != 3 || factors.get(3) != 5 || factors.get(4) != 7
		|| factors.get(5) != 11 || factors.get(6) != 13 || factors.get(7) != 17 || factors.get(8) != 19
		|| factors.get(9) != 23 || factors.get(10) != 29 || factors.get(11) != 31 || factors.size() != 12){
			standardFactorsResult(printDebug);
		}

		factors = pf.doPrimeFactorization(1087945631773L);

		Collections.sort(factors);

		if(factors.get(0) != 7 || factors.get(1) != 7 || factors.get(2) != 11 || factors.get(3) != 11 || factors.get(4) != 13
		|| factors.get(5) != 13 || factors.get(6) != 13 || factors.get(7) != 17 || factors.get(8) != 17
		|| factors.get(9) != 17 || factors.get(10) != 17 || factors.size() != 11){
			standardFactorsResult(printDebug);
		}
	}

	private void standardFactorsResult(boolean printDebug){
		if(printDebug){
			System.out.println("FAILED: public ArrayList<Long> doPrimeFactorization(long x)");
		}
	}
}
