package program_slicing;

import free_variables.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;


import graphs.fg.FlowGraph;

public class ProgramSlice {
	private static int InterestingPoint;
	private static ArrayList<Integer> slice;
	private static ArrayList<Integer> workList;
	private static FlowGraph fg;

	public ProgramSlice(FlowGraph fg, int InterestingPoint) {
		ProgramSlice.fg = fg;
		ProgramSlice.InterestingPoint = InterestingPoint;
		workList = new ArrayList<Integer>();
		slice = new ArrayList<Integer>();
	}

	public void setInterestingPoint(int InterestingPoint) {
		ProgramSlice.InterestingPoint = InterestingPoint;
	}

	public int getInterestingPoint() {
		return InterestingPoint;
	}

	public static ArrayList<Integer> getudchain(FreeVariable fv,
			int InterestingPoint) {
		ArrayList<Integer> udChain = new ArrayList<Integer>();
		ReachingDefinitionColln rdEntry = new ReachingDefinitionColln();
		rdEntry = ReachingDefinitionAnalysis.getRdEntry(InterestingPoint);
		for (ReachingDefinition rd : rdEntry) {
			if (rd.getVariableName().compareTo(fv.getVariableName()) == 0) {
				udChain.add(rd.getLineNumber());
			}
		}
		return udChain;
	}

	public ArrayList<Integer> slicing() {

		int currentLineOfInterest;
		ArrayList<FreeVariable> variablesInLine = new ArrayList<>();
		ArrayList<Integer> udChain = new ArrayList<>();

		if (InterestingPoint > FlowGraph.getBlocks().size()
				|| InterestingPoint <= 0) {
			System.out
					.println("Point of interest outside the number of lines in the program.");
			return null;
		} else {
			ReachingDefinitionAnalysis.initialize(fg);
			ReachingDefinitionAnalysis.analyze();
			ReachingDefinitionAnalysis.printAnalysis();
			BooleanAncestorFinder.computeBoolAncestor();
			
			//workList algorithm
			workList.add(InterestingPoint);
			while (!workList.isEmpty()) {
				currentLineOfInterest = workList.get(0);
				workList.remove(0);
				slice.add(currentLineOfInterest);
				variablesInLine = FreeVariableGenerator
						.getFreeVariablesinLine(currentLineOfInterest);
				if (!variablesInLine.isEmpty()) {
					for (FreeVariable fv : variablesInLine) {
						if (fv.getVariablePosition() != VariablePosition.left
								&& !(fv.getVariablePosition() == VariablePosition.write && slice
										.size() > 1)) {
							udChain = getudchain(fv, currentLineOfInterest);
							for (int label : udChain) {
								if (!slice.contains(label)
										&& !workList.contains(label)
										&& label != 0) {
									workList.add(label);
								}
							}
						}

					}
					int booleanAncestor = BooleanAncestorFinder.getAncestors()
							.get(currentLineOfInterest - 1);
					if (!workList.contains(booleanAncestor)
							&& !slice.contains(booleanAncestor)
							&& booleanAncestor != 0) {
						workList.add(booleanAncestor);
					}
				}
			}
			Collections.sort(slice);
			return slice;
		}
	}

	public String toString(){
		String str="The program slice when point of interest \n";
		for (int i = 0; i < slice.size(); i++) {
			str += slice.get(i) + ",";
		}
		return str;
	}
	
}
