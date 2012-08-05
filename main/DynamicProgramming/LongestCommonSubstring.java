package main.DynamicProgramming;
/**
	Algorithm to determine the largest common substring
*/
public class LongestCommonSubstring {

	/**
		Finds the longest common substring between two strings
		
		@param s1 The first string to compare
		@param s2 The second string to compare
		@return The longest common substring
	*/
	public static String longestCommonSubstring(String s1, String s2) {
	
		// create a table with s1 as the top and s2 as the left
		int rows = s1.length() + 1;
		int cols = s2.length() + 1;
		int[][] ar = new int[rows][cols];
		
		// fill the table
		for (int i = 1; i < rows; ++i) {
			for (int j = 1; j < cols; ++j) {
			
				// get the max of the left value and the above value
				int left = ar[i][j - 1];
				int above = ar[i - 1][j];
				int max = Math.max(left, above);
				
				// if it's a match, consider the diagonal
				if (s1.charAt(j - 1) == s2.charAt(i - 1))
					max = Math.max(ar[i - 1][j - 1] + 1, max);
					
				// store the max
				ar[i][j] = max;
				
				System.out.print("s1: " + s1.charAt(j - 1));
				System.out.print(" s2: " + s2.charAt(i - 1));
				System.out.print(" value: " + ar[i][j]);
				System.out.println();
			}
			
			System.out.println();
		}
		
		// output the max value
		System.out.println(ar[rows - 1][cols - 1]);
		
		return "";
	}

}
