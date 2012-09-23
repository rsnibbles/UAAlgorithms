package test.GraphAlgorithms.PathFinding;

import java.util.*;
import main.GraphAlgorithms.PathFinding.Floyds;

public class TestFloyds {

	public static boolean success = true;

	public static void main(String[] args) {
		testOne(false);
		if (!success) {
			System.out.println("FAILED: TestFloyds");
			System.exit(1);
		} else {
			System.exit(0);
		}
	}

	/*
	 Input Matrix:
	 0 | 1 | 2 | 3 | 4 | 5
	 1 | 0 | 1 | I | 5 |100
	 ~ |~~~|~~~|~~~|~~~|~~~
	 2 | 1 | 0 |100| 3 | 7
	 ~ |~~~|~~~|~~~|~~~|~~~
	 3 | I |100| 0 |100| 5
	 ~ |~~~|~~~|~~~|~~~|~~~
	 4 | 5 | 3 |100| 0 |100
	 ~ |~~~|~~~|~~~|~~~|~~~
	 5 |100| 7 | 5 |100| 0 
		
	 Solution Matrix:
	 0 | 1 | 2 | 3 | 4 | 5
	 1 | 0 | 1 | 13| 4 | 8
	 ~ |~~~|~~~|~~~|~~~|~~~
	 2 | 1 | 0 | 12| 3 | 7
	 ~ |~~~|~~~|~~~|~~~|~~~
	 3 | 13| 12| 0 | 15| 5
	 ~ |~~~|~~~|~~~|~~~|~~~
	 4 | 4 | 3 | 15| 0 | 10
	 ~ |~~~|~~~|~~~|~~~|~~~
	 5 | 8 | 7 | 5 | 10| 0 
	 */
	public static void testOne(boolean printDebug) {
		int I = Integer.MAX_VALUE;
		int[][] testMatrix = {{0, 1, I, 5, 100}, {1, 0, 100, 3, 7}, {I, 100, 0, 100, 5}, {5, 3, 100, 0, 100}, {100, 7, 5, 100, 0}};
		int[][] solMatrix = {{0, 1, 13, 4, 8}, {1, 0, 12, 3, 7}, {13, 12, 0, 15, 5}, {4, 3, 15, 0, 10}, {8, 7, 5, 10, 0}};
		int n = 5;
		int[][] result = new int[5][5];

		Floyds fyd = new Floyds();
		result = fyd.floyds(testMatrix);

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (result[i][j] != solMatrix[i][j]) {
					success = false;
				}
			}
		}

		if (printDebug) {
			printArray(result);
			System.out.println();
			printArray(solMatrix);
		}
	}

	public static void printArray(int[][] array) {
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < array.length; ++j) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
