package edu.frostburg.cosc470.cornucopia.generation;

import java.util.LinkedList;

import edu.frostburg.cosc470.cornucopia.collections.LinkedListStack;
import edu.frostburg.cosc470.cornucopia.main.Cornucopia;
import edu.frostburg.cosc470.cornucopia.parsetree.*;
import edu.frostburg.cosc470.cornucopia.symboltable.TableEntry;

/**
 * Given a parse tree representation of the source code, this class
 * produces target code. 
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class CodeGenerator 
{
	// Relops:
	private final static int GREATER = 0;
	private final static int GREATER_EQUAL = 1;
	private final static int EQUALS = 2;
	private final static int LESSER_EQUAL = 3;
	private final static int LESSER = 4;
	private final static int NOT_EQUAL = 5;
	
	// Addops:
	private final static int ADD = 0;
	private final static int SUBTRACT = 1;
	
	// Mulops:
	private final static int MULTIPLY = 0;
	private final static int DIVIDE = 1;
	private final static int MODULO = 2;
	
	// Booleans
	private final static int TRUE = 1;
	private final static int FALSE = 0;
	
	// Data types
	public final static int INT = 0;
	public final static int CHAR = 1;
	
	private StringBuilder sb;
	private int lineNum;
	
	private Node root;
	private Node current;
	private Node marker;
	
	private boolean isPublic;
	private String functionName;
		
	private LinkedList<String> codeList;
	private LinkedListStack<Integer> ifStack;
	
	private int idType;

	private LinkedList<String> tempIdList;
	private int tempCount;
	
	/**
	 * Creates a new code generator with the given
	 * parse tree.
	 * 
	 * @param _parseTree	A representation of the
	 * 						source code.
	 */
	public CodeGenerator(Node _parseTree)
	{
		root = _parseTree;
		current = root;
		sb = new StringBuilder();
		lineNum = 0;
	}
	
	/**
	 * Generates target code by traversing the parse tree that
	 * was passed to the constructor. Prunes tree down to the root
	 * as the program runs. Once only the root remains, the method
	 * is complete and the target code is ready to be written to file.
	 */
	public void generateCode()
	{		
		// handle access modifier:
		setAccess();
		
		// handle function identifier:
		setFunctionName();
		
		// handle function parameters:	
		setParameters();
		
		// handle declarations:
		setDeclarations();
		
		// generate code:
		codeList = new LinkedList<String>();
		tempIdList = new LinkedList<String>();
		ifStack = new LinkedListStack<Integer>();
		
		tempCount = 0;
		
		current = root.getLeftChild();		// at compound statement
		handleCompoundStatement();
		
		writeCode();
	}
	
	/**
	 * Sets current to left-most child, which is a statement_list
	 * node, and handles that node. Deletes self once finished.
	 */
	private void handleCompoundStatement()
	{
		current = current.getLeftChild();
		handleStatementList();
		
		prune();
	}
	
	/**
	 * 
	 */
	private void handleStatementList()
	{	
		if(current.getRuleNum() == 12)			// statement case
		{
			current = current.getLeftChild();
			handleStatement();
		}
		else if(current.getRuleNum() == 13)		// statement_list ; statement case
		{
			current = current.getLeftChild();
			handleStatementList();
			
			current.deleteLeftChild();
			current = current.getLeftChild();
			handleStatement();
		}
		
		prune();
	}
	
	/**
	 * Handles statement node in accordance to it's rule number. Generates
	 * code for put, get, and if statement cases. For the if statement case,
	 * the line number of the generated if statement is stored. Once the statement
	 * node child of the if statement is handled, the current line number is concatenated
	 * onto the code for the if statement.
	 */
	private void handleStatement()
	{
		String id;
		
		switch(current.getRuleNum())
		{
			case 14:	// lefthandside statement
				current = current.getLeftChild();
				handleLefthandSide();
				break;
				
			case 15:	// compound statement
				current = current.getLeftChild();
				handleCompoundStatement();
				break;
				
			case 16:	// get statement
				id = ((ID) current.getLeftChild()).getId();
				
				if(Cornucopia.getSymbolTable().lookUp(id))
				{
					//id exists
					int type = Cornucopia.getSymbolTable().getDataType(id);
					
					if(type == TableEntry.CHAR)
					{
						codeList.add("" + lineNum + " SYS #2,," + id);
						lineNum++;
						Cornucopia.getSymbolTable().setInitialized(id);
					}
					else if(type == TableEntry.INT)
					{
						codeList.add("" + lineNum + " SYS #1,," + id);
						lineNum++;
						Cornucopia.getSymbolTable().setInitialized(id);
					}
					else
					{
						Cornucopia.getErrorHandler().idWithNoTypeError(id);
					}
				}
				else
				{
					Cornucopia.getErrorHandler().undeclaredIdError(id);
				}
				break;
				
			case 17:	// put statement
				id = ((ID) current.getLeftChild()).getId();
				
				if(Cornucopia.getSymbolTable().lookUp(id))
				{
					if(Cornucopia.getSymbolTable().isInitialized(id))
					{
						int type = Cornucopia.getSymbolTable().getDataType(id);
						
						if(type == CHAR)
						{
							// write value
							codeList.add("" + lineNum + " SYS #-2," + id + ",");
							lineNum++;
							
							// write new line
							codeList.add("" + lineNum + " SYS #0,,");
							lineNum++;
						}
						else if(type == INT)
						{
							// write int
							codeList.add("" + lineNum + " SYS #-1," + id +",");
							lineNum++;
							
							// write new line
							codeList.add("" + lineNum + " SYS #0,,");
							lineNum++;
						}
						else
						{
							Cornucopia.getErrorHandler().idWithNoTypeError(id);
						}
					}
					else
					{
						Cornucopia.getErrorHandler().uninitializedIdError(id);
					}
				}
				else
				{
					Cornucopia.getErrorHandler().undeclaredIdError(id);
				}
				break;
				
			case 18:	// if case
				current = current.getLeftChild();
				handleExpression();
				
				if(current.getLeftChild().getRuleNum() == 21)  // no relop
				{
					if(((Expression) current.getLeftChild()).getType() != CHAR)
					{
						// expression true iff equal to one
						codeList.add("" + lineNum + " JNE #1," + ((Expression) current.getLeftChild()).getResultOp() +
								 ",#");
						
						tempIdList.add(((Expression) current.getLeftChild()).getResultOp());
					}
					else
					{
						Cornucopia.getErrorHandler().illegalIfExpressionError();
					}
				}
				else	// relop
				{
					switch(((Expression) current.getLeftChild()).getRelop())
					{
						case GREATER:
							codeList.add("" + lineNum + " JLE " + ((Expression) current.getLeftChild()).getOp1() +
									 "," + ((Expression) current.getLeftChild()).getOp2() + ",#");
							break;
						case GREATER_EQUAL:
							codeList.add("" + lineNum + " JLT " + ((Expression) current.getLeftChild()).getOp1() +
									 "," + ((Expression) current.getLeftChild()).getOp2() + ",#");
							break;
						case EQUALS:
							codeList.add("" + lineNum + " JNE " + ((Expression) current.getLeftChild()).getOp1() +
									 "," + ((Expression) current.getLeftChild()).getOp2() + ",#");
							break;
						case LESSER_EQUAL:
							codeList.add("" + lineNum + " JGT " + ((Expression) current.getLeftChild()).getOp1() +
									 "," + ((Expression) current.getLeftChild()).getOp2() + ",#");
							break;
						case LESSER:
							codeList.add("" + lineNum + " JGE " + ((Expression) current.getLeftChild()).getOp1() +
									 "," + ((Expression) current.getLeftChild()).getOp2() + ",#");
							break;
						case NOT_EQUAL:
							codeList.add("" + lineNum + " JEQ " + ((Expression) current.getLeftChild()).getOp1() +
									 "," + ((Expression) current.getLeftChild()).getOp2() + ",#");
							break;
						default:
							System.out.println("Unusual relop at CodeGenerator.handleStatement()");
					}
					
					tempIdList.add(((Expression) current.getLeftChild()).getOp1());
					tempIdList.add(((Expression) current.getLeftChild()).getOp2());
				}
				
				// cleanup
				ifStack.push(lineNum);
				lineNum++;
				
				current.deleteLeftChild();			//delete expression
				current = current.getLeftChild();
				handleStatement();
				
				// cleanup
				int ifLine = ifStack.pop();
				codeList.set(ifLine, codeList.get(ifLine) + lineNum);
				break;
				
			default:
				System.out.println("Error at CodeGenerator.handleStatement");
				System.out.println(current.getRuleNum());
		}
		
		prune();
	}
	
	/**
	 * Writes target code that sets the value of an id to some value provided
	 * by the right-hand side. Deletes the left-hand side node afterwards.
	 */
	private void handleLefthandSide()
	{
		String id = ((ID) current.getLeftChild()).getId();
			
		if(Cornucopia.getSymbolTable().lookUp(id))	// ID has been declared; get righthandside
		{
			current.deleteLeftChild();	// delete id
			current = current.getLeftChild();
			handleRighthandSide();
			
			// check type
			if(Cornucopia.getSymbolTable().getDataType(id) == ((RighthandSide) current.getLeftChild()).getType())
			{
				// generate code
				codeList.add("" + lineNum + " STO " + ((RighthandSide) current.getLeftChild()).getOp() +
						 ",," + id);
				lineNum++;	
				
				// cleanup
				Cornucopia.getSymbolTable().setInitialized(id);
				tempIdList.add(((RighthandSide) current.getLeftChild()).getOp());
				
				prune();
			}
			else
			{
				Cornucopia.getErrorHandler().typeMismatchError();
			}
		}
		else
		{
			Cornucopia.getErrorHandler().undeclaredIdError(id);
		}
	}
	
	/**
	 * Handles righthandside node. Right-hand side cannot be a relational operator.
	 * Sets operand and operand type, and then deletes the node.
	 */
	private void handleRighthandSide()
	{
		if(current.getLeftChild().getRuleNum() == 21)	// valid
		{
			current = current.getLeftChild();
			handleExpression();
			
			((RighthandSide) current).setOp(((Expression) current.getLeftChild()).getResultOp());
			((RighthandSide) current).setType(((Expression) current.getLeftChild()).getType());
			
			tempIdList.add(((Expression) current.getLeftChild()).getResultOp());
			
			prune();
		}
		else
		{
			Cornucopia.getErrorHandler().relopError();
		}
	}
	
	/**
	 * Handles an expression node, setting result operand if node represents a
	 * simple_expression. If the expression contains a relational operator, 
	 * Code is generated. Node is deleted upon completion.
	 */
	private void handleExpression()
	{
		if(current.getRuleNum() == 21)	// simple expression case
		{
			current = current.getLeftChild();
			handleSimpleExpression();
			
			((Expression) current).setResultOp(((SimpleExpression) current.getLeftChild()).getResultOp());
			((Expression) current).setType(((SimpleExpression) current.getLeftChild()).getType());
		}
		else							//simple_expression relop simple_expression case
		{
			// handle first simple_expression
			current = current.getLeftChild();
			handleSimpleExpression();
			
			((Expression) current).setOp1(((SimpleExpression) current.getLeftChild()).getResultOp());
			((Expression) current).setType(((SimpleExpression) current.getLeftChild()).getType());

			current.deleteLeftChild();
			
			// get relop
			switch(current.getLeftChild().getRuleNum())
			{
				case 32:	// greater than
					((Expression) current).setRelop(GREATER);
					break;
				case 33:	// greater than or equal
					((Expression) current).setRelop(GREATER_EQUAL);
					break;
				case 34:	// equal
					((Expression) current).setRelop(EQUALS);
					break;
				case 35:	// less than or equal
					((Expression) current).setRelop(LESSER_EQUAL);
					break;
				case 36:	// less than
					((Expression) current).setRelop(LESSER);
					break;
				case 37:	// not equal
					((Expression) current).setRelop(NOT_EQUAL);
					break;
				default:
					System.out.println("Invalid relop at CodeGenerator.handleExpression()");
			}
			
			current.deleteLeftChild();
			
			// handle second simple_expression
			current = current.getLeftChild();
			handleSimpleExpression();
			
			((Expression) current).setOp2(((SimpleExpression) current.getLeftChild()).getResultOp());
			int type2 = ((SimpleExpression) current.getLeftChild()).getType();
			
			// check type mismatch
			if(((Expression) current).getType() != type2)
			{
				Cornucopia.getErrorHandler().typeMismatchError();
			}
		}
		
		prune();
	}
	
	/**
	 * Handles a simple_expression node, generating code if it contains a relational
	 * operator. Deletes node once complete.
	 */
	private void handleSimpleExpression()
	{
		if(current.getRuleNum() == 23) // term case
		{
			current = current.getLeftChild();
			handleTerm();
			
			((SimpleExpression) current).setResultOp(((Term) current.getLeftChild()).getResultOp());
			((SimpleExpression) current).setType(((Term) current.getLeftChild()).getType());
		}
		else							// simple_expression relop simple term case
		{
			// handle simple expression
			current = current.getLeftChild();
			handleSimpleExpression();
			
			((SimpleExpression) current).setOp1(((SimpleExpression) current.getLeftChild()).getResultOp());
			((SimpleExpression) current).setType(((SimpleExpression) current.getLeftChild()).getType());

			current.deleteLeftChild();
			
			// get relop
			switch(current.getLeftChild().getRuleNum())
			{
				case 38:	// add
					((SimpleExpression) current).setAddop(ADD);
					break;
				case 39:	// subtract
					((SimpleExpression) current).setAddop(SUBTRACT);
					break;
				default:
					System.out.println("Invalid addop at CodeGenerator.handleSimpleExpression()");
			}
			
			current.deleteLeftChild();
			
			// handle term
			current = current.getLeftChild();
			handleTerm();
			
			((SimpleExpression) current).setOp2(((Term) current.getLeftChild()).getResultOp());
			int type2 = ((Term) current.getLeftChild()).getType();
			
			// type check
			if(((SimpleExpression) current).getType() == type2 && type2 != CHAR)
			{
				// generate code
				((SimpleExpression) current).setResultOp(getTemp());
				
				if(((SimpleExpression) current).getAddop() == ADD)
				{
					codeList.add("" + lineNum + " ADD " + ((SimpleExpression) current).getOp1() +
							 "," + ((SimpleExpression) current).getOp2() +
							 "," + ((SimpleExpression) current).getResultOp());
				}
				else
				{
					codeList.add("" + lineNum + " SUB " + ((SimpleExpression) current).getOp1() +
							 "," + ((SimpleExpression) current).getOp2() +
							 "," + ((SimpleExpression) current).getResultOp());
				}
				
				lineNum++;
			}
			else
			{
				if(type2 == CHAR)
				{
					Cornucopia.getErrorHandler().charAddError();
				}
				else
				{
					Cornucopia.getErrorHandler().typeMismatchError();
				}
			}
			
			// cleanup
			tempIdList.add(((SimpleExpression) current).getOp1());
			tempIdList.add(((SimpleExpression) current).getOp2());
		}
		
		prune();
	}
	
	/**
	 * Handles a term production node depending on it's rule number. Deletes the node
	 * after it has been handled. Generates code if necessary.
	 */
	private void handleTerm()
	{
		if(current.getRuleNum() == 25) 	// factor
		{
			current = current.getLeftChild();
			handleFactor();
			
			if(current.getLeftChild().getRuleNum() == 27)  // factor is id
			{
				((Term) current).setResultOp(((Factor) current.getLeftChild()).getId());
			}
			else
			{
				((Term) current).setResultVal(((Factor) current.getLeftChild()).getValue());
				((Term) current).setResultOp(getTemp());
				
				codeList.add("" + lineNum + " STO #" + ((Term) current).getResultVal() +
						 ",," + ((Term) current).getResultOp());

				lineNum++;
			}
			
			((Term) current).setType(((Factor) current.getLeftChild()).getType());
		}
		else							// term mulop factor
		{
			current = current.getLeftChild();
			handleTerm();	
			
			// set op1 and val1:
			((Term) current).setOp1(((Term) current.getLeftChild()).getResultOp());
			((Term) current).setVal1(((Term) current.getLeftChild()).getResultVal());
			((Term) current).setType(((Term) current.getLeftChild()).getType());
			
			current.deleteLeftChild();
			
			// set mulop
			switch(current.getLeftChild().getRuleNum())
			{
				case 40:	// multiply
					((Term) current).setMulop(MULTIPLY);
					break;
					
				case 41:	// divide
					((Term) current).setMulop(DIVIDE);
					break;
					
				case 42:	// modulo
					((Term) current).setMulop(MODULO);
					break;
					
				default:
					System.out.println("Invalid addop at CodeGenerator.handleTerm()");
			}
			
			current.deleteLeftChild();
			
			// handle factor:
			current = current.getLeftChild();
			handleFactor();
						
			if(current.getLeftChild().getRuleNum() == 27)  // factor is id
			{
				((Term) current).setOp2(((Factor) current.getLeftChild()).getId());
			}
			else
			{
				((Term) current).setVal2(((Factor) current.getLeftChild()).getValue());
				((Term) current).setOp2(getTemp());
				
				codeList.add("" + lineNum + " STO #" + ((Term) current).getVal2() +
						 ",," + ((Term) current).getOp2());

				lineNum++;
			}
			
			// check types
			int type2 = ((Factor) current.getLeftChild()).getType();

			if(((Term) current).getType() == type2 && type2 != CHAR)	// types match and not characters
			{
				// generate code
				((Term) current).setResultOp(getTemp());
				
				switch(((Term) current).getMulop())
				{
					case MULTIPLY:
						codeList.add("" + lineNum + " MUL " + ((Term) current).getOp1() +
								 "," + ((Term) current).getOp2() +
								 "," + ((Term) current).getResultOp());
						lineNum++;
						break;
					case DIVIDE:
						if(((Term) current).getVal2() != 0)
						{
							codeList.add("" + lineNum + " DIV " + ((Term) current).getOp1() +
									 "," + ((Term) current).getOp2() +
									 "," + ((Term) current).getResultOp());
							lineNum++;
						}
						else
						{
							Cornucopia.getErrorHandler().divideByZeroError();
						}
						break;
					case MODULO:
						if(((Term) current).getVal2() != 0)
						{
							codeList.add("" + lineNum + " MOD " + ((Term) current).getOp1() +
									 "," + ((Term) current).getOp2() +
									 "," + ((Term) current).getResultOp());
							lineNum++;
						}
						else
						{
							Cornucopia.getErrorHandler().divideByZeroError();
						}
						break;
					default:
						System.out.println("Mulop error");
				}
			}
			else
			{
				if(type2 == CHAR)
				{
					Cornucopia.getErrorHandler().charMultiplyError();
				}
				else
				{
					Cornucopia.getErrorHandler().typeMismatchError();
				}
			}
			
			// cleanup:
			tempIdList.add(((Term) current).getOp1());
			tempIdList.add(((Term) current).getOp2());			
		}
		prune();
	}
	
	/**
	 * Sends any values stored by a factor node to it's parent. Deletes the
	 * factor node afterwards.
	 */
	private void handleFactor()
	{
		switch(current.getRuleNum())
		{
			case 27: 	// ID case
				String id = ((ID) current.getLeftChild()).getId();
				
				if(Cornucopia.getSymbolTable().lookUp(id))
				{
					if(Cornucopia.getSymbolTable().isInitialized(id))
					{
						((Factor) current).setId(id);
						((Factor) current).setType(Cornucopia.getSymbolTable().getDataType(id));
						prune();
					}
					else
					{
						Cornucopia.getErrorHandler().uninitializedIdError(id);
					}
				}
				else
				{
					Cornucopia.getErrorHandler().undeclaredIdError(id);
				}
				
				break;
				
			case 28: 	// num case
				int value = ((Literal) current.getLeftChild()).getValue();
				((Factor) current).setValue(value);
				((Factor) current).setType(INT);
				
				prune();
				break;
				
			case 29:	// true case
				((Factor) current).setValue(TRUE);
				((Factor) current).setType(INT);
				
				current = current.getParent();
				break;
				
			case 30:	// false case
				((Factor) current).setValue(FALSE);
				((Factor) current).setType(INT);
				
				current = current.getParent();
				break;
				
			case 31:	// char case
				int charValue = ((Literal) current.getLeftChild()).getValue();
				((Factor) current).setValue(charValue);
				((Factor) current).setType(CHAR);
				
				prune();
				break;
			default:
				System.out.println("Unusual value at CodeGenerator.handleFactor()");
		}
	}
	
	/**
	 * Stores the main function's access modifier and deletes that node
	 * that contained it.
	 */
	private void setAccess()
	{
		current = root.getLeftChild();
		isPublic = ((Access) current).isPublic();
		current = root;
		root.deleteLeftChild();
	}
	
	/**
	 * Stores the main function's id and deletes the node
	 * that contained it upon completion. 
	 */
	private void setFunctionName()
	{
		current = root.getLeftChild();
		functionName = ((ID) current).getId();
		current = root;
		root.deleteLeftChild();
	}
	
	/**
	 * Inserts all main function parameter into the symbol table.
	 * Deletes id_list upon completion.
	 */
	private void setParameters()
	{		
		current = current.getLeftChild();
		
		if(current.getRuleNum() != 6)	// id list not empty
		{
			while(!(current instanceof Start))
			{
				while(current.hasChildren())
				{
					current = current.getLeftChild();
				}
				if(current instanceof ID)
				{
					if(Cornucopia.getSymbolTable().lookUp(((ID) current).getId()))
					{
						Cornucopia.getErrorHandler().idDeclaredError(((ID) current).getId());
					}
					else
					{
						Cornucopia.getSymbolTable().insert(((ID) current).getId());
					}
					
					current = current.getParent();
					current.deleteLeftChild();
				}
				else
				{
					current = current.getParent();
					current.deleteLeftChild();
				}
			}
		}
		else
		{
			root.deleteLeftChild();
		}
	}
	
	/**
	 * For each declaration, each identifier is added to the symbol table along
	 * with their type. Upon completion, all declaration nodes will be deleted.
	 */
	private void setDeclarations()
	{		
		current = root.getLeftChild();
		LinkedList<String> ids = new LinkedList<String>();
		
		if(current.getRuleNum() == 7)	// declarations exist
		{
			while(!(current instanceof Start))
			{
				while(current.hasChildren())
				{
					current = current.getLeftChild();
				}
				current = current.getParent();
				current.deleteLeftChild();
			
				marker = current;
			
				// store ids:
				current = current.getLeftChild();
				while(current != marker)
				{
					while(current.hasChildren())
					{
						current = current.getLeftChild();
					}
					if(current instanceof ID)
					{
						ids.add(((ID) current).getId());
						current = current.getParent();
						current.deleteLeftChild();
					}
					else
					{
						current = current.getParent();
						current.deleteLeftChild();
					}
				}

				// get type
				current = current.getLeftChild();
				idType = ((Type) current).getType();
				current = current.getParent();
				current.deleteLeftChild();

				// add to symbol table
				for(String s : ids)
				{
					if(Cornucopia.getSymbolTable().lookUp(s))
					{
						Cornucopia.getErrorHandler().idDeclaredError(s);
					}
					else
					{
						Cornucopia.getSymbolTable().insert(s, idType);
					}
				}
				
				// clean up:
				ids.clear();
				current = current.getParent();
			}
		}
		
		root.deleteLeftChild();
	}
	
	/**
	 * Returns true if this program's main function is public.
	 * 
	 * @return <code>true</code> if this program is public.
	 */
	public boolean isPublic()
	{
		return isPublic;
	}
	
	/**
	 * Returns the name of the source program's main function.
	 * This name is used to set the name of the target output
	 * file.
	 * 
	 * @return	This program's main function's id.
	 */
	public String getFunctionName()
	{
		return functionName;
	}
	
	/**
	 * Returns a temporary operand that will be used during code generation.
	 * Temporary operands begin with the string "temp", and end with an integer.
	 * The first temporary operand will be named "temp0", and each newly created
	 * operand will end with a number one higher than the last.
	 * <br>
	 * Once a temporary operand is no longer being used, it is added to a list
	 * of unused temporary operands. This method will attempt to return an unused
	 * operand before creating a new one.
	 * <br>
	 * Temporary operands use lowercase letters to avoid namespace collisions.
	 * 
	 * @return	A temporary operand.
	 */
	private String getTemp()
	{
		String temp;
		
		if(tempIdList.isEmpty())
		{
			temp = "temp" + tempCount;
			tempCount++;
		}
		else
		{
			temp = tempIdList.removeFirst();
		}
		
		return temp;
	}
	
	/**
	 * Deletes the current node's left child and sets current to current's
	 * parent.
	 */
	private void prune()
	{
		current.deleteLeftChild();
		current = current.getParent();
	}
	
	/**
	 * Transfers the produced code in the code list to a <code>StringBuilder</code>.
	 * Adds a new line character after each line of code. Finally, appends the final
	 * two lines of target code.
	 * <br>
	 * This method is called when the parse tree has been successfully pruned of all
	 * of every node but the root element.
	 */
	private void writeCode()
	{
		for(String s : codeList)
		{
			sb.append(s);
			sb.append("\n");
		}
		
		sb.append("" + lineNum++ + " NOP ,,\n");
		sb.append("" + lineNum + " HLT ,,");
	}
	
	/**
	 * Returns the code that was generated by the code generator.
	 * 
	 * @return	The target code.
	 */
	public String getCode()
	{
		return sb.toString();
	}
}