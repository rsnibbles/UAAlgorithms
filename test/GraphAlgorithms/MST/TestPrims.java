package test.GraphAlgorithms.MST;
import java.util.*;
import main.GraphAlgorithms.MST.Prims;

public class TestPrims
{
	public static boolean success = true;
	public static void main(String[] args)
	{
		testOne(true);
		if(!success)
		{
			System.out.println("FAILED: TestPrims");
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
