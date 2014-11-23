package ast.bool;

import java.util.ArrayList;

import dynamic_analysis.Environment;
import dynamic_analysis.VariableNotDefinedException;
import ast.arith.ArithExpr;

public class LessThanExpr extends BoolExpr {

	private ArithExpr expression1;
	private ArithExpr expression2;
	
	public LessThanExpr(ArithExpr expression1, ArithExpr expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
	}
	
	@Override
	public boolean evaluate(Environment env) throws VariableNotDefinedException {
		return expression1.evaluate(env) < expression2.evaluate(env);
	}
	@Override
	public ArrayList<String> getVariables() {
		ArrayList<String> vars = new ArrayList<String>();
		try {
			vars.addAll(expression1.getVariables());
		}
		catch(Exception e){
		}
		try{
			vars.addAll(expression2.getVariables());
		}
		catch(Exception e){
		}
		if (!vars.isEmpty())
				return vars;
			else
				return null;
	}
	@Override
	public ArrayList<String> getArrays() {
		ArrayList<String> vars = new ArrayList<String>();
		vars.addAll(expression1.getArrays());
		vars.addAll(expression2.getArrays());
		return vars;	
	}
	@Override
	public String toString() {
		return expression1 + "<" + expression2;
	}

	public ArithExpr getExpression1() {
		return expression1;
	}

	public ArithExpr getExpression2() {
		return expression2;
	}
	
	
}
