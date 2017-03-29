package edu.frostburg.cosc470.cornucopia.parsetree;

import edu.frostburg.cosc470.cornucopia.grammar.Grammar;

/**
 * Table of productions that is used to create the parse tree. Productions in a
 * parse tree will have a specific amount of children, dependent on each production's
 * rule number. This table contains the number of children that each production rule 
 * will have. The table also contains, in it's last two rows, the number of children
 * that ID and Literal nodes contain.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class ElementTable 
{
	private final static int LITERAL = 43;
	private final static int ID = 44;
	
	/**
	 * A table of productions and the amount of 
	 * children that each representative node will
	 * have. The first column isn't used in this
	 * program, and exists solely to aid readability.
	 */
	public final static int[][] PRODUCTIONS = 	{//  Node    		 Children
												 //  ----------      --------
													{Grammar.START, 		5},
													{Grammar.ACCESS, 		0},
													{Grammar.ACCESS,		0},
													{Grammar.ID_LIST,		1},
													{Grammar.ID_LIST,		2},
													{Grammar.ID_LIST,		0},
													{Grammar.DECLARATIONS,	3},
													{Grammar.DECLARATIONS,	0},
													{Grammar.TYPE,			0},
													{Grammar.TYPE,			0},
													{Grammar.COMPOUND_STMT,	1},
													{Grammar.STMT_LIST,		1},
													{Grammar.STMT_LIST,		2},
													{Grammar.STATEMENT,		1},
													{Grammar.STATEMENT,		1},
													{Grammar.STATEMENT,		1},
													{Grammar.STATEMENT,		1},
													{Grammar.STATEMENT,		2},
													{Grammar.LEFT_HS,		2},
													{Grammar.RIGHT_HS,		1},
													{Grammar.EXPRESSION,	1},
													{Grammar.EXPRESSION,	3},
													{Grammar.SIMPLE_EXPR,	1},
													{Grammar.SIMPLE_EXPR,	3},
													{Grammar.TERM,			1},
													{Grammar.TERM,			3},
													{Grammar.FACTOR,		1},
													{Grammar.FACTOR,		1},
													{Grammar.FACTOR,		0},
													{Grammar.FACTOR,		0},
													{Grammar.FACTOR,		1},
													{Grammar.RELOP,			0},
													{Grammar.RELOP,			0},
													{Grammar.RELOP,			0},
													{Grammar.RELOP,			0},
													{Grammar.RELOP,			0},
													{Grammar.RELOP,			0},
													{Grammar.ADDOP,			0},
													{Grammar.ADDOP,			0},
													{Grammar.MULOP,			0},
													{Grammar.MULOP,			0},
													{Grammar.MULOP,			0},
													{LITERAL,				0},
													{ID,					0}
												};
}
