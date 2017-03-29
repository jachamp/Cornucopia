package edu.frostburg.cosc470.cornucopia.parser;

import java.io.IOException;
import java.io.Reader;

import edu.frostburg.cosc470.cornucopia.collections.LinkedListStack;
import edu.frostburg.cosc470.cornucopia.grammar.Grammar;
import edu.frostburg.cosc470.cornucopia.lexer.*;
import edu.frostburg.cosc470.cornucopia.main.Cornucopia;
import edu.frostburg.cosc470.cornucopia.parsetree.*;

/**
 * Creates a <code>Lexer</code> and parses each token generated by
 * the Lexer. Builds a parse tree as each token is successfully
 * parsed.
 * 
 * @author James Champ
 * @version	0.8, May 16, 2016
 */
public class Parser 
{
	/**
	 * Stack for pushdown automaton.
	 */
	private LinkedListStack<Integer> pushDownStack;
	/**
	 * Stack for parse tree nodes.
	 */
	private LinkedListStack<Node> nodeStack;
	
	/**
	 * Parse tree for syntactically correct Cornucopia program.
	 */
	private Node parseTree;
	/**
	 * An instance of this compiler's lexer.
	 */
	private Lexer lex;
	/**
	 * Holds the current token that was received from the lexer.
	 */
	private Token token;
	
	/**
	 * Holds previous token for error handling.
	 */
	private Token prevToken;
	/**
	 * Represents the current cell in the parse table.
	 */
	private int cell;
	/**
	 * Represents the current row in the parse table.
	 */
	private int row;
	/**
	 * Represents the current column in the parse table.
	 */
	private int column;
	/**
	 * Flag that indicates whether the last action was a reduction.
	 */
	private boolean hasReduced;
	
	/**
	 * Creates a new <code>Parser</code> object. Initializes lexer and both
	 * stacks. Pushes initial state onto push down stack.
	 * 
	 * @param _in	Input stream for file containing program
	 */
	public Parser(Reader _in)
	{
		lex = new Lexer(_in);
		pushDownStack = new LinkedListStack<Integer>();
		nodeStack = new LinkedListStack<Node>();
		
		pushDownStack.push(0);
	}
	
