package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * Abstract class that represents expressions, simple expressions,
 * and terms. Holds up to three integer values and three Strings that
 * represent operands.
 * <br>
 * This node also stores the type of either the first operand or the
 * result of an operation on operands, depending on the node's context.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 * @see edu.frostburg.cosc470.cornucopia.generation.CodeGenerator
 */
public abstract class ExpressionNode extends Node
{
	/**
	 * The value of operand 1.
	 */
	private int val1;
	/**
	 * The value of operand 2.
	 */
	private int val2;
	/**
	 * The value of the result of an operation on the
	 * first two operands.
	 */
	private int resultVal;
	
	/**
	 * The name of the first operand.
	 */
	private String op1;
	/**
	 * The name of the second operand.
	 */
	private String op2;
	/**
	 * The name of the third operand.
	 */
	private String resultOp;
	
	/**
	 * The type of either the first or third
	 * operand (context-specific).
	 */
	private int type;
	
	/**
	 * Used to create a new expression node.
	 * 
	 * @param _ruleNum	The rule number of the production that this
	 * 					node represents.
	 */
	public ExpressionNode(int _ruleNum) 
	{
		super(_ruleNum);
	}

	/**
	 * Returns the value of the first operand.
	 * 
	 * @return	The value of the first operand.
	 */
	public int getVal1()
	{
		return val1;
	}
	
	/**
	 * Sets the value of the first operand.
	 * 
	 * @param _value The new value of the first operand.
	 */
	public void setVal1(int _value)
	{
		val1 = _value;
	}
	
	/**
	 * Returns the value of the second operand.
	 * 
	 * @return	The value of the second operand.
	 */
	public int getVal2()
	{
		return val2;
	}
	
	/**
	 * Sets the value of the second operand.
	 * 
	 * @param _value The new value of the second operand.
	 */
	public void setVal2(int _value)
	{
		val2 = _value;
	}
	
	/**
	 * Returns the value of the third operand.
	 * 
	 * @return	The value of the third operand.
	 */
	public int getResultVal()
	{
		return resultVal;
	}
	
	/**
	 * Sets the value of the third operand.
	 * 
	 * @param _value  The value of the third operand.
	 */
	public void setResultVal(int _value)
	{
		resultVal = _value;
	}
	
	/**
	 * Returns the name of the first operand.
	 * 
	 * @return The name of the first operand.
	 */
	public String getOp1()
	{
		return op1;
	}
	
	/**
	 * Sets the name of the first operand.
	 * 
	 * @param _op	The first operand's name.
	 */
	public void setOp1(String _op)
	{
		op1 = _op;
	}
	
	/**
	 * Returns the name of the second operand.
	 * 
	 * @return The name of the second operand.
	 */
	public String getOp2()
	{
		return op2;
	}
	
	/**
	 * Sets the name of the second operand.
	 * 
	 * @param _op	The second operand's name.
	 */
	public void setOp2(String _op)
	{
		op2 = _op;
	}
	
	/**
	 * Returns the name of the third operand.
	 * 
	 * @return The name of the third operand.
	 */
	public String getResultOp()
	{
		return resultOp;
	}
	
	/**
	 * Sets the name of the third operand.
	 * 
	 * @param _op	The third operand's name.
	 */
	public void setResultOp(String _op)
	{
		resultOp = _op;
	}
	
	/**
	 * Returns of type of this node.
	 * 
	 * @return	The type of this node.
	 */
	public int getType()
	{
		return type;
	}
	
	/**
	 * Sets the type of this node.
	 * 
	 * @param _type	This node's type.
	 */
	public void setType(int _type)
	{
		type = _type;
	}
}
