package edu.frostburg.cosc470.cornucopia.parsetree;

/**
 * A parse tree node that represents the Access production.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Access extends Node
{
	/**
	 * True if this program is public.
	 */
	private boolean isPublic;
	
	/**
	 * Creates a new node that represents the Access production.
	 * 
	 * @param _ruleNum	The rule number for this production.
	 */
	public Access(int _ruleNum)
	{
		super(_ruleNum);
		
		if(_ruleNum == 2)
		{
			isPublic = true;
		}
		else
		{
			isPublic = false;
		}
	}
	
	/**
	 * Returns true if this program is public. 
	 * 
	 * @return	<code>true</code> of this program is public.
	 */
	public boolean isPublic()
	{
		return isPublic;
	}
}
