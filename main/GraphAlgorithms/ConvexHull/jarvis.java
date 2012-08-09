import java.util.*;
import java.awt.geom.*;

public class jarvis{

	public ArrayList doJarvis(ArrayList <Point2D> points)
	{
		Point2D leftMost=points.get(0);
		Point2D endpoint;
		ArrayList <Point2D> pointsAdded=new ArrayList <Point2D> ();
		int i=0;
		for(Point2D p: points)
		{
			if(p.getX()<leftMost.getX())
				leftMost=p;
		}
		do{
			pointsAdded.add(leftMost);
			endpoint=points.get(0);
			for(int j=1;j<points.size();j++)
			{
				if((endpoint==leftMost)||(points.get(j).getX()<pointsAdded.get(i).getX()))
					endpoint=points.get(j);
			}
			i++;
			leftMost=endpoint;
		}while(endpoint != pointsAdded.get(0));
		
		return pointsAdded;
	}
}