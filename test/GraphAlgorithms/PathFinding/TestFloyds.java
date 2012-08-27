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

	/*
		Input Matrix:
		0 | 1 | 2 | 3 | 4 | 5
		1 | 0 | 1 | I | 5 |100
		~ |~~~|~~~|~~~|~~~|~~~
  		2 | 1 | 0 |100| 3 | 7
		~ |~~~|~~~|~~~|~~~|~~~
		3 | I |100| 0 |100| 5
		~ |~~~|~~~|~~~|~~~|~~~
		4 | 5 | 3 |100| 0 |100
		~ |~~~|~~~|~~~|~~~|~~~
		5 |100| 7 | 5 |100| 0 
		
		Solution Matrix:
		0 | 1 | 2 | 3 | 4 | 5
		1 | 0 | 1 | 16| 4 | 8
		~ |~~~|~~~|~~~|~~~|~~~
  		2 | 1 | 0 | 12| 3 | 7
		~ |~~~|~~~|~~~|~~~|~~~
		3 | 16| 12| 0 | 15| 5
		~ |~~~|~~~|~~~|~~~|~~~
		4 | 4 | 3 | 15| 0 | 10
		~ |~~~|~~~|~~~|~~~|~~~
		5 | 8 | 7 | 5 | 10| 0 
	*/
	
	public static void testOne(boolean printDebug)
	{
		success = false;
		int I = Integer.MAX_VALUE;
		int[][] testMatrix = {{0,1,I,5,100},{1,0,100,3,7},{I,100,0,100,5},{5,3,100,0,100},{100,7,5,100,0}};
		int[][] solMatrix = {{0,1,16,4,8},{1,0,12,3,7},{16,12,0,15,5},{4,3,15,0,10},{8,7,5,10,0}};
		int n = 5;
		
		Floyds fyd = new Floyds();
		/*
		int[][] r = fyd.floyds(testMatrix);
		
		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				if(r[i][j] != solMatrix[i][j])
					success = false;
			}
		}
		*/
	}
}
