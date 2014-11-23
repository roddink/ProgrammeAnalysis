package ast.bool;

import dynamic_analysis.Environment;
import dynamic_analysis.VariableNotDefinedException;

import java.lang.String;
import java.util.ArrayList;

public class BoolValueExpr extends BoolExpr {

	private boolean value;
	
	public BoolValueExpr(boolean value) {
		this.value = value;
	}
	
	@Override
	public boolean evaluate(Environment env) throws VariableNotDefinedException {
		return value;
	}
	@Override
	public ArrayList<String> getVariables(){
		return null;
	}
	
	@Override
	public String toString() {
		if (value)
			return "true";
		else 
			return "false";
	}

	public boolean getBoolValue() {
		return value;
	}

	@Override
	public ArrayList<String> getArrays() {
		ArrayList<String> vars = new ArrayList<String>();
		return vars;	
	}
}
