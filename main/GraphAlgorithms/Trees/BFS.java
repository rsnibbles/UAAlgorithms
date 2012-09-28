//In case you didn't know it's O(n) :D
package main.GraphAlgorithms.Trees;
import java.util.*;

public class BFS
{
	/*
	 * given the an array of nodes, will traverse the entire tree in a breadth
	 * first search, starting from the node at graph.get(0)
	 */
	public ArrayList<Node> BFSTraversal(ArrayList<Node> graph)
	{
		return this.BFSTraversal(graph, 0);
	}

	/*
	 * Same as above but you can specify a starting point.
	 */
	public ArrayList<Node> BFSTraversal(ArrayList<Node> graph, int start)
	{
		ArrayList<Node> order = new ArrayList<Node>();
		ArrayList<Node> queue = new ArrayList<Node>();

		queue.add(graph.get(start));
		queue.get(0).visited = true; // so that we don't visit it again
		while(!queue.isEmpty())
		{
			Node cur_node = queue.remove(0);
			order.add(cur_node);

			for(Node child : cur_node.children)
			{
				if(!child.visited)
				{
					queue.add(child);
					child.visited = true;
				}
			}
		}
		return order;
	}

	public static class Node
	{
		public ArrayList<Node> children;
		public boolean visited = false;
		public String name = "(no name)";

		public Node()
		{
			this.children = new ArrayList<Node>();
			this.visited = false;
			this.name = "(no name)";
		}
	}
}
