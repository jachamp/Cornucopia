package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents a relational operation.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Relop extends Node
{
	/**
	 * Creates a new relop node.
	 * 
	 * @param _ruleNum	This node's rule number.
	 */
	public Relop(int _ruleNum)
	{
		super(_ruleNum);
	}
}
