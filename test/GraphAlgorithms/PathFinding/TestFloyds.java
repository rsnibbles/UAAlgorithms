package test.GraphAlgorithms.PathFinding;

import java.util.*;
import main.GraphAlgorithms.PathFinding.Floyds;

public class TestFloyds {

	public static boolean success = true;

	public static void main(String[] args) {
		testOne(false);
		testTwo(false);
		
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
		final int I = Integer.MAX_VALUE;
		int[][] testMatrix = {
			{0, 1, I, 5, 100}, 
			{1, 0, 100, 3, 7}, 
			{I, 100, 0, 100, 5}, 
			{5, 3, 100, 0, 100}, 
			{100, 7, 5, 100, 0}};
		int[][] solMatrix = {
			{0, 1, 13, 4, 8}, 
			{1, 0, 12, 3, 7}, 
			{13, 12, 0, 15, 5}, 
			{4, 3, 15, 0, 10}, 
			{8, 7, 5, 10, 0}};
		
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
	
	public static void testTwo(boolean printDebug) {
		final int I = Integer.MAX_VALUE;
		
		Floyds fyd = new Floyds();
		Integer[][] test = {
			{0, 1, I, 5, 100}, 
			{1, 0, 100, 3, 7}, 
			{I, 100, 0, 100, 5}, 
			{5, 3, 100, 0, 100}, 
			{100, 7, 5, 100, 0}};
		int[][] solMatrix = {
			{0, 1, 13, 4, 8}, 
			{1, 0, 12, 3, 7}, 
			{13, 12, 0, 15, 5}, 
			{4, 3, 15, 0, 10}, 
			{8, 7, 5, 10, 0}};
		
		Floyds.Node[][] testMatrix = new Floyds.Node[5][5];
		
		for (int i = 0; i < testMatrix.length; ++i) {
			for (int j = 0; j < testMatrix.length; ++j) {
				testMatrix[i][j] = fyd.new Node();
				testMatrix[i][j].d = test[i][j];
			}
		}
		
		
		Floyds.Node[][] answer = fyd.floyds(testMatrix);
		
		for (int i = 0; i < answer.length; ++i) {
			for (int j = 0; j < answer.length; ++j) {
				if (answer[i][j].d != solMatrix[i][j]) {
					success = false;
				}
			}
		}
		
		if(!fyd.getPath(answer, 0, 3).trim().equals("0 1 3")) {
			success = false;
		}
		
		if(!fyd.getPath(answer, 1, 3).trim().equals("1 3")) {
			success = false;
		}
		
		if(!fyd.getPath(answer, 2, 0).trim().equals("2 4 1 0")) {
			success = false;
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
