public class Floyd
{
	/* 
		This assumes that the Adjacency Matrix has already been constructed,
		that if there is no connection between two nodes that it is sufficiently large
		and that the connection between a node and itself is 0
	*/

	int[][] floyds(int[][] adjacencyMatrix)
	{
		int[][] aMatrix = adjacencyMatrix;
		int n = aMatrix.length; 
		for(int k = 0; k < n; ++k)
		{
			for(int i = 0; i < n; ++i)
			{
				for(int j = 0; j < n; ++j)
				{
					aMatrix[i][j] = Math.min(aMatrix[i][j], aMatrix[i][k]+aMatrix[k][j]);	
				}
			}
		}
		return aMatrix;
	}
}
