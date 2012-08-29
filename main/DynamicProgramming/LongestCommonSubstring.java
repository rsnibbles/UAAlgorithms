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
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					max = Math.max(ar[i - 1][j - 1] + 1, max);
				}
					
				// store the max	
				ar[i][j] = max;
			}
		}
		
		// construct the substring
		StringBuilder sb = new StringBuilder();
		
		int s1Len = s1.length();
		int s2Len = s2.length();
		while (s1Len > 1 || s2Len > 1) {
			int curVal = ar[s1Len][s2Len];
			
			if (curVal == ar[s1Len - 1][s2Len]) {
				--s1Len;
			}
			else if (curVal == ar[s1Len][s2Len - 1]) {
				--s2Len;
			}
			else {
				sb.append(s1.charAt(s1Len - 1));
				--s1Len;
				--s2Len;
			}
		}
		
		return sb.reverse().toString();
	}
	
	public static int longestCommonSubstringValue(String s1, String s2) {
	
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
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					max = Math.max(ar[i - 1][j - 1] + 1, max);
				}
					
				// store the max	
				ar[i][j] = max;
			}
		}
		
		return ar[rows - 1][cols - 1];
	}

}
