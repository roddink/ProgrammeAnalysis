package dynamic_analysis;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

import ast.Program;
import parser.*;

/**
 * run the sample program
 * @author zhenli
 *
 */
public class TheLang {

	public static void main(String args[]) throws Exception {
		if (args.length == 0) {
			System.out.println("Error: No program specified.");
			return;
		}

		TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(args[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);

		TheLangParser parser = new TheLangParser(tokens);
		Program program = parser.program();

		try {
			Environment env = new Environment();
			program.evaluate(env);
			System.out.println(env.toString());
		} catch (DuplicateDefinitionException e) {
			System.out.println("Error: " + e);
		} catch (VariableNotDefinedException e) {
			System.out.println("Error: " + e);
		} catch (NullPointerException e) {
			System.out.println("Error parsing program.");
		}

	}
	
}
