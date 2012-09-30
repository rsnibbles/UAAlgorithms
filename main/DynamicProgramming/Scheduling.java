package main.DynamicProgramming;

import java.util.*;

public class Scheduling {
	// Greedy approach. Only works if all tasks have same weight (or none)

	public int UnweightedScheduling(ArrayList<Task> tasks) {
		if (tasks.isEmpty()) {
			return 0;
		}

		int numTasks = 0;
		Collections.sort(tasks);

		for (int i = 0; i < tasks.size();) {
			Task t = tasks.get(i);
			++numTasks;

			while (i < tasks.size() && t.stop > tasks.get(i).start) {
				++i;
			}
		}

		return numTasks;
	}

	// Dynamic approach to task scheduling.
	public double WeightedScheduling(ArrayList<Task> tasks) {
		if (tasks.isEmpty()) {
			return 0;
		}

		int[] pVals = new int[tasks.size() + 1];
		double[] s = new double[tasks.size() + 1];
		pVals[0] = 0;

		for (int i = 1; i < pVals.length; ++i) {
			// O(n^2) to set p Values can be made to O(nlog(n)) by either sorting or binary search
			Task t = tasks.get(i - 1);
			int prev = i;

			while (prev > 0 && t.start < tasks.get(prev - 1).stop) {
				--prev;
			}

			pVals[i] = prev;
		}

		// base case
		s[0] = 0;
		s[1] = tasks.get(0).value;
		double max = 0;
		for (int i = 2; i < tasks.size() + 1; ++i) {
			s[i] = Math.max(s[i - 2], tasks.get(i - 1).value + s[pVals[i]]);
			max = Math.max(max, s[i]);
		}

		return max;
	}

	public class Task implements Comparable<Task> {

		double start;
		double stop;
		double value;

		public Task(double start, double stop) {
			this.start = start;
			this.stop = stop;
		}

		public Task(double start, double stop, double value) {
			this.start = start;
			this.stop = stop;
			this.value = value;
		}

		public int compareTo(Task t) {
			//return (int)(this.stop - t.stop);
			if (this.stop < t.stop) {
				return -1;
			} else if (this.stop > t.stop) {
				return 1;
			} else {
				return (int) (this.start - t.start);
			}
		}
	}
}
