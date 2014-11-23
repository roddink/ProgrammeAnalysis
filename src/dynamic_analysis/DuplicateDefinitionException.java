package dynamic_analysis;

public class DuplicateDefinitionException extends Exception {

	private static final long serialVersionUID = 1L;

	private String variableName;
	
	public DuplicateDefinitionException(String name) {
		this.variableName = name;
	}
	
	public String toString() {
		return "The variable " + variableName + " has already been defined.";
	}
}
