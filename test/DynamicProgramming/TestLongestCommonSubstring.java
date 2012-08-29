package test.DynamicProgramming;
import java.util.*;
import main.DynamicProgramming.LongestCommonSubstring;

public class TestLongestCommonSubstring
{
	public static boolean success = true;
	public static void main(String[] args)
	{
		testOne(true);
		if(!success)
		{
			System.out.println("FAILED: TestLongestCommonSubstring");
			System.exit(1);
		}
		else
		{
			System.exit(0);
		}
	}

	public static void testOne(boolean printDebug)
	{
		success = true;
		
		if (!LongestCommonSubstring.longestCommonSubstring("sprint", "print")
				.equals("print")){
			success = false;
		}
		
		if (LongestCommonSubstring
				.longestCommonSubstringValue("sprint", "print") != 5) {
			success = false;
		}
		
		if (!LongestCommonSubstring.longestCommonSubstring("sprintstuff", 
				"print").equals("print")) {
			success = false;
		}
		
		if (LongestCommonSubstring
				.longestCommonSubstringValue("sprintstuff", "print") != 5) {
			success = false;
		}
		
		if (!LongestCommonSubstring.longestCommonSubstring(
				"sprintsprinting", "printing").equals("printing")) {
			success = false;
		}
		
		if (LongestCommonSubstring.longestCommonSubstringValue(
				"sprintsprinting", "printing") != 8) {
			success = false;
		}
		
		if (!LongestCommonSubstring.longestCommonSubstring(
				"sprint", "oriqq").equals("ri")) {
			success = false;
		}
		
		if (LongestCommonSubstring.longestCommonSubstringValue(
				"sprint", "oriqq") != 2) {
			success = false;
		}
	}
}
