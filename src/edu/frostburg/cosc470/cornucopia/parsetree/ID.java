package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents an id.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class ID extends Node 
{
	private final static int RULE_NUM = 44;
	
	/**
	 * The name of this node's id.
	 */
	private String id;
	
	/**
	 * Creates a new id node.
	 * 
	 * @param _id	The name of this node's id.
	 */
	public ID(String _id)
	{
		super(RULE_NUM);
		
		id = _id;
	}
	
	/**
	 * Returns this node's identifier.
	 * 
	 * @return	This node's id.
	 */
	public String getId()
	{
		return id;
	}
}
