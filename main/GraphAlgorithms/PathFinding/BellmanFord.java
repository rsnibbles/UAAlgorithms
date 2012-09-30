//Time complexity O(ve) where v is the number of vertices and e is the number
//of edges.
package main.GraphAlgorithms.PathFinding;

import java.util.*;

public class BellmanFord {

	public ArrayList<Node> doBellford(ArrayList<Node> nodes, ArrayList<Edge> edges, Node source) {
		for (Node n : nodes) {
			if (n == source) {
				n.distance = 0;
			} else {
				n.distance = Double.MAX_VALUE;
			}

			n.predecessor = null;
		}

		for (int i = 1; i < nodes.size(); i++) {
			for (Edge e : edges) {
				Node s = e.source;
				Node d = e.destination;
				if (s.distance + e.weight < d.distance) {
					d.distance = s.distance + e.weight;
					d.predecessor = s;
				}
			}
		}

		for (Edge e : edges) {
			Node s = e.source;
			Node d = e.destination;
			if (s.distance + e.weight < d.distance) {
				return null;
			}
		}

		return nodes;
	}

	public class Node {

		public Node predecessor = null;
		public double distance;

		public Node() {
			distance = Double.MAX_VALUE;
		}
	}

	public class Edge {

		public Node source;
		public Node destination;
		public double weight;

		public Edge(Node s, Node d, double w) {
			source = s;
			destination = d;
			weight = w;
		}
	}
}
