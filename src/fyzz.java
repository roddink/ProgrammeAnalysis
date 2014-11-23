import interval_analysis.IntervalAnalysis;
import free_variables.FreeVariableGenerator;
import graphs.fg.*;
import graphs.pg.*;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

import detectionOfSign_analysis.DSWorklist;
import SecurityAnalysis.SecLevelWorklist;
import ast.Program;
import parser.TheLangLexer;
import parser.TheLangParser;
import program_slicing.ProgramSlice;

/**
 * print the AST built
 * 
 * @author Zheng Zhang
 * 
 */
public class fyzz {

	public static void main(String args[]) throws Exception {
		String fileName = "test/sample.lang";
		int order = 1;
		int min = 0, max = 10;
		int interestingPoint = 6;
		// parsing
		TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(fileName));
		CommonTokenStream tokens = new CommonTokenStream(lex);

		// building ast
		TheLangParser parser = new TheLangParser(tokens);
		Program program = parser.program();
		// print the ast
		System.out.println(program.toString());

		ProgramGraph pg = new ProgramGraph(program.getStatement());
		if (order > 1 && order < 5) {
			System.out.println("\nProgram graph: ");
			System.out.println(pg.toString());
		}

		FlowGraph fg = FlowGraphFactory.create(program.getStatement());
		FreeVariableGenerator.extractVariables();
		if (order == 1) {
			// Program Slice & Reaching Definition
			System.out.println("\nFlow graph:");
			System.out.println(fg.toString());
			System.out.println(FreeVariableGenerator.printVariables());
			ProgramSlice ps = new ProgramSlice(fg, interestingPoint);
			ps.slicing();
			System.out.println(ps.toString());
		} else if (order == 2) {
			// Detect of signs
			DSWorklist dsw = new DSWorklist(ProgramGraph.edges,
					FreeVariableGenerator.getAllVariables());
			dsw.printSolutionsTable();
			System.out.println("\nLow boundary violations for array indexing:");
			System.out.println(dsw.toString(dsw
					.findLowBoundaryViolations(ProgramGraph.edges)));
		} else if (order == 3) {
			// interval_analysis
			IntervalAnalysis
					.analyze(min, max, FreeVariableGenerator.getAllVariables(),
							ProgramGraph.edges);
			IntervalAnalysis.printSolutionTable();
			IntervalAnalysis.printViolatedEdges();
		} else if (order == 4) {
			// SecAnalysis
			SecLevelWorklist slw = new SecLevelWorklist(ProgramGraph.edges,
					ProgramGraph.boolEndingedges, program);
			slw.printSolutionsTable();
			System.out.println("\nSecurity level violations:");
			System.out.println(slw.toString(slw
					.findSecurityLevelViolations(ProgramGraph.edges)));
		}
	}

	public static void printCommands() {
		System.out.println("Usage: File cmd [min max]");
		System.out
				.println("cmd:\t1 - program slice\n\t2 - detection of signs\n\t3 - interval analysis"
						+ "\n\t4 - security analysis");
		System.out.println("Example:\tfile1 1\n\t\tfile1 3 0 4");
	}
}
