package graphs.fg;

import graphs.Block;

import java.util.ArrayList;

import ast.statement.*;

public class WhileFlowGraph extends FlowGraph {

	public WhileFlowGraph(WhileStatement st) {
		super(st);

		ArrayList<Block> blocks = getBlocks();
		ArrayList<Integer> labels = getLabels();
		ArrayList<Flow> flow = getFlow();
		ArrayList<Integer> fin = getFinal();

		// record new blocks and new labels
		int l = blocks.size() + 1;
		Block boolBlock = st.getCondition();
		blocks.add(boolBlock);
		labels.add(l);

		// graph is created recursively
		FlowGraph s = FlowGraphFactory.create(st.getBody());
		// set the ancestor labels in the blocks in the graph as l.
		s.setAncestorBoolLabel(l);
	
		// follow the rules in the table 1.2 and 1.3
		labels.addAll(s.getLabels());
		setInit(l);
		fin.add(l);

		flow.add(new Flow(l, s.getInit()));
		flow.addAll(s.getFlow());
		
		ArrayList<Integer> sFin = s.getFinal();
		for(int i : sFin) {
			flow.add(new Flow(i,l));	
		}
		
	}

}
