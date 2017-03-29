package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents the left-hand side production.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class LefthandSide extends Node
{
	/**
	 * Creates a new left-hand side node.
	 * 
	 * @param _ruleNum	This node's rule number.
	 */
	public LefthandSide(int _ruleNum)
	{
		super(_ruleNum);
	}
}
