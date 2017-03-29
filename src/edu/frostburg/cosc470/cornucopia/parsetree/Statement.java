package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents a statement production.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Statement extends Node
{
	/**
	 * The line number in which an if statement occurred.
	 */
	int lineNumber;	
	
	/**
	 * Creates a new statement node.
	 * 
	 * @param _ruleNum	The rule number for this node.
	 */
	public Statement(int _ruleNum)
	{
		super(_ruleNum);
	}
	
	/**
	 * Returns the if statement's line number.
	 * 
	 * @return	The line number in which an if statement
	 * 			was written.
	 */
	public int getLineNumber()
	{
		return lineNumber;
	}
	
	/**
	 * Sets the line number in which an if statement was written.
	 * 
	 * @param _lineNumber	The line number in which an if statement
	 * 						was written.
	 */
	public void setLineNumber(int _lineNumber)
	{
		lineNumber = _lineNumber;
	}
}
