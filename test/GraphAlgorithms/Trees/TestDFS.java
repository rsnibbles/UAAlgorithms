package test.GraphAlgorithms.Trees;
import java.util.*;
import main.GraphAlgorithms.Trees.DFS;

public class TestDFS
{
	public static boolean success = true;
	public static void main(String[] args)
	{
		testOne(true);
		if(!success)
		{
			System.out.println("FAILED: TestDFS");
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
