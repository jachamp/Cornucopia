package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents a statement list production.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class StatementList extends Node
{
	/**
	 * Creates a new node that represents a statement list.
	 * 
	 * @param _ruleNum	This node's rule number.
	 */
	public StatementList(int _ruleNum)
	{
		super(_ruleNum);
	}
}
