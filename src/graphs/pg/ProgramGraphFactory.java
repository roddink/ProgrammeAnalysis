package graphs.pg;

import ast.statement.ArrayAssignStatement;
import ast.statement.AssignStatement;
import ast.statement.IfStatement;
import ast.statement.ReadArrayStatement;
import ast.statement.ReadStatement;
import ast.statement.SeqStatement;
import ast.statement.SkipStatement;
import ast.statement.Statement;
import ast.statement.WhileStatement;
import ast.statement.WriteStatement;

public class ProgramGraphFactory {
	
	public static void create(Statement st, int initialNode, int finalNode) {
		
		if(st instanceof IfStatement)
			new IfProgramGraph((IfStatement) st, initialNode, finalNode);
		else if( st instanceof WhileStatement)
			new WhileProgramGraph((WhileStatement) st, initialNode, finalNode);
		else if( st instanceof SeqStatement)
			new SeqProgramGraph((SeqStatement) st, initialNode, finalNode);
		else if( st instanceof AssignStatement)
			new AssignProgramGraph((AssignStatement) st, initialNode, finalNode);
		else if( st instanceof ArrayAssignStatement)
			new ArrayAssignProgramGraph((ArrayAssignStatement) st, initialNode, finalNode);
		else if( st instanceof WriteStatement)
			new WriteProgramGraph((WriteStatement) st, initialNode, finalNode);
		else if( st instanceof ReadStatement)
			new ReadProgramGraph((ReadStatement) st, initialNode, finalNode);
		else if( st instanceof ReadArrayStatement)
			new ReadArrayProgramGraph((ReadArrayStatement) st, initialNode, finalNode);
		else if( st instanceof SkipStatement)
			new SkipProgramGraph((SkipStatement) st, initialNode, finalNode);
	}
		
}
