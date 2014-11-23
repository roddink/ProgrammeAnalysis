package ast.statement;

import java.util.ArrayList;

import dynamic_analysis.Environment;
import dynamic_analysis.VariableNotDefinedException;

/**
 * Unfinished evaluate method read x;
 * 
 * @author zhenli
 * 
 */
public class ReadStatement extends Statement {
	String name; // variable name

	public ReadStatement(String name) {
		this.name = name;
	}

	@Override
	public void evaluate(Environment env) throws VariableNotDefinedException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> getVariables() {
		ArrayList<String> vars = new ArrayList<String>();
		vars.add(name);	
		return vars;
	}

	@Override
	public ArrayList<String> getArrays() {
		ArrayList<String> vars = new ArrayList<String>();
	return vars;
	}

	@Override
	public String toString() {
		return "read " + name + ";";
	}
	public int printWithLabels(int i){
		System.out.println("[read " + name + "]^"+i+";");
		return ++i;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
