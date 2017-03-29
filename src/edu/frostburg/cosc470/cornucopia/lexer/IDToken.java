package edu.frostburg.cosc470.cornucopia.lexer;

/**
 * Represents a source file token for an identifier. This token stores the
 * name of the identifier, as well as its type.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class IDToken extends Token
{
	/**
	 * This token's id.
	 */
	private String id;
	
	/**
	 * Creates a new token object with the given parameters.
	 * 
	 * @param _type	This token's type.
	 * @param _id	This token's id.
	 */
	public IDToken(int _type, int _line, int _col, String _id)
	{
		super(_type, _line, _col);
		
		id = _id;
	}
	
	/**
	 * Returns this token's id.
	 * 
	 * @return	This token's id.
	 */
	public String getID()
	{
		return id;
	}
	
	/* (non-Javadoc)
	 * @see edu.frostburg.cosc470.cornucopia.lexer.Token#toString()
	 */
	public String toString()
	{
		return "Type: " + getType() + "\tID: " + id;
	}
}
