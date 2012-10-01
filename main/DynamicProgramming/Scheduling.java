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
		ArrayList<Task> pValSort = new ArrayList<Task>(tasks);

		Collections.sort(tasks);

		Collections.sort(pValSort, new startTimeComparator());

		pVals[0] = 0;
		int start = 0;
		int stop = 0;

		while (start < tasks.size() && stop < tasks.size()) {
			if (tasks.get(stop).stop <= tasks.get(start).start) {
				++stop;
			} else if (tasks.get(stop).stop > tasks.get(start).start) {
				pVals[start + 1] = stop;
				++start;
			}
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

	public class startTimeComparator implements Comparator<Task> {

		public int compare(Task t1, Task t2) {
			return (int) (t1.start - t2.start);
		}
	}
}
