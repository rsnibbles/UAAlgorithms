package test.GraphAlgorithms.PathFinding;
import java.util.*;
import main.GraphAlgorithms.PathFinding.Floyds;

public class TestFloyds
{
	public static boolean success = true;
	public static void main(String[] args)
	{
		testOne(true);
		if(!success)
		{
			System.out.println("FAILED: TestFloyds");
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
