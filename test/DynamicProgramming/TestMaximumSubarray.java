package test.DynamicProgramming;
import java.util.*;
import main.DynamicProgramming.MaximumSubarray;

public class TestMaximumSubarray {
	
	private static boolean success = true;
	public static void main(String[] args) {
		testOne(true);

		if (!success) {
			System.out.println("FAILED: TestMaximumSubarray");
			System.exit(1);
		}
		else {
			System.exit(0);
		}
	
	}

	public static void testOne(boolean printDebug) {
		MaximumSubarray ms = new MaximumSubarray();
		
		long[] list1 = {1, 2, 3};
		long[] list2 = {1, -2, 3, 4, -7};
		long[] list3 = {1, -2, 3, 4, -1, 8, 6, -3};
		long[] list4 = {-10, -2, -3, -4, -11, -8, -6, -3};
		long[] list5 = {10, -2, -3, -4, -11, -8, -6, -3};
		long[] list6 = {-10, -2, -3, -4, -11, -8, -6, 3};
		long[] list7 = {10};
		long[] list8 = {-10};
		
		ArrayList<Long> List1 = ms.findMaximumSubarray(list1);
		ArrayList<Long> List2 = ms.findMaximumSubarray(list2);
		ArrayList<Long> List3 = ms.findMaximumSubarray(list3);
		ArrayList<Long> List4 = ms.findMaximumSubarray(list4);
		ArrayList<Long> List5 = ms.findMaximumSubarray(list5);
		ArrayList<Long> List6 = ms.findMaximumSubarray(list6);
		ArrayList<Long> List7 = ms.findMaximumSubarray(list7);
		ArrayList<Long> List8 = ms.findMaximumSubarray(list8);
		
		if (List1.size() != 3) {
			success = false;
			return;
		}

		if (List2.size() != 2) {
			success = false;
			return;
		}

		if (List3.size() != 5) {
			success = false;
			return;
		}

		if (List4.size() != 1) {
			success = false;
			return;
		}

		if (List5.size() != 1) {
			success = false;
			return;
		}

		if (List6.size() != 1) {
			success = false;
			return;
		}

		if (List7.size() != 1) {
			success = false;
			return;
		}

		if (List8.size() != 1) {
			success = false;
			return;
		}

		for (int i = 0; i < List1.size(); ++i) {
			if (!List1.get(i).equals(new Long(list1[i]))) {
				success = false;
				return;
			}
		}


		for (int i = 0; i < List2.size(); ++i) {
			if (!List2.get(i).equals(new Long(list2[i + 2]))) {
				success = false;
				return;
			}
		}

		for (int i = 0; i < List3.size(); ++i) {
			if (!List3.get(i).equals(new Long(list3[i + 2]))) {
				success = false;
				return;
			}
		}

		if (!List4.get(0).equals(new Long(-2))) {
			success = false;
			return;
		}

		if (!List5.get(0).equals(new Long(10))) {
			success = false;
			return;
		}

		if (!List6.get(0).equals(new Long(3))) {
			success = false;
			return;
		}

		if (!List7.get(0).equals(new Long(10))) {
			success = false;
			return;
		}

		if (!List8.get(0).equals(new Long(-10))) {
			success = false;
			return;
		}

		if (ms.findMaximumSubarrayValue(list1) != 6) {
			success = false;
			return;
		}

		if (ms.findMaximumSubarrayValue(list2) != 7) {
			success = false;
			return;
		}

		if (ms.findMaximumSubarrayValue(list3) != 20) {
			success = false;
			return;
		}

		if (ms.findMaximumSubarrayValue(list4) != -2 ) {
			success = false;
			return;
		}

		if (ms.findMaximumSubarrayValue(list5) != 10) {
			success = false;
			return;
		}

		if (ms.findMaximumSubarrayValue(list6) != 3) {
			success = false;
			return;
		}

		if (ms.findMaximumSubarrayValue(list7) != 10) {
			success = false;
			return;
		}

		if (ms.findMaximumSubarrayValue(list8) != -10) {
			success = false;
			return;
		}
	}
}
