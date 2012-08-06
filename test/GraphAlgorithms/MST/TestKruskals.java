package test.GraphAlgorithms.MST;
import java.util.*;
import main.GraphAlgorithms.MST.Kruskals;

public class TestKruskals
{
	public static boolean success = true;
	public static void main(String[] args)
	{
		testOne(true);
		if(!success)
		{
			System.out.println("FAILED: TestKruskals");
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
