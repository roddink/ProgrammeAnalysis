package graphs.pg;

import graphs.Block;
import ast.statement.SkipStatement;

public class SkipProgramGraph extends ProgramGraph {
	public SkipProgramGraph (SkipStatement st, int initialNode, int finalNode) {   //constructor  
		Block block = st;
		if (edges.isEmpty()== false)
			//edges.add(new Edge(initialNode, block, finalNode > 0 ? finalNode : edges.get(edges.size()-1).qt +1)); 
			edges.add(new Edge(initialNode, block, finalNode > 0 ? finalNode : GreatestNumUsed +1)); 
		else 
			edges.add( new Edge(1, block,2) ); 
		if (GreatestNumUsed < edges.get(edges.size()-1).qt) 
			GreatestNumUsed = edges.get(edges.size()-1).qt;
	}
}