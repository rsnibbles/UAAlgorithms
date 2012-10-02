package test.DivideAndConquerAlgorithms;

import main.DivideAndConquerAlgorithms.QuickSelect;
import java.util.*;

public class TestQuickSelect {

	private static boolean success = true;

	public static void main(String[] args) {
		testOne(true);
		testTwo(true);
		testThree(true);

		if (!success) {
			System.out.println("FAILED: TestQuickSelect");
			System.exit(1);
		} else {
			System.exit(0);
		}

	}

	public static void testOne(boolean printDebug) {
		ArrayList<Double> list = new ArrayList<Double>();

		list.add(1.0);
		list.add(2.0);
		list.add(3.0);

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 0) != 1) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 1) != 2) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 2) != 3) {
			success = false;
		}

	}

	public static void testTwo(boolean printDebug) {
		ArrayList<Double> list = new ArrayList<Double>();

		list.add(1.0);
		list.add(2.0);
		list.add(3.0);
		list.add(4.0);
		list.add(5.0);
		list.add(6.0);
		list.add(7.0);
		list.add(8.0);
		list.add(9.0);
		list.add(10.0);
		list.add(11.0);
		list.add(12.0);

		Collections.shuffle(list);

		if (QuickSelect.quickSelect(list, 0) != 1) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 1) != 2) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 2) != 3) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 3) != 4) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 4) != 5) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 5) != 6) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 6) != 7) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 7) != 8) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 8) != 9) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 9) != 10) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 10) != 11) {
			success = false;
		}

		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 11) != 12) {
			success = false;
		}
	}
	
	public static void testThree(boolean printDebug) {
		ArrayList<Double> list = new ArrayList<Double>();
		
		list.add(1.0);
		list.add(2.0);
		list.add(3.0);
		list.add(4.0);
		list.add(5.0);
		list.add(5.0);
		list.add(6.0);
		list.add(7.0);
		list.add(8.0);
		list.add(9.0);
		
		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 0) != 1) {
			success = false;
		}
		
		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 1) != 2) {
			success = false;
		}
		
		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 2) != 3) {
			success = false;
		}
		
		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 3) != 4) {
			success = false;
		}
		
		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 4) != 5) {
			success = false;
		}
		
		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 5) != 5) {
			success = false;
		}
		
		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 6) != 6) {
			success = false;
		}
		
		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 7) != 7) {
			success = false;
		}
		
		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 8) != 8) {
			success = false;
		}
		
		Collections.shuffle(list);
		
		if (QuickSelect.quickSelect(list, 9) != 9) {
			success = false;
		}
	}
}
