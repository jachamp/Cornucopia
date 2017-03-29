package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents a Term production.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Term extends ExpressionNode
{
	/**
	 * This node's multiplication operation.
	 */
	private int mulop;
	
	/**
	 * True if this node contains an identifier.
	 */
	private boolean isId;
	
	/**
	 * Creates a new node that represents a Term production.
	 * 
	 * @param _ruleNum	This term's rule number.
	 */
	public Term(int _ruleNum)
	{
		super(_ruleNum);
		isId = false;
	}

	/**
	 * Returns this term's multiplication operation.
	 * 
	 * @return	This term's mulop value.
	 */
	public int getMulop()
	{
		return mulop;
	}
	
	/**
	 * Sets this term's multiplication operation.
	 * 
	 * @param _mulop	This term's mulop value.
	 */
	public void setMulop(int _mulop)
	{
		mulop = _mulop;
	}
	
	/**
	 * Returns true if this term is an identifier.
	 * 
	 * @return	<code>true</code> if this term is an identifier.
	 */
	public boolean isId()
	{
		return isId;
	}
	
	/**
	 * Sets Term#isId to <code>true</code>.
	 */
	public void setId()
	{
		isId = true;
	}
}
