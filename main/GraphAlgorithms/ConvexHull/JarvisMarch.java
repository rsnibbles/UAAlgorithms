package main.GraphAlgorithms.ConvexHull;

import java.util.*;
import java.awt.geom.*;

public class JarvisMarch {

	public ArrayList<Point2D.Double> doJarvis(ArrayList <Point2D.Double> points) {
		Point2D.Double leftMost = points.get(0);
		Point2D.Double next;
		ArrayList<Point2D.Double> pointsAdded = new ArrayList<Point2D.Double> ();
		
		for(Point2D.Double p : points) {
			if(p.x < leftMost.x || (p.x == leftMost.x && p.y < leftMost.y))
				leftMost = p;
		}
		
		pointsAdded.add(leftMost);
		
		int i = 0;
		while (i < pointsAdded.size()) {
			if (i > 0) {
				next = nextHullPoint(points,pointsAdded.get(i - 1), pointsAdded.get(i));
			}
			else {
				next = nextHullPoint(points, pointsAdded.get(i), pointsAdded.get(i));
			}
			
			
			if (next != pointsAdded.get(0)) {
				pointsAdded.add(next);
			}
			
			++i;
		}
		
		return pointsAdded;
	}
	
	private double distance(Point2D.Double p1, Point2D.Double p2) {
		double dx = p2.x - p1.x;
		double dy = p2.y - p1.y;
		
		return dx * dx + dy * dy;
	}
	
	private int turn(Point2D.Double p, Point2D.Double q, Point2D.Double r) {
		return Double.compare((q.x - p.x) * (r.y - p.y) - (r.x - p.x) * (q.y - p.y), 0);
	}
	
	private Point2D.Double nextHullPoint(ArrayList<Point2D.Double> points,Point2D.Double prev, Point2D.Double p) {
		Point2D.Double q = prev;
		
		for (Point2D.Double r : points) {
			int turn = turn(p, q, r);
			double d1 = distance(p, r);
			double d2 = distance(p, q);
			if (turn == 1 || (turn == 0 && d1 > d2)) {
				q = r;
			}
		}
		
		return q;
	}
	
	
}
