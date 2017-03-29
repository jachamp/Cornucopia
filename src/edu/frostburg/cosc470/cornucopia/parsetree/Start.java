package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents the Start production.
 * This node is the root of the parse tree.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Start extends Node
{
	private final static int RULE_NUM = 1;
	
	/**
	 * Creates a new Start node.
	 */
	public Start()
	{
		super(RULE_NUM);
	}
}
