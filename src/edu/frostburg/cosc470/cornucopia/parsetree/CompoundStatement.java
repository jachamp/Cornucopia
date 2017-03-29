package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents a compound statement production.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class CompoundStatement extends Node
{
	/**
	 * Creates a new compound statement production.
	 * 
	 * @param _ruleNum	This node's rule number.
	 */
	public CompoundStatement(int _ruleNum)
	{
		super(_ruleNum);
	}
}
