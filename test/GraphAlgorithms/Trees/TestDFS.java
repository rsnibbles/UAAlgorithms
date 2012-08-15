package test.GraphAlgorithms.Trees;
import java.util.*;
import main.GraphAlgorithms.Trees.DFS;

public class TestDFS
{
	public static boolean success = true;
	public static void main(String[] args)
	{
		testOne(true);
		if(!success)
		{
			System.out.println("FAILED: TestDFS");
			System.exit(1);
		}
		else
		{
			System.exit(0);
		}
	}

	public static void testOne(boolean printDebug)
	{
		DFS.Node[] tree = new DFS.Node[7];

		for (int i = 0; i < 7; ++i) {
			tree[i] = new DFS.Node();
			char name = (char)('A' + i);
			tree[i].name = Character.toString(name);
		}

		ArrayList<DFS.Node> graph = new ArrayList<DFS.Node>();
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

		for(DFS.Node node : tree)
			graph.add(node);

		DFS dfs = new DFS();
		ArrayList<DFS.Node> traversal = dfs.DFS(graph);

		for (int i = 0; i < traversal.size(); ++i) {
			if(!traversal.get(i).name.equals(Character.toString((char)('A' + i)))) {
				success = false;
				return;
			}
		}

		traversal = dfs.DFS(graph, 6);
		if (traversal.size() > 1 || !traversal.get(0).name.equals("G")) {
			success = false;
			return;
		}
	}

	public static void testTwo(boolean printDebug)
	{
		DFS.Node[] tree = new DFS.Node[7];

		for (int i = 0; i < 7; ++i) {
		tree[i] = new DFS.Node();
		char name = (char)('A' + i);
		tree[i].name = Character.toString(name);
		}

		ArrayList<DFS.Node> graph = new ArrayList<DFS.Node>();
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

		for(DFS.Node node : tree)
			graph.add(node);

		DFS dfs = new DFS();
		ArrayList<DFS.Node> traversal = dfs.DFS(graph, 6);

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
