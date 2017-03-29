package edu.frostburg.cosc470.cornucopia.errors;

/**
 * Handles errors produced by the compiler and safely terminates
 * the program.
 * 
 * @author 	James Champ
 * @version	0.8, May 17, 2016
 */
public class ErrorHandler 
{
	
	/**
	 * Creates a new error handler. Prints a new line symbol.
	 */
	public ErrorHandler()
	{
		System.out.println();
	}
	
	/**
	 * Alerts the user that they cannot evaluate a single character
	 * in an if statement. Ends program.
	 */
	public void illegalIfExpressionError()
	{
		System.out.println("Cannot evaluate single character in if statement...");
		terminateProgram();
	}
	
	/**
	 * Alerts the user that they forgot to enter an input file path
	 * in the command line. Ends program.
	 */
	public void missingFileError()
	{
		System.out.println("No input file entered...");
		terminateProgram();
	}
	
	/**
	 * Informs the user that a type mismatch has occurred.
	 * Ends program.
	 */
	public void typeMismatchError()
	{
		System.out.println("Type mismatch occurred...");
		terminateProgram();
	}
	
	/**
	 * Informs user that a variable was not declared.
	 * 
	 * @param _id	The undeclared id.
	 */
	public void undeclaredIdError(String _id)
	{
		System.out.println("Undeclared variable:\t" + _id + " was not declared...");
		terminateProgram();
	}
	
	/**
	 * Informs user that a variable was used without being initialized.
	 * 
	 * @param _id	The uninitialized variable.
	 */
	public void uninitializedIdError(String _id)
	{
		System.out.println("Uninitialized varible:\t" + _id + " was not initialized...");
		terminateProgram();
	}
	
	/**
	 * Informs the user that a variable was used without it's type being known.
	 * Ends program.
	 * 
	 * @param _id	The id in question.
	 */
	public void idWithNoTypeError(String _id)
	{
		System.out.println("Unknown type:\t" + _id + " has an unknown type...");
		terminateProgram();
	}
	
	/**
	 * Informs the user that a variable was declared twice. 
	 * Ends program.
	 * 
	 * @param _id	The variable in question.
	 */
	public void idDeclaredError(String _id)
	{
		System.out.println("Variable declared twice:\t" + _id + "was already declared...");
		terminateProgram();
	}
	
	/**
	 * Informs user that a relational operation cannot be used to assign
	 * a value to a variable.
	 */
	public void relopError()
	{
		System.out.println("Cannot use relational operator to assign a value to a variable...");
		terminateProgram();
	}
	
	/**
	 * Informs user that characters cannot multiplied.
	 */
	public void charMultiplyError()
	{
		System.out.println("Cannot perform multiplication operations on characters...");
		terminateProgram();
	}
	
	/**
	 * Informs user that characters cannot be added or subtracted.
	 */
	public void charAddError()
	{
		System.out.println("Cannot perform addition operations on characters...");
		terminateProgram();
	}
	
	/**
	 * Informs user that they cannot divide by zero.
	 */
	public void divideByZeroError()
	{
		System.out.println("Cannot divide by zero...");
		terminateProgram();
	}
	
	/**
	 * Informs user that a syntax error has occurred.
	 * 
	 * @param _line	Line number of error.
	 * @param _col	Column number of error.
	 */
	public void syntaxError(int _line, int _col)
	{
		System.out.println("Syntax error at line " + _line + "\tcolumn " + _col);
		terminateProgram();
	}
	
	/**
	 * Informs user that their program contains an invalid token.
	 */
	public void invalidTokenError(String _token, int _line, int _column)
	{
		System.out.println("Invalid token:\t" + _token + "  line: " + (_line + 1) + " column: " + _column);
		terminateProgram();
	}
	
	/**
	 * Ends program.
	 */
	private void terminateProgram()
	{
		System.out.println("\nCompilation unsuccessful.\nEnding program...");
		System.exit(-1);
	}
}
