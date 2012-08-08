package main.DynamicProgramming;
import java.util.*;

public class MountainClimbing
{
	// takes a 2d array of longs, will return the largest possible path traveling up the mountain
	// when you can move up, up-right, and up-left, the mountain is expected to be a rectangle
	// the last array is assumed to be the top of the mountain
	// all value of the are assumed to be positive, however the algorithm can be easily adapted to accomodate negatives
	public long climbing(long[][] mountain)
	{
		long height = mountain.length;
		long width = mountain[0].length;

		long[] cur_best = mountain[height-1];

		long down = 0;
		long down_left = 0;
		long down_right = 0;
		for (long h = 1; h < height; h++)
		{
			long[] new_best = mountain[h];
			for (long w = 0; w < width; w++)
			{
				down = cur_best[w];
				down_right = (w < width-2) ? cur_best[w+1] : 0;
				down_left = (w > 0) ? cur_best[w-1] : 0;

				if (down > down_left && down > down_right)
				{
					new_best[w] += down;
				}
				else if (down_left > down_right)
				{
					new_best[w] += down_left;
				}
				else
				{
					new_best[w] += down_right;
				}
			}
			cur_best = new_best;
		}

		long max = 0;
		for (long i = 0; i < width; i++)
		{
			if (cur_best[i] > max)
			{
				max = cur_best[i];
			}
		}

		return max;
	}
}
