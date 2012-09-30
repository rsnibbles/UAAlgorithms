//Time complexity O(n^3) where n is the number of nodes. There is a path
//recovery portion that you should ignore if you don't need the exact path.
package main.GraphAlgorithms.PathFinding;

import java.util.*;

public class Floyds {
	/* 
	 This assumes that the Adjacency Matrix has already been constructed,
	 that if there is no connection between two nodes that it is sufficiently large
	 and that the connection between a node and itself is 0
	 */
	public int[][] floyds(int[][] adjacencyMatrix) {
		// Used as infinity
		final int I = Integer.MAX_VALUE;
		
		int[][] aMatrix = adjacencyMatrix;
		int n = aMatrix.length;
		for (int k = 0; k < n; ++k) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (aMatrix[i][k] != I && aMatrix[k][j] != I && aMatrix[i][k] + aMatrix[k][j] < aMatrix[i][j]) {
						aMatrix[i][j] = aMatrix[i][k] + aMatrix[k][j];
					}
				}
			}
		}
		
		return aMatrix;
	}
	
	/*
	 Integer is used instead of int because we wish to allow the possibility of an entry
	 being "null", which is otherwise impossible. More specifically, we want entries in
	 nextMatrix to be null when the relationship to adjacencyMatrix turns up an "Infinity".
	 Likewise, we need to allow Integer to equal infinity (or just the max).
		
	 This implementation of Floyds will allow us to re-establish the path instead of being
	 limited to only the shortest distance, the time complexity is the same but the code
	 complexity is a little more involved.
	 */
	public Node[][] floyds(Node[][] aMatrix) {
		// Used as infinity
		final int I = Integer.MAX_VALUE;
		
		int n = aMatrix.length;

		for (int k = 0; k < n; ++k) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (aMatrix[i][k].d != I && aMatrix[k][j].d != I
							&& aMatrix[i][k].d + aMatrix[k][j].d < aMatrix[i][j].d) {
						aMatrix[i][j].d = aMatrix[i][k].d + aMatrix[k][j].d;
						aMatrix[i][j].k = k;
					}
				}
			}
		}

		return aMatrix;
	}

	/* 
	 getPath assumes it has adjacencyMatrix and nextMatrix in scope, as well as an "infinity"
	 */
	public String getPath(Node[][] matrix, int i, int j) {
		return i + getPathHelper(matrix, i, j) + j + "\n";
	}
	
	public String getPathHelper(Node[][] matrix, int i, int j) {
		// Used as infinity
		final int I = Integer.MAX_VALUE;
		
		if (matrix[i][j].d >= I) // >= just in case
		{
			return "no path";
		}
		
		Integer intermediate = matrix[i][j].k;
		
		if (intermediate == null) {
			return " "; //There is an edge from i to j, with no vertices between
		} else {
			return getPathHelper(matrix, i, intermediate) + intermediate + getPathHelper(matrix, intermediate, j);
		}
	}
	
	public class Node {
		public Integer d;
		public Integer k;
	}
}
