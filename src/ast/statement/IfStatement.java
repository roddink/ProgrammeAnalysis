package ast.statement;

import java.util.ArrayList;

import dynamic_analysis.Environment;
import dynamic_analysis.VariableNotDefinedException;
import ast.bool.BoolExpr;

/**
 * if b then S1 else S2 fi
 * 
 * @author zhenli
 * 
 */
public class IfStatement extends Statement {

	private BoolExpr condition;
	private Statement ifBranch;
	private Statement elseBranch;

	public IfStatement(BoolExpr condition, Statement ifBranch,
			Statement elseBranch) {
		this.condition = condition;
		this.ifBranch = ifBranch;
		this.elseBranch = elseBranch;
	}

	@Override
	public void evaluate(Environment env) throws VariableNotDefinedException {
		if (condition.evaluate(env)) {
			ifBranch.evaluate(env);
		} else {
			elseBranch.evaluate(env);
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
			vars.addAll(ifBranch.getVariables());
		}
		catch(Exception e){
		}
		try{
			vars.addAll(elseBranch.getVariables());
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
		vars.addAll(condition.getArrays());
		vars.addAll(ifBranch.getArrays());
		vars.addAll(elseBranch.getArrays());
		return vars;
		}
	@Override
	public String toString() {
		return "if " + condition + " then \n" + ifBranch + "\nelse \n" + elseBranch
				+ "\n fi ";
	}
	public int printWithLabels(int _i) {
		int i=_i;
		System.out.println( "if [" + condition + "]^"+ i +" then");
		i=ifBranch.printWithLabels(++i) ;
		System.out.println("else");
		i=elseBranch.printWithLabels(i) ;
		System.out.println("fi");
		return i;
	}

	// getters and setters
	public BoolExpr getCondition() {
		return condition;
	}

	public void setCondition(BoolExpr condition) {
		this.condition = condition;
	}

	public Statement getIfBranch() {
		return ifBranch;
	}

	public void setIfBranch(Statement ifBranch) {
		this.ifBranch = ifBranch;
	}

	public Statement getElseBranch() {
		return elseBranch;
	}

	public void setElseBranch(Statement elseBranch) {
		this.elseBranch = elseBranch;
	}

}
