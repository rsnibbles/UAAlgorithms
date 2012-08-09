package test.GraphAlgorithms.Trees;
import java.util.*;
import main.GraphAlgorithms.Trees.BFS;

public class TestBFS
{
	public static boolean success = true;
	public static void main(String[] args)
	{
	    testOne(true);
	    testTwo(true);
	    if(!success)
	    {
		    System.out.println("FAILED: TestBFS");
		    System.exit(1);
	    }
	    else
	    {
		    System.exit(0);
	    }
	}

	public static void testOne(boolean printDebug)
	{
	    Node[] tree = new Node[7];
	    
	    for (int i = 0; i < 7; ++i) {
		tree[i] = new Node();
		char name = (char)('A' + i);
		tree[i].name = Character.toString(name);
	    }
	    
	    ArrayList<Node> graph = new ArrayList<Node>();
	    graph.add(tree[0]);
	    tree[0].children.add(tree[1]);
	    tree[0].children.add(tree[2]);
	    tree[1].children.add(tree[0]);
	    tree[2].children.add(tree[0]);
	    graph.add(tree[1]);
	    graph.add(tree[2]);
	    tree[1].children.add(tree[3]);
	    tree[1].children.add(tree[4]);
	    tree[2].children.add(tree[5]);
	    tree[2].children.add(tree[6]);
	    tree[3].children.add(tree[1]);
	    tree[4].children.add(tree[1]);
	    tree[5].children.add(tree[2]);
	    tree[6].children.add(tree[2]);
	    graph.add(tree[3]);
	    graph.add(tree[4]);
	    graph.add(tree[5]);
	    graph.add(tree[6]);
	    
	    BFS bfs = new BFS();
	    ArrayList<Node> traversal = bfs.BFSTraversal(graph);
	    
	    for (int i = 0; i < traversal.size(); ++i) {
		if (!traversal.get(i).name.equals(Character.toString((char)('A' + i)))) {
		    success = false;
		    return;
		}
	    }
	    
	    traversal = bfs.BFSTraversal(graph, 6);
	    if (traversal.size() > 1 || !traversal.get(0).name.equals("G")) {
		success = false;
		return;
	    }
	}
	
	public static void testTwo(boolean printDebug)
	{
	    Node[] tree = new Node[7];
	    
	    for (int i = 0; i < 7; ++i) {
		tree[i] = new Node();
		char name = (char)('A' + i);
		tree[i].name = Character.toString(name);
	    }
	    
	    ArrayList<Node> graph = new ArrayList<Node>();
	    graph.add(tree[0]);
	    tree[0].children.add(tree[1]);
	    tree[0].children.add(tree[2]);
	    tree[1].children.add(tree[0]);
	    tree[2].children.add(tree[0]);
	    graph.add(tree[1]);
	    graph.add(tree[2]);
	    tree[1].children.add(tree[3]);
	    tree[1].children.add(tree[4]);
	    tree[2].children.add(tree[5]);
	    tree[2].children.add(tree[6]);
	    tree[3].children.add(tree[1]);
	    tree[4].children.add(tree[1]);
	    tree[5].children.add(tree[2]);
	    tree[6].children.add(tree[2]);
	    graph.add(tree[3]);
	    graph.add(tree[4]);
	    graph.add(tree[5]);
	    graph.add(tree[6]);
	    
	    BFS bfs = new BFS();
	    ArrayList<Node> traversal = bfs.BFSTraversal(graph, 6);
	    
	    String[] answer1 = {"G", "C", "F", "A", "B", "D", "E"};
	    String[] answer2 = {"G", "C", "F", "A", "B", "D", "E"};
	    String[] answer3 = {"G", "C", "F", "A", "B", "D", "E"};
	    String[] answer4 = {"G", "C", "F", "A", "B", "D", "E"};
	    
	    for(int i = 0; i < answer1.length; ++i) {
		if (!answer1[i].equals(traversal.get(i).name)) {
		    success = true;
		    return;
		}
	    }
	    
	    for(int i = 0; i < answer2.length; ++i) {
		if (!answer2[i].equals(traversal.get(i).name)) {
		    success = true;
		    return;
		}
	    }
	    
	    for(int i = 0; i < answer3.length; ++i) {
		if (!answer3[i].equals(traversal.get(i).name)) {
		    success = true;
		    return;
		}
	    }
	    
	    for(int i = 0; i < answer4.length; ++i) {
		if (!answer4[i].equals(traversal.get(i).name)) {
		    success = true;
		    return;
		}
	    }
	    
	    success = false;
	}
}
