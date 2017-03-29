package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents a factor.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Factor extends Node
{	
	/**
	 * The value of this factor.
	 */
	private int value;
	/**
	 * This factor's type.
	 */
	private int type;
	/**
	 * This factor's id.
	 */
	private String id;
	
	/**
	 * Creates a new factor node.
	 * 
	 * @param _ruleNum	The rule number of this factor.
	 */
	public Factor(int _ruleNum)
	{
		super(_ruleNum);
	}
	
	/**
	 * Returns this factor's value.
	 * 
	 * @return	This factor's value.
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * Sets this factor's value.
	 * 
	 * @param _value	This factor's value.
	 */
	public void setValue(int _value)
	{
		value = _value;
	}
	
	/**
	 * Returns this factor's data type.
	 * 
	 * @return	This factor's type.
	 */
	public int getType()
	{
		return type;
	}
	
	/**
	 * Sets this factor's data type.
	 * 
	 * @param _type	This factor's data type.
	 */
	public void setType(int _type)
	{
		type = _type;
	}
	
	/**
	 * Returns this factor's identifier.
	 * 
	 * @return This factor's id.
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * Sets this factor's identifier.
	 * 
	 * @param _id	This factor's id.
	 */
	public void setId(String _id)
	{
		id = _id;
	}
}
