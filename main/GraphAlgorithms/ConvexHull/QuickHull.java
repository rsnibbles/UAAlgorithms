//Quick hull is O(nlogn) where n is the number of elements, prerequisite: no
//duplicate points. SERIOUSLY JERK.
package main.GraphAlgorithms.ConvexHull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

public class QuickHull {
	public static double angle(Point2D a, Point2D b) {
		return Math.atan2((b.getY() - a.getY()), (b.getX() - a.getX()));
	}
	public static double distance(Line2D a, Point2D b) {
		return a.ptLineDist(b);
	}
	public static int above(Line2D a, Point2D b) {
		// horizontal line
		if(a.getP1().getY() == a.getP2().getY()) {
			if(b.getY() > a.getP1().getY())
				return 1;
			if(b.getY() < a.getP1().getY())
				return -1;
			return 0;
		}
		// vertical line
		if(a.getP1().getX() == a.getP2().getX()) {
			if(b.getX() < a.getP1().getX())
				return 1;
			if(b.getX() > a.getP1().getX())
				return -1;
			return 0;
		}
		double m =
			(a.getP2().getY() - a.getP1().getY()) /
			(a.getP2().getX() - a.getP1().getX());
		double lb = a.getP1().getY() - m*a.getP1().getX();
		double y = m*b.getX() + lb;
		if(b.getY() > y)
			return 1;
		if(b.getY() < y)
			return -1;
		return 0;
	}
	public static int outside(Line2D a, Point2D b, Point2D c) {
		int aboveTestC = above(a, c);
		if(aboveTestC == 0)
			return 0;
		if(aboveTestC == above(a, b))
			return -1;
		return 1;
	}

	public static class XComparator implements Comparator<Point2D> {
		private Point2D center;

		public XComparator(Point2D center) {
			this.center = center;
		}
		public int compare(Point2D left, Point2D right) {
			if(left.getX() < right.getX())
				return -1;
			if(left.getX() > right.getX())
				return 1;
			int res = 0;
			if(left.getY() < right.getY())
				return -1;
			if(left.getY() > right.getY())
				return 1;
			if(center == null)
				return res;
			// flip y order on the right of the center
			if(left.getX() > center.getX())
				res = -res;
			return res;
		}
	}

	public static Point2D center(ArrayList<Point2D> points) {
		Point2D center = new Point2D.Double();
		for(Point2D p : points)
			center.setLocation(center.getX() + p.getX(), center.getY() + p.getY());
		center.setLocation(center.getX() / points.size(), center.getY() / points.size());
		return center;
	}

	public static class DistanceComparator implements Comparator<Point2D> {
		private Line2D basis;

		public DistanceComparator(Line2D basis) {
			this.basis = basis;
		}
		public int compare(Point2D left, Point2D right) {
			double leftDistance = distance(basis, left),
					rightDistance = distance(basis, right);
			if(leftDistance < rightDistance)
				return -1;
			if(leftDistance > rightDistance)
				return 1;
			return 0;
		}
	}

	public static class AngleComparator implements Comparator<Point2D> {
		private Point2D center;

		public AngleComparator(Point2D center) {
			this.center = center;
		}
		public int compare(Point2D left, Point2D right) {
			double lL = angle(center, left), lR = angle(center, right);
			if(lL == -Math.PI)
				lL = Math.PI;
			if(lR == -Math.PI)
				lR = Math.PI;
			lL += Math.PI;
			lR += Math.PI;
			if(lL > lR)
				return -1;
			if(lL < lR)
				return 1;
			return 0;
		}
	}

