package ast.statement;

import java.util.ArrayList;

import dynamic_analysis.Environment;
import dynamic_analysis.VariableNotDefinedException;
import ast.arith.ArithExpr;

/**
 * Unfinished evaluate method
 * write a;
 * @author zhenli
 *
 */
public class WriteStatement extends Statement{
	ArithExpr expression;
	
	public WriteStatement(ArithExpr expression) {
		this.expression = expression;
	}

	@Override
	public ArrayList<String> getVariables() {
		ArrayList<String> vars = new ArrayList<String>();
		try {
			vars.addAll(expression.getVariables());
		} catch (Exception e) {
		}
			if (!vars.isEmpty())
				return vars;
			else
				return null;
	}
	
	@Override
	public ArrayList<String> getArrays() {
		ArrayList<String> vars = new ArrayList<String>();
		vars.addAll(expression.getArrays());
		return vars;	
	}
	@Override
	public void evaluate(Environment env) throws VariableNotDefinedException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "write " + expression + ";";
	}

	// setter and getter
	public ArithExpr getExpression() {
		return expression;
	}

	public void setExpression(ArithExpr expression) {
		this.expression = expression;
	}

	@Override
	public int printWithLabels(int i) {
		System.out.println("[write "+expression +"]^"+i+";");
		return ++i;
	}
	
	

}
