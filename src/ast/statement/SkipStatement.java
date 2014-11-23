package ast.statement;

import java.util.ArrayList;

import dynamic_analysis.Environment;
import dynamic_analysis.VariableNotDefinedException;

public class SkipStatement extends Statement {

	public SkipStatement() { }
	
	@Override
	public void evaluate(Environment env) throws VariableNotDefinedException {
		return;
	}
	@Override
	public ArrayList<String> getVariables() {		
				return null;
	}
	@Override
	public ArrayList<String> getArrays() {
		ArrayList<String> vars = new ArrayList<String>();
		return vars;	
	}
	@Override
	public String toString() {
		return "skip;";
	}

	@Override
	public int printWithLabels(int i) {
		System.out.println("[skip]^"+i+";");
		return ++i;
	}
}
