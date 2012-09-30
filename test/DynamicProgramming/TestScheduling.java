package test.DynamicProgramming;

import java.util.*;
import main.DynamicProgramming.Scheduling;

public class TestScheduling {
	private static boolean success = true;
	
	public static void main(String[] args) {
		testOne(true);
		testTwo(true);
		testThree(true);

		if (!success) {
			System.out.println("FAILED: TestScheduling");
			System.exit(1);
		}
		else {
			System.exit(0);
		}
	
	}
	
	public static void testOne(boolean printDebug) {
		Scheduling s = new Scheduling();
		ArrayList<Scheduling.Task> tasks = new ArrayList<Scheduling.Task>();
		
		tasks.add(s.new Task(1, 3));
		tasks.add(s.new Task(2, 4));
		
		if (s.UnweightedScheduling(tasks) != 1) {
			success = false;
		}
	}
	
	public static void testTwo(boolean printDebug) {
		Scheduling s = new Scheduling();
		ArrayList<Scheduling.Task> tasks = new ArrayList<Scheduling.Task>();
		
		tasks.add(s.new Task(3, 4));
		tasks.add(s.new Task(1, 3));
		
		if (s.UnweightedScheduling(tasks) != 2) {
			success = false;
		}
	}
	
	public static void testThree(boolean printDebug) {
		Scheduling s = new Scheduling();
		ArrayList<Scheduling.Task> tasks = new ArrayList<Scheduling.Task>();
		
		tasks.add(s.new Task(1, 9));
		tasks.add(s.new Task(1, 2));//
		tasks.add(s.new Task(3, 4));//
		tasks.add(s.new Task(2, 6));
		tasks.add(s.new Task(5, 6));//
		tasks.add(s.new Task(4, 7));
		tasks.add(s.new Task(6, 7));//
		tasks.add(s.new Task(7, 8));//
		tasks.add(s.new Task(6, 8));
		tasks.add(s.new Task(5, 9));
		tasks.add(s.new Task(8, 9));//
		
		if (s.UnweightedScheduling(tasks) != 6) {
			success = false;
		}
	}
}
