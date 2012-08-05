import java.util.*;

public class DFS
{
	// given the an array of nodes, will traverse the entire tree in a depth first search,
	// starting from the node at graph[0]

/*
This doesn't compile so I have commented it out until it is fixed.


	public void DFS(ArrayList<Node> graph)
	{
	
		ArrayList<Node> stack = new ArrayList<Node>();

		stack.add(graph[0]);
		stack[0].visited = true; // so that we don't visit it again
		while(!queue.isEmpty())
		{
			Node cur_node = stack.remove(stack.size()-1); // removes the node on the top of the stack
			cur_node.visited = true;
			for(int index = 0; index < cur_node.children.size(); index++)
			{
				if(!cur_node.children[index].visited)
				{
					stack.add(cur_node.children[index]);
					cur_node.children[index].visited = true;
				}
			}
		}

	}

	class Node
	{
		public Node(ArrayList<Node> childs)
		{
			ArrayList<Node> children = new Arraylist<Node>(childs);
			boolean visited = false;
		}
	}
*/
}
