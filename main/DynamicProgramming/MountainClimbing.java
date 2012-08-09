package main.DynamicProgramming;
import java.util.*;

public class MountainClimbing
{
    /*
     * takes a 2d array of longs, will return the largest possible path traveling up the mountain
     * when you can move up, up-right, and up-left, the mountain is expected to be a rectangle
     * the last array is assumed to be the top of the mountain
     * all value of the are assumed to be positive, however the algorithm can be easily adapted to accomodate negatives 
    */
    public long climbing(long[][] mountain)
    {
	    int height = mountain.length;
	    int width = mountain[0].length;

	    // Create a blank path array
	    long[][] path = new long[height][width];

	    // Copy the mountain over
	    for (int i = 0; i < height; ++i) {
		for (int j = 0; j < width; ++j) {
		    path[i][j] = mountain [i][j];
		}
	    }

	    for (int i = 1; i < height; ++i) {
		for (int j = 0; j < width; ++j) {
		    long upLeft = j - 1 >= 0 ? path[i - 1][j - 1] : 0;
		    long up = path[i - 1][j];
		    long upRight = j + 1 < width ? path[i - 1][j + 1] : 0;

		    path[i][j] += Math.max(upLeft, Math.max(up, upRight));
		}
	    }

	    long max = 0;

	    for (int i = 0; i < width; ++i) {
		max = Math.max(max, path[height - 1][i]);
	    }

	    return max;
    }

    /*
     * The difference between this function and the one above is that the
     * original mountain is overwritten. This makes it faster, but bad to
     * do in certain situations
     */
    public long climbingDirty(long[][] mountain)
    {
	    int height = mountain.length;
	    int width = mountain[0].length;

	    for (int i = 1; i < height; ++i) {
		for (int j = 0; j < width; ++j) {
		    long upLeft = j - 1 >= 0 ? mountain[i - 1][j - 1] : 0;
		    long up = mountain[i - 1][j];
		    long upRight = j + 1 < width ? mountain[i - 1][j + 1] : 0;

		    mountain[i][j] += Math.max(upLeft, Math.max(up, upRight));
		}
	    }

	    long max = 0;

	    for (int i = 0; i < width; ++i) {
		max = Math.max(max, mountain[height - 1][i]);
	    }

	    return max;
    }
}
