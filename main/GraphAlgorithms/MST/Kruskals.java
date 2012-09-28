//Time complexity O(ElogE) where E is the number of edges.
package main.GraphAlgorithms.MST;
import java.util.*;

public class Kruskals {

	// performs Kruskal's MST algorithm with a list of nodes in the starting graph and list of connections
	public ArrayList<Connection> doKruskals(ArrayList<Node> nodes, ArrayList<Connection> connections){

		// sort the connections to perform the algorithm
		Collections.sort(connections);

		// starting "forests"
		ArrayList<ArrayList<Node>> forest = new ArrayList<ArrayList<Node>>();
		
		// make each node its own tree to begin with
		for(int i = 0; i < nodes.size(); ++i)
		{
			ArrayList<Node> tree = new ArrayList<Node>();
			tree.add(nodes.get(i));
			forest.add(tree);
		}
		
		ArrayList<Connection> answer = new ArrayList<Connection>();
		
		// add all valid connections
		for(int i = 0; i < connections.size(); i++){
			Connection current = connections.get(i);
			
			// see if connection endpoints are in the same forest
			for(int j = 0; j < forest.size(); ++j)
			{
				ArrayList<Node> currentList = forest.get(j);
				
				// endpoints are in same forest
				if(currentList.contains(current.a) && currentList.contains(current.b))
				{
					break;
				}
				else
				{
					
					
					if(currentList.contains(current.a))
					{
						for(int k = j + 1; k < forest.size(); ++k)
						{
							ArrayList<Node> newCurrent = forest.get(k);
							
							if(newCurrent.contains(current.b))
							{
								currentList.addAll(newCurrent);
								forest.remove(forest.get(k));
								
								current.a.neighbor.add(current.b);
								current.b.neighbor.add(current.a);
								answer.add(current);
								
								break;
							}
						}
					}
					else if(currentList.contains(current.b))
					{
						for(int k = j + 1; k < forest.size(); ++k)
						{
							ArrayList<Node> newCurrent = forest.get(k);
							
							if(newCurrent.contains(current.a))
							{
								currentList.addAll(newCurrent);
								forest.remove(forest.get(k));
								
								current.a.neighbor.add(current.b);
								current.b.neighbor.add(current.a);
								answer.add(current);
								
								break;
							}
						}
					}
				}
			}
		}
		
		return answer;
	}
	
	public class Connection implements Comparable<Connection>
	{
		
		public int compareTo(Connection c){
			
			return this.length - c.length;
		}
	
		public int length;
		public Node a;
		public Node b;
		
		public Connection() {
			
		}
		
		public Connection (Node n1, Node n2, int l) {
			this.a = n1;
			this.b = n2; 
			this.length = l;
		}
		
	}
	
	public class Node
	{
		public String name;
		public ArrayList<Node> neighbor;
		 
		public Node() {
			this.name = "";
			this.neighbor = new ArrayList<Kruskals.Node>();
		}
		
		public Node(String n) {
			this.name = n;
			this.neighbor = new ArrayList<Kruskals.Node>();
		}
	}
}
