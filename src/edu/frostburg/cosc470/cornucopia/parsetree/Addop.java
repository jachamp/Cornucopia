package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents an Addop production. This node's
 * rule number determines which addition operation is performed.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Addop extends Node
{
	/**
	 * Create a new Addop node.
	 * 
	 * @param _ruleNum	This Addop node's rule number.
	 */
	public Addop(int _ruleNum)
	{
		super(_ruleNum);
	}
}
