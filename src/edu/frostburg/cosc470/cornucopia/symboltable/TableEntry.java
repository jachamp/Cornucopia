package edu.frostburg.cosc470.cornucopia.symboltable;

/**
 * Represents a symbol table entry.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class TableEntry 
{
	/**
	 * Represents a null value.
	 */
	protected final static int NULL = -1;
	
	// Data types
	/**
	 * Represents an integer
	 */
	public final static int INT = 0;
	/**
	 * Represents a character.
	 */
	public final static int CHAR = 1;
	
	/**
	 * This variables identifier.
	 */
	private String id;
	/**
	 * This variable's data type.
	 */
	private int dataType;
	
	/**
	 * Tracks whether or not this variable was initialized.
	 */
	private boolean valueInitialized;
	
	/**
	 * Creates a new table entry object with the given id.
	 * @param _id	This variable's name.
	 */
	public TableEntry(String _id)
	{
		id = _id;
		dataType = NULL;
		
		valueInitialized = false;
	}
	
	/**
	 * Creates a new table entry with the given id
	 * and data type.
	 * 
	 * @param _id		This variable's id.
	 * @param _dataType	This variable's data type.
	 */
	public TableEntry(String _id, int _dataType)
	{
		id = _id;
		dataType = _dataType;
		
		valueInitialized = false;
	}
	
	/**
	 * Returns this variable's identifier.
	 * 
	 * @return A String identifier name.
	 */
	public String getId()
	{
		return id;
	}
	
	
	/**
	 * Returns the data type of this variable.
	 * 
	 * @return An integer that represents this variable's data type.
	 */
	public int getDataType()
	{
		return dataType;
	}
	
	/**
	 * Sets this variable's data type.
	 * 
	 * @param _dataType An integer that represents this variable's data type.
	 */
	public void setDataType(int _dataType)
	{
		dataType = _dataType;
	}
	
	/**
	 * Sets whether or not the value was initialized.
	 * 
	 * @param _isInitialized  Boolean initialization status.
	 */
	public void setInitialized(boolean _isInitialized)
	{
		valueInitialized = _isInitialized;
	}
	
	/**
	 * Returns true if this variable was initialized.
	 * 
	 * @return Returns <code>true</code> if this variable was
	 * 		   initialized, and <code>false</code> otherwise.
	 */
	public boolean isInitialized()
	{
		return valueInitialized;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return id.hashCode();
	}
	
	/**
	 * Prints information about this symbol to the console.
	 */
	public void printSymbol()
	{		
		String type;
		String val;
		
		System.out.printf("%10s ", id);
		
		switch(dataType)
		{
			case NULL:
				type = "NULL";
				break;
			case INT:
				type = "INT";
				break;
			case CHAR:
				type = "CHAR";
				break;

			default:
				type = "ERR!";
				break;
		}
		
		System.out.printf("%6s ", type);
		
		if(!valueInitialized)
		{
			val = "NULL";
		}
		else 
		{
			val = "INIT";
		}
		
		System.out.printf("%10s\n", val);
	}
}
