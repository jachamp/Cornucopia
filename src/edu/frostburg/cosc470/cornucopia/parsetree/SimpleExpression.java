package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents a simple_expression production.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class SimpleExpression extends ExpressionNode
{
	/**
	 * This node's addition operation.
	 */
	private int addop;
	
	/**
	 * Creates a new simple_expression node.
	 * 
	 * @param _ruleNum	This node's rule number.
	 */
	public SimpleExpression(int _ruleNum)
	{
		super(_ruleNum);
	}
	
	/**
	 * Returns this node's addition operation.
	 * 
	 * @return	This node's addop value.
	 */
	public int getAddop()
	{
		return addop;
	}
	
	/**
	 * Sets this node's addition operation.
	 * 
	 * @param _addop	This node's addop value.
	 */
	public void setAddop(int _addop)
	{
		addop = _addop;
	}
}
