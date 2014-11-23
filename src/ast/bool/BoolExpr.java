package ast.bool;

import graphs.Block;
import dynamic_analysis.Environment;
import dynamic_analysis.VariableNotDefinedException;

import java.lang.String;
import java.util.ArrayList;


public abstract class BoolExpr implements Block{

	public abstract boolean evaluate(Environment env) throws VariableNotDefinedException;	
	public abstract ArrayList<String> getVariables();
}