	public static ArrayList<Point2D> computeHull(ArrayList<Point2D> points) {
		return QuickHull.computeHull(points, true);
	}
	public static ArrayList<Point2D> computeHull(ArrayList<Point2D> points,
			boolean colinear) {
		Point2D cpoint = center(points);
		// sort points based on x, then y
		Collections.sort(points, new QuickHull.XComparator(cpoint));

		Point2D left = points.get(0), right = points.get(points.size() - 1);
		Line2D line = new Line2D.Double(left, right);
		ArrayList<Point2D> above = new ArrayList<Point2D>(),
			below = new ArrayList<Point2D>(),
			on = new ArrayList<Point2D>();
		for(Point2D p : points) {
			if(p == left || p == right) {
				above.add(p);
				below.add(p);
				continue;
			}
			int aboveTest = above(line, p);
			if(aboveTest == 1)
				above.add(p);
			else if(aboveTest == -1)
				below.add(p);
			else
				on.add(p);
		}
		ArrayList<Point2D> aboveHull = computeSubHull(above, colinear),
			belowHull = computeSubHull(below, colinear);

		ArrayList<Point2D> chull = null;
		//if(colinear)
			//chull = merge(on, merge(aboveHull, belowHull));
		//else
			chull = merge(aboveHull, belowHull);
		return fixOrder(chull);
	}

	public static ArrayList<Point2D> computeSubHull(ArrayList<Point2D> points,
			boolean colinear) {
		if(points.size() <= 3)
			return points;

		Point2D left = points.get(0), right = points.get(points.size() - 1);
		Line2D line = new Line2D.Double(left, right);

		Point2D max = new Point2D.Double();
		double maxDistance = Double.NEGATIVE_INFINITY;
		for(Point2D p : points) {
			if(p == left || p == right)
				continue;
			double dist = distance(line, p);
			if(dist > maxDistance) {
				maxDistance = dist;
				max = p;
			}
		}

		Line2D leftLine = new Line2D.Double(left, max),
			rightLine = new Line2D.Double(max, right);

		ArrayList<Point2D> outsideLeft = new ArrayList<Point2D>(),
			onLeft = new ArrayList<Point2D>(),
			outsideRight = new ArrayList<Point2D>(),
			onRight = new ArrayList<Point2D>();

		for(Point2D p : points) {
			if(p == left) {
				outsideLeft.add(p);
				continue;
			}
			if(p == right) {
				outsideRight.add(p);
				continue;
			}
			if(p == max) {
				outsideLeft.add(max);
				outsideRight.add(max);
				continue;
			}

			int outsideLeftTest = outside(leftLine, right, p),
				outsideRightTest = outside(rightLine, left, p);

			if(outsideLeftTest == 1)
				outsideLeft.add(p);
			if(outsideLeftTest == 0)
				onLeft.add(p);

			if(outsideRightTest == 1)
				outsideRight.add(p);
			if(outsideRightTest == 0)
				onRight.add(p);
		}
		ArrayList<Point2D> leftHull = computeSubHull(outsideLeft, colinear),
			rightHull = computeSubHull(outsideRight, colinear);

		if(colinear) {
			ArrayList<Point2D> l = new ArrayList<Point2D>(),
				r = new ArrayList<Point2D>();
			if(leftHull.size() <= 3)
				l = merge(leftHull, onLeft);
			else
				l = leftHull;
			if(rightHull.size() <= 3)
				r = merge(rightHull, onRight);
			else
				r = rightHull;
			return merge(l, r);
		} else {
			return merge(leftHull, rightHull);
		}
	}

	public static ArrayList<Point2D> merge(ArrayList<Point2D> a, ArrayList<Point2D> b) {
		ArrayList<Point2D> res = new ArrayList<Point2D>();
		res.addAll(a);
		res.addAll(b);
		Collections.sort(res, new XComparator(null));
		for(int i = 1; i < res.size(); ++i)
			while(i < res.size() && res.get(i).equals(res.get(i - 1)))
				res.remove(i);
		return res;
	}
	public static ArrayList<Point2D> fixOrder(ArrayList<Point2D> points) {
		Point2D cpoint = center(points);
		Collections.sort(points, new QuickHull.XComparator(cpoint));
		Point2D p = points.get(0);
		Collections.sort(points, new AngleComparator(cpoint));

		ArrayList<Point2D> end = new ArrayList<Point2D>();
		while(points.size() != 0 && !points.get(0).equals(p)) {
			end.add(points.get(0));
			points.remove(0);
		}
		points.addAll(end);
		return points;
	}
}

