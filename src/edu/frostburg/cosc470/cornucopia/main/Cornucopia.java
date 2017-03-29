package edu.frostburg.cosc470.cornucopia.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import edu.frostburg.cosc470.cornucopia.errors.ErrorHandler;
import edu.frostburg.cosc470.cornucopia.generation.CodeGenerator;
import edu.frostburg.cosc470.cornucopia.parser.Parser;
import edu.frostburg.cosc470.cornucopia.parsetree.Node;
import edu.frostburg.cosc470.cornucopia.symboltable.SymbolTable;

/**
 * Represents a compiler for the Cornucopia language.
 * 
 * @author James Champ
 */
public class Cornucopia 
{
	/**
	 * This compiler's symbol table.
	 */
	private static SymbolTable symbolTable;
	
	/**
	 * This compiler's error handler.
	 */
	private static ErrorHandler errorHandler;
	
	/**
	 * Main entry method for this compiler. Reads file path from
	 * command line and attempts to compile that file. Writes 
	 * compiled output to the same directory that contains the 
	 * input file.
	 * 
	 * @param args	Command line arguments for the compiler. The
	 * 				first argument is the input file path.
	 */
	public static void main(String[] args)
	{	
		errorHandler = new ErrorHandler();
		
		if(args.length > 0)
		{
			try 
			{
				File inFile = new File(args[0]);
				
				BufferedReader br = new BufferedReader(new FileReader(inFile));
				Parser parser = new Parser(br);
				parser.parse();
				
				symbolTable = new SymbolTable();
					
				Node parseTree = parser.getParseTree();
				CodeGenerator generator = new CodeGenerator(parseTree);
				generator.generateCode();
					
				String outFile = inFile.getParent();
				outFile += "\\" + generator.getFunctionName().toLowerCase() + ".corn";
				writeToFile(outFile, generator.getCode());
			
				System.out.println("Compilation successful");

			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			errorHandler.missingFileError();
		}
	}
	
	/**
	 * Returns a reference to this compiler's symbol table.
	 * 
	 * @return	This compiler's <code>SymbolTable</code>.
	 */
	public static SymbolTable getSymbolTable()
	{
		return symbolTable;
	}
	
	/**
	 * Returns a reference to this compiler's error handler.
	 * 
	 * @return	This compiler's <code>ErrorHandler</code>.
	 */
	public static ErrorHandler getErrorHandler()
	{
		return errorHandler;
	}
	
	/**
	 * Writes the given code to the given output file location.
	 * 
	 * @param _file		Location of the output file.
	 * @param _code		Target code that will be written to file.	
	 * @throws IOException
	 */
	private static void writeToFile(String _file, String _code) throws IOException
	{
		File file = new File(_file);
		
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(_code);
		bw.close();
	}
}
