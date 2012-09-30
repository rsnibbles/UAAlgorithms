package main.GraphAlgorithms.MST;
import java.util.*;

/*

This handles the basic case of Prim's algorithm for constructing a minimum
spanning tree. This currently accepts a list of nodes with the connections
specified in each node.

*/
public class Prims {
	
	// takes a list of Nodes to describe the graph
	public ArrayList<Node> runPrim (ArrayList<Node> graph) {

		// use a hashtable for O(1) lookup of already connected nodes 
		Hashtable<Node, Boolean> connectedHash = new Hashtable<Node, Boolean>();

		// holds the actual MST
		ArrayList<Node> MST = new ArrayList<Node>();
		
		// first node is "connected"
		connectedHash.put(graph.get(0), true);
		MST.add(graph.get(0));

		// keep going until all nodes are in the connected list
		while (connectedHash.size() != graph.size())
		{
			// need to get the list of all connected nodes for each iteration
			Node[] connectedList = (Node[])connectedHash.keySet().toArray();

			// used to find the next connection to add
			Node bestNode = null;
			Connection bestConnection = new Connection();
			int bestConnectionOriginIndex = 0;		
	
			// loop each node that is already connected to the MST
			for(int i = 0; i < connectedList.length; ++i)
			{
				// get all the nodes neighbors
				ArrayList<Connection> nConnections = connectedList[i].connList;

				for (int j = 0; j < nConnections.size(); j++)
				{
					Connection currentConn = nConnections.get(i);
					
					// dont consider connections that would link already connected nodes
					if (connectedHash.get(currentConn.neighbor) != null) {
						continue;
					}

					// first possible connection is our temp best
					if (bestNode == null)
					{
						bestNode = currentConn.neighbor;
						bestConnection = currentConn;
						bestConnectionOriginIndex = i;
					}
					else if (currentConn.weight < bestConnection.weight)
					{
						bestNode = currentConn.neighbor;
						bestConnection.weight = currentConn.weight;
					}
				}
					
			}
			
			// add the best node to the connected list
			connectedHash.put(bestNode, true);

			// add bi-directional connection
			Node originNode = connectedList[bestConnectionOriginIndex];
			bestNode.connList.add(new Connection(originNode, bestConnection.weight));
			originNode.connList.add(new Connection(bestNode, bestConnection.weight));			

			// add best node to MST
			MST.add(bestNode);

			// reset for next iteration
			bestNode = null;
		}

		return MST;
	}

	public class Connection {
		public Node neighbor;
		public int weight;
		
		public Connection()
		{
		}

		public Connection(Node n, int w) {
			neighbor = n;
			weight = w;
		}
	}

	public class Node {
		public ArrayList<Connection> connList;

		public Node() {
			connList = new ArrayList<Connection>();
		}
	}
}
