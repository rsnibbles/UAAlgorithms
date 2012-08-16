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
		BFS.Node[] tree = new BFS.Node[7];

		for (int i = 0; i < 7; ++i) {
			tree[i] = new BFS.Node();
			char name = (char)('A' + i);
			tree[i].name = Character.toString(name);
		}

		ArrayList<BFS.Node> graph = new ArrayList<BFS.Node>();
		tree[0].children.add(tree[1]);
		tree[0].children.add(tree[2]);

		tree[1].children.add(tree[0]);
		tree[1].children.add(tree[3]);
		tree[1].children.add(tree[4]);

		tree[2].children.add(tree[0]);
		tree[2].children.add(tree[5]);
		tree[2].children.add(tree[6]);

		tree[3].children.add(tree[1]);

		tree[4].children.add(tree[1]);

		tree[5].children.add(tree[2]);

		tree[6].children.add(tree[2]);

		for(BFS.Node node : tree)
			graph.add(node);

		BFS bfs = new BFS();
		ArrayList<BFS.Node> traversal = bfs.BFSTraversal(graph);
		
		// Traversal of graph is expected to be in alphabetical order
		for (int i = 0; i < traversal.size(); ++i) {
			if(!traversal.get(i).name.equals(Character.toString((char)('A' + i)))) {
				success = false;
				return;
			}
		}

		// We're traversing the graph again and nodes are still visited so we only get one
		traversal = bfs.BFSTraversal(graph, 6);
		if (traversal.size() > 1 || !traversal.get(0).name.equals("G")) {
			success = false;
			return;
		}
	}

	public static void testTwo(boolean printDebug)
	{
		BFS.Node[] tree = new BFS.Node[7];

		for (int i = 0; i < 7; ++i) {
		tree[i] = new BFS.Node();
		char name = (char)('A' + i);
		tree[i].name = Character.toString(name);
		}

		ArrayList<BFS.Node> graph = new ArrayList<BFS.Node>();
		tree[0].children.add(tree[1]);
		tree[0].children.add(tree[2]);

		tree[1].children.add(tree[0]);
		tree[1].children.add(tree[3]);
		tree[1].children.add(tree[4]);

		tree[2].children.add(tree[0]);
		tree[2].children.add(tree[5]);
		tree[2].children.add(tree[6]);

		tree[3].children.add(tree[1]);

		tree[4].children.add(tree[1]);

		tree[5].children.add(tree[2]);

		tree[6].children.add(tree[2]);

		for(BFS.Node node : tree)
			graph.add(node);

		BFS bfs = new BFS();
		ArrayList<BFS.Node> traversal = bfs.BFSTraversal(graph, 6);

		String[] answer = { "G", "C", "A", "F", "B", "D", "E" };

		for(int i = 0; i < answer.length; ++i) {
			if (!answer[i].equals(traversal.get(i).name)) {
				success = false;
				return;
			}
		}

		success = true;
	}
}

