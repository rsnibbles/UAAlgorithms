package test.GraphAlgorithms.PathFinding;

import java.util.*;
import main.GraphAlgorithms.PathFinding.BellmanFord;

public class TestBellmanFord {

	public static boolean success;

	public static void main(String[] args) {
		success = true;

		testOne(true);
		testTwo(true);
		testThree(true);
		testFour(true);
		testFive(true);

		if (!success) {
			System.out.println("FAILED: TestBellmanFord");
			System.exit(1);
		} else {
			System.exit(0);
		}
	}

	public static void testOne(boolean printDebug) {
		BellmanFord bf = new BellmanFord();

		ArrayList<BellmanFord.Node> nodes = new ArrayList<BellmanFord.Node>();
		ArrayList<BellmanFord.Edge> edges = new ArrayList<BellmanFord.Edge>();

		nodes.add(bf.new Node());
		nodes.add(bf.new Node());

		edges.add(bf.new Edge(nodes.get(0), nodes.get(1), 1));

		ArrayList<BellmanFord.Node> answer = bf.doBellford(nodes, edges, nodes.get(0));

		if (answer.get(0).distance != 0) {
			success = false;
		}

		if (answer.get(1).distance != 1) {
			success = false;
		}
	}

	public static void testTwo(boolean printDebug) {
		BellmanFord bf = new BellmanFord();

		ArrayList<BellmanFord.Node> nodes = new ArrayList<BellmanFord.Node>();
		ArrayList<BellmanFord.Edge> edges = new ArrayList<BellmanFord.Edge>();

		nodes.add(bf.new Node());
		nodes.add(bf.new Node());

		edges.add(bf.new Edge(nodes.get(0), nodes.get(1), -1));

		ArrayList<BellmanFord.Node> answer = bf.doBellford(nodes, edges, nodes.get(0));

		if (answer.get(0).distance != 0) {
			success = false;
		}

		if (answer.get(1).distance != -1) {
			success = false;
		}
	}

	public static void testThree(boolean printDebug) {
		BellmanFord bf = new BellmanFord();

		ArrayList<BellmanFord.Node> nodes = new ArrayList<BellmanFord.Node>();
		ArrayList<BellmanFord.Edge> edges = new ArrayList<BellmanFord.Edge>();

		nodes.add(bf.new Node());
		nodes.add(bf.new Node());
		nodes.add(bf.new Node());
		nodes.add(bf.new Node());

		edges.add(bf.new Edge(nodes.get(0), nodes.get(1), 5));
		edges.add(bf.new Edge(nodes.get(0), nodes.get(2), 5));
		edges.add(bf.new Edge(nodes.get(1), nodes.get(3), 5));
		edges.add(bf.new Edge(nodes.get(2), nodes.get(3), -5));

		ArrayList<BellmanFord.Node> answer = bf.doBellford(nodes, edges, nodes.get(0));

		if (answer.get(0).distance != 0) {
			success = false;
		}

		if (answer.get(1).distance != 5) {
			success = false;
		}

		if (answer.get(2).distance != 5) {
			success = false;
		}

		if (answer.get(3).distance != 0) {
			success = false;
		}
	}

	public static void testFour(boolean printDebug) {
		BellmanFord bf = new BellmanFord();

		ArrayList<BellmanFord.Node> nodes = new ArrayList<BellmanFord.Node>();
		ArrayList<BellmanFord.Edge> edges = new ArrayList<BellmanFord.Edge>();

		nodes.add(bf.new Node());
		nodes.add(bf.new Node());

		edges.add(bf.new Edge(nodes.get(0), nodes.get(1), -1));
		edges.add(bf.new Edge(nodes.get(1), nodes.get(0), -1));


		ArrayList<BellmanFord.Node> answer = bf.doBellford(nodes, edges, nodes.get(0));

		if (answer != null) {
			success = false;
		}
	}

	public static void testFive(boolean printDebug) {
		BellmanFord bf = new BellmanFord();

		ArrayList<BellmanFord.Node> nodes = new ArrayList<BellmanFord.Node>();
		ArrayList<BellmanFord.Edge> edges = new ArrayList<BellmanFord.Edge>();

		nodes.add(bf.new Node());
		nodes.add(bf.new Node());
		nodes.add(bf.new Node());

		edges.add(bf.new Edge(nodes.get(0), nodes.get(1), 2));
		edges.add(bf.new Edge(nodes.get(1), nodes.get(2), 2));
		edges.add(bf.new Edge(nodes.get(2), nodes.get(0), -5));


		ArrayList<BellmanFord.Node> answer = bf.doBellford(nodes, edges, nodes.get(0));

		if (answer != null) {
			success = false;
		}
	}
}
