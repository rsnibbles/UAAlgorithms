package main.DynamicProgramming;

import java.util.*;

public class Scheduling {
	// Greedy approach. Only works if all tasks have same weight (or none)
	public long UnweightedScheduling (ArrayList<Task> tasks) {
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
	
	public class Task implements Comparable<Task> {
		double start;
		double stop;
		double value;
		
		public Task (double start, double stop) {
			this.start = start;
			this.stop = stop;
		}
		
		public Task (double start, double stop, double value) {
			this.start = start;
			this.stop = stop;
			this.value = value;
		}
		
		public int compareTo (Task t) {
			//return (int)(this.stop - t.stop);
			if (this.stop < t.stop) {
				return -1;
			} else if (this.stop > t.stop) {
				return 1;
			} else {
				return (int)(this.start - t.start);
			}
		}
	}
}
