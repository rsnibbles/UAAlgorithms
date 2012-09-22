package test.GraphAlgorithms.PathFinding;

import main.GraphAlgorithms.PathFinding.Dijkstra;

public class TestDijkstra {
	public static boolean success;
	
	public static void main(String[] args) {
		success = true;
		
		testOne();
		testTwo();
		testThree();
		
		if (!success) {
			System.out.println("FAILED: TestDijkstra");
			System.exit(1);
		}
		else {
			System.exit(0);
		}
	}
	
	public static void testOne() {
		Dijkstra dk = new Dijkstra();
		
		Dijkstra.Node start = dk.new Node(0);
		Dijkstra.Node mid = dk.new Node();
		Dijkstra.Node end = dk.new Node();
		
		start.connections.add(dk.new Connection(10, mid));
		mid.connections.add(dk.new Connection(20, end));
		
		double shortest = dk.shortestPath(start, end);
		if(shortest != 30) {
			success = false;
		}
	}
	
	public static void testTwo() {
		Dijkstra dk = new Dijkstra();
		
		Dijkstra.Node start = dk.new Node(0);
		Dijkstra.Node mid1 = dk.new Node();
		Dijkstra.Node mid2 = dk.new Node();
		Dijkstra.Node end = dk.new Node();
		
		start.connections.add(dk.new Connection(5, mid1));
		start.connections.add(dk.new Connection(10, mid2));
		mid1.connections.add(dk.new Connection(25, end));
		mid2.connections.add(dk.new Connection(10, end));
		
		double shortest = dk.shortestPath(start, end);
		if(shortest != 20) {
			success = false;
		}
	}
	
	public static void testThree() {
		Dijkstra dk = new Dijkstra();
		
		Dijkstra.Node start = dk.new Node(0);
		Dijkstra.Node mid1 = dk.new Node();
		Dijkstra.Node mid2 = dk.new Node();
		Dijkstra.Node mid3 = dk.new Node();
		Dijkstra.Node mid4 = dk.new Node();
		Dijkstra.Node mid5 = dk.new Node();
		Dijkstra.Node mid6 = dk.new Node();
		Dijkstra.Node end = dk.new Node();
		
		start.connections.add(dk.new Connection(20, mid1));
		start.connections.add(dk.new Connection(5, mid2));
		start.connections.add(dk.new Connection(10, mid3));
		
		mid1.connections.add(dk.new Connection(20, start));
		mid1.connections.add(dk.new Connection(40, mid4));
		
		mid2.connections.add(dk.new Connection(5, start));
		mid2.connections.add(dk.new Connection(10, mid3));
		mid2.connections.add(dk.new Connection(35, mid5));
		
		mid3.connections.add(dk.new Connection(10, start));
		mid3.connections.add(dk.new Connection(10, mid2));
		mid3.connections.add(dk.new Connection(60, mid4));
		mid3.connections.add(dk.new Connection(20, mid6));
		
		mid4.connections.add(dk.new Connection(40, mid1));
		mid4.connections.add(dk.new Connection(35, mid3));
		mid4.connections.add(dk.new Connection(10, mid5));
		mid4.connections.add(dk.new Connection(10, end));
		
		mid5.connections.add(dk.new Connection(35, mid2));
		mid5.connections.add(dk.new Connection(10, mid4));
		mid5.connections.add(dk.new Connection(10, mid6));
		mid5.connections.add(dk.new Connection(25, end));
		
		mid6.connections.add(dk.new Connection(20, mid3));
		mid6.connections.add(dk.new Connection(10, mid5));
		mid6.connections.add(dk.new Connection(40, end));
		
		end.connections.add(dk.new Connection(10, mid4));
		end.connections.add(dk.new Connection(25, mid5));
		end.connections.add(dk.new Connection(40, mid6));
		
		double shortest = dk.shortestPath(start, end);
		if(shortest != 60) {
			success = false;
		}
	}
}
