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
		success = false;
	}
}
