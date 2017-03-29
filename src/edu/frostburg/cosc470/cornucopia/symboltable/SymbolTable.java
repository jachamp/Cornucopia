package edu.frostburg.cosc470.cornucopia.symboltable;

import java.util.HashMap;

/**
 * A symbol table for the Cornucopia compiler. All symbols are stored in a
 * a TableEntry object, which is in turn stored in a HashMap. The symbol table 
 * is accessed by the parse tree every time an ID is encountered.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 * @see HashMap
 * @see TableEntry
 */
public class SymbolTable 
{
	/**
	 * A <code>HashMap</code> that stores all of the symbols 
	 * that are encountered in a Cornucopia program.
	 */
	private HashMap<String, TableEntry> symbolTable;
	
	/**
	 * Creates a new symbol table for a Cornucopia program.
	 */
	public SymbolTable()
	{
		symbolTable = new HashMap<String, TableEntry>();
	}
	
	/**
	 * Inserts a new symbol into the symbol table. If the symbol's
	 * identifier is more than 8 characters long, the identifier is
	 * shortened to 8 characters.
	 * 
	 * @param _id	The symbol's identifier.
	 */
	public void insert(String _id)
	{
		if(_id.length() > 8)
		{
			_id = shorten(_id);
		}
		
		if(!lookUp(_id))
		{
			TableEntry entry = new TableEntry(_id);
			
			symbolTable.put(_id, entry);			
		}
	}
	
	/**
	 * Inserts a new symbol and its data type into the symbol table. 
	 * If the symbol's identifier is more than 8 characters long, 
	 * the identifier is shortened to 8 characters.
	 * 
	 * @param _id		The symbol's identifier.
	 * @param _dataType The symbol's data type.
	 */
	public void insert(String _id, int _dataType)
	{
		if(_id.length() > 8)
		{
			_id = shorten(_id);
		}
		
		if(!lookUp(_id))
		{
			TableEntry entry = new TableEntry(_id, _dataType);
			
			symbolTable.put(_id, entry);
		}
	}
		
	/**
	 * Sets the data type of the given symbol.
	 *
	 * @param _id	The symbol's identifier.
	 * @param _dataType	The data type of the symbol.
	 */
	public void setDataType(String _id, int _dataType)
	{
		if(_id.length() > 8)
		{
			_id = shorten(_id);
		}
		
		if(lookUp(_id))
		{
			if(symbolTable.get(_id).getDataType() == TableEntry.NULL)
			{
				symbolTable.get(_id).setDataType(_dataType);
			}
			// else data type already set
		}
		// else symbol doesn't exist
	}
	
	// Precondition: Symbol exists in table
	/**
	 * Returns an existing symbol's data type. The symbol must already
	 * be stored in the symbol table before this method is called.
	 * 
	 * @param _id	The symbol's identifier.
	 * @return		The data type of the given symbol.
	 */
	public int getDataType(String _id)
	{
		if(_id.length() > 8)
		{
			_id = shorten(_id);
		}
		
		int dataType = symbolTable.get(_id).getDataType();

		return dataType;
	}
	
	/**
	 * Signifies that the given ID was initialized.
	 * 
	 * @param _id	The symbol's identifier.
	 */
	public void setInitialized(String _id)
	{
		if(_id.length() > 8)
		{
			_id = shorten(_id);
		}
		
		symbolTable.get(_id).setInitialized(true);
	}
	
	/**
	 * Checks whether or not a given symbol has been initialized.
	 * 
	 * @param _id	The symbol's identifier.
	 * @return		Returns <code>true</code> if the symbol has been initialized,
	 * 				or <code>false</code> otherwise.
	 */
	public boolean isInitialized(String _id)
	{
		if(_id.length() > 8)
		{
			_id = shorten(_id);
		}
		
		return symbolTable.get(_id).isInitialized();
	}
	
	/**
	 * Checks to see if the given ID is contained within
	 * the symbol table.
	 * 
	 * @param _id	The ID being looked for.
	 * @return		<code>true</code> if the ID is in the table.
	 */
	public boolean lookUp(String _id)
	{
		if(_id.length() > 8)
		{
			_id = shorten(_id);
		}
		
		return symbolTable.containsKey(_id);
	}

	/**
	 * Shortens an ID to eight characters.
	 * 
	 * @param _id	The given ID.
	 * @return		A shortened form of the ID.
	 */
	private String shorten(String _id)
	{
		return _id.substring(0, 8);
	}
	
	/**
	 * Prints the contents of the symbol table. Used for
	 * diagnostic purposes.
	 */
	public void printSymbolTable()
	{		
		System.out.printf("%10s %6s %10s\n", "Id", "Type", "Value");
		System.out.println("  --------  -----   --------");
		
		for(TableEntry e : symbolTable.values())
		{
			e.printSymbol();
		}
		
		System.out.println();
	}
}
