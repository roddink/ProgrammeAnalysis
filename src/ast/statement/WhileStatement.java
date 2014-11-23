package ast.statement;

import java.util.ArrayList;

import dynamic_analysis.Environment;
import dynamic_analysis.VariableNotDefinedException;
import ast.bool.BoolExpr;

/**
 * while b do S od
 * @author zhenli
 *
 */
public class WhileStatement extends Statement {

	private BoolExpr condition;
	private Statement body;
	
	public WhileStatement(BoolExpr condition, Statement body) {
		this.condition = condition;
		this.body = body;
	}
	
	@Override
	public void evaluate(Environment env) throws VariableNotDefinedException {
		while (condition.evaluate(env)) {
			body.evaluate(env);	
		}
	}
	@Override
	public ArrayList<String> getVariables() {
		ArrayList<String> vars = new ArrayList<String>();
		try {
			vars.addAll(condition.getVariables());
		}
		catch(Exception e){
		}
		try{
			vars.addAll(body.getVariables());
		}
		catch(Exception e)
		{
		} 
		if (!vars.isEmpty())
				return vars;
			else
				return null;
	}
	
	@Override
	public ArrayList<String> getArrays() {
		ArrayList<String> vars = new ArrayList<String>();
		vars.addAll(condition.getArrays());
		vars.addAll(body.getArrays());
		return vars;	
	}
	@Override
	public String toString() {
		return "while " + condition + " do \n" + body + "\nod";
	}

	// getters and setters
	public BoolExpr getCondition() {
		return condition;
	}

	public void setCondition(BoolExpr condition) {
		this.condition = condition;
	}

	public Statement getBody() {
		return body;
	}

	public void setBody(Statement body) {
		this.body = body;
	}

	@Override
	public int printWithLabels(int _i) {
		int i=_i;
		System.out.println("while ["+ condition + "]^"+i+" do" );
		i=body.printWithLabels(++i);
		System.out.println("od");
		return i;
	}
	
	

}
