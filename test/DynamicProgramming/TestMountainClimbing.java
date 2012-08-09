package test.DynamicProgramming;
import java.util.*;
import main.DynamicProgramming.MountainClimbing;

public class TestMountainClimbing
{
	private static MountainClimbing MC = new MountainClimbing();
	public static boolean success = true;
	public static void main(String[] args)
	{
	    
	    testZero(true);
	    if(!success)
	    {
		    System.out.println("FAILED: TestMountainClimbing 0");
		    System.exit(1);
	    }
	    
	    testOne(true);
	    if(!success)
	    {
		    System.out.println("FAILED: TestMountainClimbing 1");
		    System.exit(1);
	    }
	    
	    testTwo(true);
	    if(!success)
	    {
		    System.out.println("FAILED: TestMountainClimbing 2");
		    System.exit(1);
	    }
	    
	    testThree(true);
	    if(!success)
	    {
		    System.out.println("FAILED: TestMountainClimbing 3");
		    System.exit(1);
	    }
	    
	    testFour(true);
	    if(!success)
	    {
		    System.out.println("FAILED: TestMountainClimbing 4");
		    System.exit(1);
	    }
	    
	    testFive(true);
	    if(!success)
	    {
		    System.out.println("FAILED: TestMountainClimbing 5");
		    System.exit(1);
	    }
	    
	    System.exit(0);
	}

	public static void testZero(boolean printDebug)
	{
		long[][] test_array = {{10,0,},
					{10,0},
					{10,0},
					{10,0}};

		long result = MC.climbing(test_array);

		if(result != 40)
		{
			success = false;
		}
		
		result = MC.climbingDirty(test_array);

		if(result != 40)
		{
			success = false;
		}
	}
	
	public static void testOne(boolean printDebug)
	{
		long[][] test_array = {{0,0,0,10,0},
								{0,0,0,10,0},
								{0,0,0,10,0},
								{0,0,0,10,0}};

		long result = MC.climbing(test_array);

		if(result != 40)
		{
			success = false;
			return;
		}
		
		result = MC.climbingDirty(test_array);

		if(result != 40)
		{
			success = false;
		}
	}
	public static void testTwo(boolean printDebug)
	{
		long[][] test_array = {{10,0,0,0},
								{0,10,0,0},
								{0,0,10,0},
								{0,0,0,10}};

		long result = MC.climbing(test_array);

		if(result != 40)
		{
			success = false;
			return;
		}
		
		result = MC.climbingDirty(test_array);

		if(result != 40)
		{
			success = false;
		}
	}

	public static void testThree(boolean printDebug)
	{
		long[][] test_array = {{0,0,0,10},
								{0,0,10,0},
								{0,10,0,0},
								{10,0,0,0}};

		long result = MC.climbing(test_array);

		if(result != 40)
		{
			success = false;
			return;
		}
		
		result = MC.climbingDirty(test_array);

		if(result != 40)
		{
			success = false;
		}
	}

	public static void testFour(boolean printDebug)
	{
		long[][] test_array = {{5,0,0,0},
								{5,0,0,5},
								{5,0,0,5},
								{5,0,0,30}};

		long result = MC.climbing(test_array);

		if(result != 40)
		{
			success = false;
			return;
		}
		
		result = MC.climbingDirty(test_array);

		if(result != 40)
		{
			success = false;
		}
	}

	public static void testFive(boolean printDebug)
	{
		long[][] test_array = {{5,0,0,30},
								{5,0,0,5},
								{5,0,0,5},
								{5,0,0,0}};

		long result = MC.climbing(test_array);

		if(result != 40)
		{
			success = false;
			return;
		}
		
		result = MC.climbingDirty(test_array);

		if(result != 40)
		{
			success = false;
		}
	}
}
