package program_slicing;

import free_variables.*;
import graphs.fg.FlowGraph;
import graphs.Block;
import ast.statement.*;

import java.util.ArrayList;
/**
 * print the AST built
 * 
 * @author Zheng Zhang
 * 
 */

public class killAnalysis {
	private static ArrayList<Block> blockList;
	private static ArrayList<ReachingDefinitionColln> killList;
	
	public killAnalysis(){
		blockList=FlowGraph.getBlocks();
		killList=new ArrayList<ReachingDefinitionColln>();
	}
	
	public void calculateKill(){
		int label=1;
		for(Block b: blockList){
			if(b instanceof ReadStatement){
				
			}else if(b instanceof ArrayAssignStatement){
				
			}else if(b instanceof AssignStatement){
				
			}else {
				ReachingDefinitionColln rdc=null;
				killList.add(rdc);
			}
			label++;
		}
	}
}
