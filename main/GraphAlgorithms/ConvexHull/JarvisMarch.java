//Time Complexity O(n*h) where n is number of elements on the hull,  is the
//number of elements on the hull. Prerequisites: No duplicate points.
package main.GraphAlgorithms.ConvexHull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.awt.geom.Point2D;

public class JarvisMarch {
	public static double angle(Point2D a, Point2D b) {
		return Math.atan2((b.getY() - a.getY()), (b.getX() - a.getX()));
	}

	public static class XComparator implements Comparator<Point2D> {
		public int compare(Point2D left, Point2D right) {
			if(left.getX() < right.getX())
				return -1;
			if(left.getX() > right.getX())
				return 1;
			if(left.getY() < right.getY())
				return -1;
			if(left.getY() > right.getY())
				return 1;
			return 0;
		}
	}

	public static class DistanceComparator implements Comparator<Point2D> {
		private Point2D.Double basis = new Point2D.Double();

		public DistanceComparator(Point2D basis) {
			this.basis.x = basis.getX();
			this.basis.y = basis.getY();
		}
		public int compare(Point2D left, Point2D right) {
			double leftDistance = basis.distance(left),
					rightDistance = basis.distance(right);
			if(leftDistance < rightDistance)
				return -1;
			if(leftDistance > rightDistance)
				return 1;
			return 0;
		}
	}

	public static ArrayList<Point2D> computeHull(ArrayList<Point2D> points) {
		return JarvisMarch.computeHull(points, true);
	}
	public static ArrayList<Point2D> computeHull(ArrayList<Point2D> points,
			boolean colinear) {
		HashSet<Point2D> onHull = new HashSet<Point2D>();
		// sort points based on x, then y
		Collections.sort(points, new JarvisMarch.XComparator());

		ArrayList<Point2D> chull = new ArrayList<Point2D>();
		chull.add(points.get(0));
		onHull.add(points.get(0));

		boolean completeHull = false;
		ArrayList<Point2D> previousAdded = new ArrayList<Point2D>(),
			beforePreviouslyAdded = new ArrayList<Point2D>();
		previousAdded.add(points.get(0));
		while(!completeHull) {
			Point2D cp = chull.get(chull.size() - 1);

			double lastAngle = Math.PI / 2;
			// if we have a previous point, computer the previous angle
			if(chull.size() > 1)
				lastAngle = angle(chull.get(chull.size() - 2), cp);
			if(lastAngle == Math.PI)
				lastAngle = 0;

			ArrayList<Point2D> smallest = new ArrayList<Point2D>();
			double smallestAngle = Double.POSITIVE_INFINITY;
			for(Point2D p : points) {
				if(p.equals(cp))
					continue;
				boolean inline = false;
				// if it's an about face turn, skip it
				for(Point2D pre : beforePreviouslyAdded)
					if(p.equals(pre))
						inline = true;
				if(inline)
					continue;

				double angle = angle(cp, p) - lastAngle;

				// if it's an about face turn, skip it
				if(angle == -Math.PI || angle == Math.PI)
					continue;
				if(angle > Math.PI)
					angle -= 2*Math.PI;
				if(angle < -Math.PI)
					angle += 2*Math.PI;
				angle = -angle;

				if(angle < smallestAngle) {
					smallest.clear();
					smallest.add(p);
					smallestAngle = angle;
				} else if(angle == smallestAngle) {
					smallest.add(p);
				}
			}

			// sort smallest based on distance to cp
			Collections.sort(points, new JarvisMarch.DistanceComparator(cp));

			beforePreviouslyAdded = previousAdded;
			previousAdded = new ArrayList<Point2D>();
			if(colinear) {
				for(Point2D p : smallest) {
					if(onHull.contains(p)) {
						completeHull = true;
						break;
					} else {
						previousAdded.add(p);
						onHull.add(p);
						chull.add(p);
					}
				}
			} else {
				Point2D p = smallest.get(smallest.size() - 1);
				if(onHull.contains(p)) {
					completeHull = true;
				} else {
					previousAdded.add(p);
					onHull.add(p);
					chull.add(p);
				}
			}
		}
		return chull;
	}
}

