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
		int[][] ar = new int[s1.length() + 1][s2.length + 1];
		
		// fill the table
		for (int i = 1; i <= s1.length(); ++i) {
			for (int j = 1; j <= s2.length(); ++j) {
				
				// it's a match, so add on the diagonal
				if (s1.charAt(i) == s2.charAt(j))
					ar[i][j] = ar[i - 1][j - 1] + 1;
			}
		}
		
		return "";
	}

}
