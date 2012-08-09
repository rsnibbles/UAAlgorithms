import java.util.*;

public class Bellford
{

	public ArrayList<Node> doBellford(ArrayList<Node> nodes, ArrayList<Edge> edges, Node source)
	{
		for(Node n: nodes)
		{
			if( n == source )
				n.distance = 0;
			else
				n.distance = Integer.MAX_VALUE;
			n.predecessor = null;
		}
		
		for(int i = 1; i < nodes.size(); i++)
		{
			for(Edge e: edges)
			{
				Node s = e.source;
				Node d = e.destination;
				if( s.distance + e.weight < d.distance )
				{
					d.distance = s.distance + e.weight;
					d.predecessor = s;
				}
			}
		}
		
		for(Edge e: edges)
		{
			Node s = e.source;
			Node d = e.destination;
			if(s.distance + e.weight < d.distance)
				System.out.println("Graph contains a negative-weight cycle");
		}
		
		return nodes;
	}
	
	public class Node
	{
		Node predecessor = null;
		int distance;
		
		public Node()
		{
			distance = 0;
		}
	}

	public class Edge
	{
		Node source, destination;
		int weight;
		
		public Edge(Node s, Node d, int w)
		{
			source = s;
			destination = d;
			weight = w;
		}
	}
}
