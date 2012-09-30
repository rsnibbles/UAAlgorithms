//Time complexity O(vlogv) where v is the number of vertices.
package main.GraphAlgorithms.PathFinding;

import java.util.*;

public class Dijkstra {
	public double shortestPath(Node start, Node end) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		
		queue.add(start);
		
		while (queue.size() > 0) {
			Node current = queue.poll();
			current.processed = true;
			
			if (current.distance > end.distance) {
				continue;
			}
			
			for (Connection c : current.connections) {
				double total = current.distance + c.distance;
				if (total < c.endpoint.distance) {
					c.endpoint.distance = total;
				}
				
				if (!c.endpoint.processed) {
					queue.add(c.endpoint);
				}
			}
		}
		
		return end.distance;
	}
	
	public class Node implements Comparable<Node> {
		public double distance;
		public boolean processed;
		public ArrayList<Connection> connections;
		
		public Node() {
			distance = Double.MAX_VALUE;
			processed = false;
			connections = new ArrayList<Connection>();
		}
		
		public Node(double d) {
			distance = d;
			processed = false;
			connections = new ArrayList<Connection>();
		}
		
		public int compareTo(Node n) {
			return (int)(this.distance - n.distance);
		}
	}
	
	public class Connection {
		public double distance;
		public Node endpoint;
		
		public Connection (double d, Node n) {
			distance = d;
			endpoint = n;
		}
	}
}
