package edu.frostburg.cosc470.cornucopia.parsetree;

import edu.frostburg.cosc470.cornucopia.symboltable.TableEntry;

/**
 * A parse tree node that represents a Type production.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Type extends Node
{
	/** 
	 * This node's type.
	 */
	private int type;
	
	/**
	 * Creates a new parse tree node that represents a
	 * Type production. 
	 * 
	 * @param _ruleNum	The rule number of this production.
	 */
	public Type(int _ruleNum)
	{
		super(_ruleNum);
		
		if(_ruleNum == 9)
		{
			type = TableEntry.CHAR;
		}
		else
		{
			type = TableEntry.INT;
		}
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
}
