package ast.bool;

import java.util.ArrayList;

import dynamic_analysis.Environment;
import dynamic_analysis.VariableNotDefinedException;

public class NotExpr extends BoolExpr {

	private BoolExpr expression;
	
	public NotExpr(BoolExpr expression) {
		this.expression = expression;
	}
	
	@Override
	public boolean evaluate(Environment env) throws VariableNotDefinedException {
		return !expression.evaluate(env);
	}
	@Override
	public ArrayList<String> getVariables() {
		ArrayList<String> vars = new ArrayList<String>();
		try {
		vars.addAll(expression.getVariables());
			return vars;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public ArrayList<String> getArrays() {
		ArrayList<String> vars = new ArrayList<String>();
		vars.addAll(expression.getArrays());
		return vars;	
	}
	@Override
	public String toString() {
		return  "!" + expression;
	}

	public BoolExpr getExpression() {
		return expression;
	}
	
	
}
