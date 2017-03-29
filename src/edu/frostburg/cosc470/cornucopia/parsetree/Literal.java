package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * Creates a parse tree node that represents a literal value.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Literal extends Node
{
	private final static int RULE_NUM = 43;
	
	/**
	 * This node's value.
	 */
	private int value;
	
	/**
	 * Creates a new literal node.
	 * 
	 * @param _value The value of this literal.
	 */
	public Literal(int _value)
	{
		super(RULE_NUM);
		
		value = _value;
	}
	
	/**
	 * Returns this literal's value.
	 * 
	 * @return	This literal's value.
	 */
	public int getValue()
	{
		return value;
	}
}
