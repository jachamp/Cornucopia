package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents an expression production.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Expression extends ExpressionNode
{	
	/**
	 * This node's relational operator.
	 */
	private int relop;
	
	/**
	 * Creates a new expression node.
	 * 
	 * @param _ruleNum	This node's rule number.
	 */
	public Expression(int _ruleNum)
	{
		super(_ruleNum);
	}

	/**
	 * Returns this node's relational operator.
	 * 
	 * @return	This node's relop.
	 */
	public int getRelop()
	{
		return relop;
	}
	
	/**
	 * Sets this node's relational operator.
	 * 
	 * @param _relop	This node's relop.
	 */
	public void setRelop(int _relop)
	{
		relop = _relop;
	}
}
