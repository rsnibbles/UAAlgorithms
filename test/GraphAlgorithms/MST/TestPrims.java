package test.GraphAlgorithms.MST;
import java.util.*;
import main.GraphAlgorithms.MST.Prims;

public class TestPrims
{
	public static boolean success = true;
	public static void main(String[] args) {
		testOne(true);
		if(!success) {
			System.out.println("FAILED: TestPrims");
			System.exit(1);
		}
		else {
			System.exit(0);
		}
	}

	public static void testOne(boolean printDebug) {
		success = false;
		
		Prims algorithm = new Prims();
		
		//ArrayList<Prims.Node> problemSet = buildTestGraph();
		//ArrayList<Prims.Node> answer = algorithm.runPrim(buildGraph());
		
	}
	
	// Test case setup (HARD CODED)
	private static ArrayList<Prims.Node> buildGraphs() {
		Prims builder = new Prims();
		ArrayList<Prims.Node> graph = new ArrayList<Prims.Node>();
		
		Prims.Node a = builder.new Node();
		Prims.Node b = builder.new Node();
		Prims.Node c = builder.new Node();
		Prims.Node d = builder.new Node();
		Prims.Node e = builder.new Node();
		Prims.Node f = builder.new Node();
		
		a.connList.add(builder.new Connection(b,3));
		a.connList.add(builder.new Connection(e,9));
		
		b.connList.add(builder.new Connection(a,3));
		b.connList.add(builder.new Connection(c,2));
		b.connList.add(builder.new Connection(d,7));

		c.connList.add(builder.new Connection(f,6));
		c.connList.add(builder.new Connection(b,2));

		d.connList.add(builder.new Connection(b,4));
		d.connList.add(builder.new Connection(e,2));
		d.connList.add(builder.new Connection(f,5));
		
		e.connList.add(builder.new Connection(a,9));	
		e.connList.add(builder.new Connection(f,1));
		e.connList.add(builder.new Connection(d,2));
		
		f.connList.add(builder.new Connection(e,1));
		f.connList.add(builder.new Connection(d,5));
		f.connList.add(builder.new Connection(c,6));
		
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
						
		return graph;	
	}
	
	//private static ArrayList<Prims.Node> buildGraphs() {
	//}
}
