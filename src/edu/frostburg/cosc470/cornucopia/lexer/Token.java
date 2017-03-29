package edu.frostburg.cosc470.cornucopia.lexer;

/**
 * Represents a token from the source program file. Created by
 * the <code>Lexer</code> as it scans the file. Used by the
 * <code>Parser</code> to determine the validity of the program.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Token 
{
	/**
	 * Represents this token's type.
	 */
	private int type;
	/**
	 * The line number where this token was located.
	 */
	private int lineNum;
	/**
	 * The column number where this token was located.
	 */
	private int colNum;
	
	public Token(int _type, int _line, int _col)
	{
		type = _type;
		lineNum = _line;
		colNum = _col;
	}
	
	/**
	 * Returns this token's type. All types are listed in the
	 * <code>Grammar</code> class.
	 * 
	 * @return	An integer representing this token's type.
	 * 
	 * @see	edu.frostburg.cosc470.cornucopia.grammar.Grammar
	 */
	public int getType()
	{
		return type;
	}
	
	/**
	 * Returns the line number of this token.
	 * 
	 * @return	The line number of this token.
	 */
	public int getLineNum()
	{
		return lineNum;
	}
	
	/**
	 * Returns the column number of this token.
	 * 
	 * @return	The column number of this token.
	 */
	public int getColNum()
	{
		return colNum;
	}
	
	/**
	 *  Returns a description of this <code>Token</code>. Used for
	 *  troubleshooting purposes.
	 * 
	 * @return	A String representation of this token.
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return "Type: " + type;
	}
}
