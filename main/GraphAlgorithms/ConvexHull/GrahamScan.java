package main.GraphAlgorithms.ConvexHull;

import java.util.*;

public class GrahamScan {

	public double ccw(Point a,Point b, Point c)
	{
		return (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
	}
	
	public ArrayList<Point> doGraham(ArrayList <Point> points)
	{
		int num = points.size();
		ArrayList <Point> increasePoints = new ArrayList<Point>();
		Point lowest = points.get(0);
		increasePoints.add(new Point());
		for(Point p : points)
			increasePoints.add(p);
		int j = 0;
		for(int i = 0; i < points.size(); i++)
		{
			if(increasePoints.get(i).y < lowest.y){
				j = i;
				lowest = increasePoints.get(i);
			}
		}
		
		Collections.swap(increasePoints,1,j);
		for(int temp = 2; temp < increasePoints.size(); temp++)
		{
			increasePoints.get(temp).radian = Math.atan((increasePoints.get(1).y - increasePoints.get(temp).y)
					/ (increasePoints.get(1).x - increasePoints.get(temp).x));
			
		}
		Collections.sort(increasePoints);
		
		increasePoints.set(0,points.get(num - 1));
		
		int m = 1;
		for (int i = 2; i <= num; i++)
		{
			while (ccw(increasePoints.get(m - 1), increasePoints.get(m), increasePoints.get(i)) <= 0)
			{
				if(m > 1)
					m -= 1;
				else if(i == num)
					break;
				else
					i += 1;
			}
			m++;
			Collections.swap(increasePoints, m, i);
		}
		
		return increasePoints;
	}
	
	public class Point implements Comparable<Point>{
		double x;
		double y;
		double radian;
		
		public Point() {
			
		}
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Point other)
		{
			return (int) (this.radian-other.radian);
		}
	}
}
