package ast.statement;

import java.util.ArrayList;

import graphs.Block;
import dynamic_analysis.Environment;
import dynamic_analysis.VariableNotDefinedException;

public abstract class Statement implements Block{

	public abstract void evaluate(Environment env) throws VariableNotDefinedException;
	public abstract ArrayList<String> getVariables();
	public abstract ArrayList<String> getArrays();
	public abstract int printWithLabels(int i);
}
