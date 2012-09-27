package test.GraphAlgorithms.ConvexHull;

import java.awt.geom.Point2D;
import java.util.*;
import main.GraphAlgorithms.ConvexHull.QuickHull;

public class TestQuickHull {
	public static boolean success;
	
	public static void main(String[] args) {
		success = true;
		
		testOne(true);
		testTwo(true);
		testThree(true);
		testFour(true);
		
		if (!success) {
			System.out.println("FAILED: TestQuickHull");
			System.exit(1);
		}
		else {
			System.exit(0);
		}
	}
	
	public static void testOne(boolean printDebug) {
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		points.add(new Point2D.Double(4, 3));
		points.add(new Point2D.Double(-5, 0));
		points.add(new Point2D.Double(-5, 2));
		points.add(new Point2D.Double(-3, 1));
		points.add(new Point2D.Double(-1, 4));
		points.add(new Point2D.Double(-1, -4));
		points.add(new Point2D.Double(0, -3));
		points.add(new Point2D.Double(1, 3));
		points.add(new Point2D.Double(2, 1));
		points.add(new Point2D.Double(3, 4));
		points.add(new Point2D.Double(5, -2));
		points.add(new Point2D.Double(5, 1));
		Collections.shuffle(points);

		ArrayList<Point2D> hull = new ArrayList<Point2D>();
		hull.add(new Point2D.Double(-5, 0));
		hull.add(new Point2D.Double(-5, 2));
		hull.add(new Point2D.Double(-1, 4));
		hull.add(new Point2D.Double(4, 3));
		hull.add(new Point2D.Double(3, 4));
		hull.add(new Point2D.Double(5, 1));
		hull.add(new Point2D.Double(5, -2));
		hull.add(new Point2D.Double(-1, -4));

		ArrayList<Point2D> answer = QuickHull.computeHull(points);
		if (answer.size() != hull.size()) {
			success = false;
			return;
		}

		for(int i = 0; i < hull.size(); ++i) {
			if(!answer.get(0).equals(hull.get(0))) {
				success = false;
				return;
			}
		}
	}
	
	public static void testTwo(boolean printDebug) {
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		points.add(new Point2D.Double(0, 0));
		points.add(new Point2D.Double(1, 1));
		points.add(new Point2D.Double(5, 1));
		points.add(new Point2D.Double(3, 2));
		points.add(new Point2D.Double(2, 3));
		points.add(new Point2D.Double(4, 3));
		points.add(new Point2D.Double(1, 4));
		points.add(new Point2D.Double(6, 4));
		points.add(new Point2D.Double(3, 5));
		points.add(new Point2D.Double(8, 5));
		points.add(new Point2D.Double(4, 7));
		Collections.shuffle(points);

		ArrayList<Point2D> hull = new ArrayList<Point2D>();
		hull.add(new Point2D.Double(0, 0));
		hull.add(new Point2D.Double(1, 4));
		hull.add(new Point2D.Double(4, 7));
		hull.add(new Point2D.Double(8, 5));
		hull.add(new Point2D.Double(5, 1));
		
		ArrayList<Point2D> answer = QuickHull.computeHull(points);
		
		if (answer.size() != hull.size()) {
			success = false;
			return;
		}
		for(int i = 0; i < hull.size(); ++i) {
			if(!answer.get(0).equals(hull.get(0))) {
				success = false;
				return;
			}
		}
	}
	
	// square hull
	public static void testThree(boolean printDebug) {
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		
		points.add(new Point2D.Double(0, 0));
		points.add(new Point2D.Double(1, 1));
		points.add(new Point2D.Double(2, 2));
		points.add(new Point2D.Double(-1, -1));
		points.add(new Point2D.Double(-2, -2));
		points.add(new Point2D.Double(1, -1));
		points.add(new Point2D.Double(-1, 1));
		points.add(new Point2D.Double(-2, 2));
		points.add(new Point2D.Double(2, -2));
		
		//right
		points.add(new Point2D.Double(3, -2));
		//top
		points.add(new Point2D.Double(3, 3));
		points.add(new Point2D.Double(1, 3));
		points.add(new Point2D.Double(-3, 3));
		//bot
		points.add(new Point2D.Double(3, -3));
		points.add(new Point2D.Double(0, -3));
		points.add(new Point2D.Double(-3, -3));
		//left
		points.add(new Point2D.Double(-3, -2));
		
		Collections.shuffle(points);

		ArrayList<Point2D> hull = new ArrayList<Point2D>();
		hull.add(new Point2D.Double(-3, -3));
		hull.add(new Point2D.Double(-3, -2));
		hull.add(new Point2D.Double(-3, 3));
		hull.add(new Point2D.Double(1, 3));
		hull.add(new Point2D.Double(3, 3));
		hull.add(new Point2D.Double(3, -2));
		hull.add(new Point2D.Double(3, -3));
		hull.add(new Point2D.Double(0, -3));

		ArrayList<Point2D> answer = QuickHull.computeHull(points);

		if (answer.size() != hull.size()) {
			success = false;
			return;
		}
		for(int i = 0; i < hull.size(); ++i) {
			if(!answer.get(0).equals(hull.get(0))) {
				success = false;
				return;
			}
		}
	}

	public static void testFour(boolean printDebug) {
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		points.add(new Point2D.Double(118, 129));
		points.add(new Point2D.Double(144, 107));
		points.add(new Point2D.Double(206,  94));
		points.add(new Point2D.Double(207,  50));
		points.add(new Point2D.Double(  0, 136));
		Collections.shuffle(points);

		ArrayList<Point2D> hull = new ArrayList<Point2D>();
		hull.add(new Point2D.Double(0, 136));
		hull.add(new Point2D.Double(118, 129));
		hull.add(new Point2D.Double(206, 94));
		hull.add(new Point2D.Double(207, 0));

		ArrayList<Point2D> answer = QuickHull.computeHull(points);

		if (answer.size() != hull.size()) {
			success = false;
			return;
		}
		for(int i = 0; i < hull.size(); ++i) {
			if(!answer.get(0).equals(hull.get(0))) {
				success = false;
				return;
			}
		}
	}

}
