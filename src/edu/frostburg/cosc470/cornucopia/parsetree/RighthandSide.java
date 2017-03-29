package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents a right-hand side production.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class RighthandSide extends Node
{
	/**
	 * This node's operand.
	 */
	private String op;
	/**
	 * This node's data type.
	 */
	private int type;
	
	/**
	 * Creates a new right-hand side node.
	 * 
	 * @param _ruleNum	This node's rule number.
	 */
	public RighthandSide(int _ruleNum)
	{
		super(_ruleNum);
	}
	
	/**
	 * Returns this node's operand.
	 * 
	 * @return This node's operand.
	 */
	public String getOp()
	{
		return op;
	}
	
	/**
	 * Sets this node's operand.
	 * 
	 * @param _op	This node's operand.
	 */
	public void setOp(String _op)
	{
		op = _op;
	}
	
	/**
	 * Returns this node's type.
	 * 
	 * @return	This node's type.
	 */
	public int getType()
	{
		return type;
	}
	
	/**
	 * Sets this node's type.
	 * 
	 * @param _type	This node's type.
	 */
	public void setType(int _type)
	{
		type = _type;
	}
}
