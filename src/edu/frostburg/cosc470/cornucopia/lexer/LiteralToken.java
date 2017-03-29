package edu.frostburg.cosc470.cornucopia.lexer;

/**
 * Represents a <code>Token</code> object that contains a literal value.
 * The literal value can either be an integer or a character.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class LiteralToken extends Token
{
	/**
	 * The value of this token.
	 */
	private int value;
	
	/**
	 * Creates a new token with the given values.
	 * 
	 * @param _type		This token's type
	 * @param _value	An integer representation of this token's
	 * 					character or integer value.
	 */
	public LiteralToken(int _type, int _line, int _col, int _value)
	{
		super(_type, _line, _col);
		
		value = _value;
	}
	
	/**
	 * Returns this token's value.
	 * 
	 * @return An integer representation of this token's value.
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * Returns a <code>String</code> representation of this token. Used for
	 * troubleshooting purposes.
	 * 
	 * @return	A <code>String</code> representation of this token.
	 */
	public String toString()
	{
		return "Type: " + getType() + "\tValue: " + value;
	}
}
