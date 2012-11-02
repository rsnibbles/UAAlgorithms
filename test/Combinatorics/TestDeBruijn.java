package test.Combinatorics;
import java.util.ArrayList;
import main.Combinatorics.DeBruijn;

public class TestDeBruijn {
	public static boolean success = false;

	public static boolean equal(ArrayList<Integer> a, ArrayList<Integer> b) {
		if(a.size() != b.size())
			return false;
		for(int i = 0; i < a.size(); ++i)
			if(a.get(i) != b.get(i))
				return false;
		return true;
	}

	public static void main(String[] args) {
		success = true;

		testOne(true);
		testTwo(true);

		if (!success) {
			System.out.println("FAILED: TestDeBruijn");
			System.exit(1);
		}
		else {
			System.exit(0);
		}
	}
	
	public static void testOne(boolean printDebug) {
		ArrayList<Integer> seq = DeBruijn.deBruijn(2, 3);
		ArrayList<Integer> correct = new ArrayList<Integer>();
		correct.add(0);
		correct.add(0);
		correct.add(0);
		correct.add(1);
		correct.add(0);
		correct.add(1);
		correct.add(1);
		correct.add(1);

		success &= equal(correct, seq);
	}

	public static void testTwo(boolean printDebug) {
		ArrayList<Integer> seq = DeBruijn.deBruijn(2, 2);
		ArrayList<Integer> correct = new ArrayList<Integer>();
		correct.add(0);
		correct.add(0);
		correct.add(1);
		correct.add(1);

		success &= equal(correct, seq);
	}
}