	/**
	 * Parses the program and determines if it is syntactically correct.
	 * 
	 * @return	<code>true</code> if the program was syntactically correct, and 
	 * 			<code>false</code> otherwise.
	 */
	public boolean parse()
	{
		boolean isValid = true;
		
		try
		{			
			token = lex.nextToken();
			cell = -1;
			row = 0;
			column = token.getType();
			hasReduced = false;
			
			// no errors or accepting state
			while(cell != ParseTable.ERR && cell != ParseTable.ACC)
			{
				cell = ParseTable.PARSE_TABLE[row][column];
				
				// has not reduced
				if(!hasReduced)
				{
					// shift case
					if(cell <= ParseTable.S74)
					{
						shift();
						prevToken = token;
						token = lex.nextToken();
						column = token.getType();
					}
					// reduce case
					else if(cell <= ParseTable.R42)
					{						
						reduce();
					}
				}
				else // goto case
				{
					gotoState();
				}
				
				if(cell == ParseTable.ERR)
				{
					isValid = false;
					Cornucopia.getErrorHandler().syntaxError(prevToken.getLineNum() + 1, prevToken.getColNum());
				}
				if(cell == ParseTable.ACC)
				{
					isValid = canAccept();
				}
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return isValid;
	}
	
	/**
	 * Shifts the current token's type and the current row onto
	 * the push down stack. If the token is an instance of an
	 * <code>IDToken</code> or a <code>LiteralToken</code>, a new 
	 * parse tree element is created and pushed onto the node stack.
	 */
	private void shift()
	{
		row = cell;
		
		pushDownStack.push(token.getType());
		pushDownStack.push(row);		
		
		if(token instanceof IDToken)
		{
			nodeStack.push(new ID(((IDToken) token).getID()));
		}
		else if(token instanceof LiteralToken)
		{
			nodeStack.push(new Literal(((LiteralToken) token).getValue()));
		}
	}
	
	/**
	 * Pops the proper amount of elements off of the
	 * push down stack and creates a new parse tree
	 * node of the appropriate type. Adds children
	 * to newly created parse tree node, if they exist,
	 * and pushes new node onto the node stack.
	 * <br>
	 * Node children are created by popping the proper
	 * amount of nodes off of the node stack.
	 * 
	 * @see	ElementTable
	 */
	private void reduce()
	{
		int rule = cell - 100;
		int rhs = Grammar.GRAMMAR[rule][0];						
		int numPops = Grammar.GRAMMAR[rule][1] * 2;
		
		// pop push down stack elements:
		while(numPops > 0)
		{
			pushDownStack.pop();
			numPops--;
		}
		
		numPops = ElementTable.PRODUCTIONS[rule][1];
		Node treeNode = createNode(rule);
		
		while(numPops > 0)
		{
			treeNode.addChild(nodeStack.pop());
			numPops--;
		}
		
		treeNode.setParent(treeNode);
		
		nodeStack.push(treeNode);
		
		row = pushDownStack.peek();
		column = rhs - 64;
		pushDownStack.push(rhs);
		hasReduced = true;
	}
	
	/**
	 * Represents a goto action. Sets row and column to
	 * new values and pushes current production onto
	 * push down stack.
	 */
	private void gotoState()
	{
		row = cell;
		column = token.getType();
		pushDownStack.push(row);
		hasReduced = false;
	}
	
	/**
	 * Determines whether the program is valid or not. If a token
	 * exists after the end program symbol, the program will not
	 * be accepted.
	 * <br>
	 * If the program is valid, a complete parse tree is created 
	 * from the nodes that are on the node stack.
	 * 
	 * @return	<code>true</code> if the program is syntactically valid,
	 * 			and <code>false</code> otherwise.
	 * 
	 * @throws 	IOException	if the lexer fails while attempting to get
	 * 			another token.
	 */
	private boolean canAccept() throws IOException
	{
		prevToken = token;
		Token t = lex.nextToken();
		
		if(t != null)
		{
			//TODO: error handler should do this:
			System.out.println("Not accepted: Tokens found after \"$\"");
			return false;
		}
		else
		{
			parseTree = new Start();
			
			while(!nodeStack.isEmpty())
			{
				parseTree.addChild(nodeStack.pop());
			}
			
			parseTree.setParent(parseTree);
			
			return true;
		}
	}
	
	/**
	 * Creates a new parse tree node that represents a specific production.
	 * 
	 * @param _rule	Integer that represents the production rule
	 * 				that was reduced.
	 * @return		A new <code>Node</code> representing a specific production.
	 * 
	 * @see	Node
	 */
	private Node createNode(int _rule)
	{
		Node production;
		_rule++;	// add offset
		
		switch(_rule)
		{
			case 2: case 3:
				production = new Access(_rule);
				break;
			case 4: case 5: case 6:
				production = new IdList(_rule);
				break;
			case 7: case 8:
				production = new Declarations(_rule);
				break;
			case 9: case 10:
				production = new Type(_rule);
				break;
			case 11:
				production = new CompoundStatement(_rule);
				break;
			case 12: case 13:
				production = new StatementList(_rule);
				break;
			case 14: case 15: case 16: case 17: case 18:
				production = new Statement(_rule);
				break;
			case 19:
				production = new LefthandSide(_rule);
				break;
			case 20:
				production = new RighthandSide(_rule);
				break;
			case 21: case 22:
				production = new Expression(_rule);
				break;
			case 23: case 24:
				production = new SimpleExpression(_rule);
				break;
			case 25: case 26:
				production = new Term(_rule);
				break;
			case 27: case 28: case 29: case 30: case 31:
				production = new Factor(_rule);
				break;
			case 32: case 33: case 34: case 35: case 36: case 37:
				production = new Relop(_rule);
				break;
			case 38: case 39:
				production = new Addop(_rule);
				break;
			case 40: case 41: case 42:
				production = new Mulop(_rule);
				break;
			default:
				production = null;
				System.out.println("\t\tAn error occurred at Parser.createProduction()\tRule: " + _rule);
		}
		
		return production;
	}
	
	/**
	 * Returns the parse tree that was generated by this parser.
	 * 
	 * @return	A parse tree that represents a Cornucopia program.
	 */
	public Node getParseTree()
	{
		return parseTree;
	}
}