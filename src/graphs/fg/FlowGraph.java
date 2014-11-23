package graphs.fg;

import graphs.Block;

import java.util.ArrayList;

import ast.statement.Statement;

public abstract class FlowGraph {
	// instance field
	private static ArrayList<Block> blocks; // all the blocks in the whole graph
	private ArrayList<Integer> labels; // the block labels in this graph
	private ArrayList<Flow> flow; // the flows in this graph
	private int init; // init label of this graph
	private ArrayList<Integer> fin; // final set of this graph
	private int ancestorBoolLabel; // used in ud-chain

	/**
	 * init variables
	 * 
	 * @param st
	 */
	public FlowGraph(Statement st) {
		blocks = getBlocks();
		labels = new ArrayList<Integer>();
		flow = new ArrayList<Flow>();
		fin = new ArrayList<Integer>();
		ancestorBoolLabel = -1;
	}

	// methods
	public static ArrayList<Block> getBlocks() {
		if (blocks == null)
			blocks = new ArrayList<Block>();
		return blocks;
	}

	public ArrayList<Flow> getFlow() { // simply returns the flow, the same for
									// other getters
		return this.flow;
	}

	public void setInit(int init) {
		this.init = init;
	}

	public int getInit() {
		return this.init;
	}

	public ArrayList<Integer> getFinal() {
		return this.fin;
	}

	public ArrayList<Integer> getLabels() {
		return this.labels;
	}

	public void setAncestorBoolLabel(int value) {
		this.ancestorBoolLabel = value;
	}

	public int getAncestorBoolLabel() {
		return this.ancestorBoolLabel;
	}

	public String toString() {// print the graph

		// all the blocks in the graph
		String ret = "blocks: ";
		if(blocks !=null){
		for (Block b : blocks) {
			if(b!=null){
			ret += "[" + b.toString() + "] ";
			}
		}
		}

		// the labels in this graph
		if(labels !=null){
		ret += "\nlabels: ";
		for (int l : labels) {
			ret += l + " ";
		}
		}

		// the flows in the graph
		if(flow !=null){
		ret += "\nflow: ";
		for (Flow f : flow) {
			ret += f.toString() + " ";
		}
		}

		// the init point
		ret += "\ninit: " + init;

		// the final set
		ret += "\nfinal: ";
		for (int f : fin) {
			ret += f + " ";
		}
		ret += "\n";

		return ret;
	}

}
