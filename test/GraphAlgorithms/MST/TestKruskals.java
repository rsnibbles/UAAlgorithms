package test.GraphAlgorithms.MST;
import java.util.*;
import main.GraphAlgorithms.MST.Kruskals;

public class TestKruskals
{
	public static boolean success = true;
	public static void main(String[] args)
	{
		testOne(true);
		if(!success)
		{
			System.out.println("FAILED: TestKruskals");
			System.exit(1);
		}
		else
		{
			System.exit(0);
		}
	}

	public static void testOne(boolean printDebug)
	{
		Kruskals k = new Kruskals();
		
		// create nodes
		ArrayList<Kruskals.Node> nodes = new ArrayList<Kruskals.Node>();
		
		for (int i = 0; i < 7; ++i) {
			Kruskals.Node n = k.new Node();
			n.name = Character.toString((char)('A' + i));
			nodes.add(n);
		}
		
		// create connections
		
		ArrayList<Kruskals.Connection> connections = new ArrayList<Kruskals.Connection>();
		
		connections.add(k.new Connection(nodes.get(0), nodes.get(2), 1));
		connections.add(k.new Connection(nodes.get(2), nodes.get(4), 2));
		connections.add(k.new Connection(nodes.get(1), nodes.get(3), 3));
		connections.add(k.new Connection(nodes.get(0), nodes.get(1), 4));
		connections.add(k.new Connection(nodes.get(3), nodes.get(5), 5));
		connections.add(k.new Connection(nodes.get(4), nodes.get(5), 6));
		connections.add(k.new Connection(nodes.get(4), nodes.get(1), 7));
		connections.add(k.new Connection(nodes.get(0), nodes.get(3), 8));
		connections.add(k.new Connection(nodes.get(1), nodes.get(6), 9));
		connections.add(k.new Connection(nodes.get(5), nodes.get(6), 10));
		
		// to test our sorting
		Collections.shuffle(connections);
		
		ArrayList<Kruskals.Connection> answer = k.doKruskals(nodes, connections);
		ArrayList<Kruskals.Connection> expected = new ArrayList<Kruskals.Connection>();
		
		expected.add(k.new Connection(nodes.get(0), nodes.get(2), 1));
		expected.add(k.new Connection(nodes.get(2), nodes.get(4), 2));
		expected.add(k.new Connection(nodes.get(1), nodes.get(3), 3));
		expected.add(k.new Connection(nodes.get(0), nodes.get(1), 4));
		expected.add(k.new Connection(nodes.get(3), nodes.get(5), 5));
		expected.add(k.new Connection(nodes.get(1), nodes.get(6), 9));
		
		if (answer.size() != expected.size()) {
			success = false;
			return;
		}
		
		Collections.sort(answer);
		Collections.sort(expected);
		
		for (int i = 0; i < answer.size(); ++i) {
			Kruskals.Connection c1 = answer.get(i);
			Kruskals.Connection c2 = expected.get(i);
			
			if (!c1.a.name.equals(c2.a.name) || !c1.b.name.equals(c2.b.name) || c1.length != c2.length) {
				success = false;
				return;
			}
		}
	}
}
