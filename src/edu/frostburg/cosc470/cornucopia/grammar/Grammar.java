package edu.frostburg.cosc470.cornucopia.grammar;

/**
 * Represents each Cornucopia grammar in tabular form. This class
 * is used by the <code>Parser</code> to check the source file for
 * syntactic errors.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public class Grammar 
{
	// productions:
	public final static int START         = 100;
	public final static int ACCESS        = 101;
	public final static int ID_LIST       = 102;
	public final static int DECLARATIONS  = 103;
	public final static int COMPOUND_STMT = 104;
	public final static int TYPE          = 105;
	public final static int STMT_LIST     = 106;
	public final static int STATEMENT     = 107;
	public final static int LEFT_HS       = 108;
	public final static int EXPRESSION    = 109;
	public final static int RIGHT_HS      = 110;
	public final static int SIMPLE_EXPR   = 111;
	public final static int RELOP         = 112;
	public final static int TERM          = 113;
	public final static int ADDOP         = 114;
	public final static int FACTOR        = 115;
	public final static int MULOP         = 116;

	// terminals:
	public final static int STATIC        =   0;
	public final static int VOID          =   1;
	public final static int ID            =   2;
	public final static int L_PARENS      =   3;
	public final static int R_PARENS      =   4;
	public final static int L_BRACE       =   5;
	public final static int R_BRACE       =   6;
	public final static int END_P         =   7;
	public final static int PUBLIC        =   8;
	public final static int PRIVATE       =   9;
	public final static int COMMA         =  10;
	public final static int VAR           =  11;
	public final static int COLON         =  12;
	public final static int SEMICOLON     =  13;
	public final static int CHAR          =  14;
	public final static int INT           =  15;
	public final static int GET           =  16;
	public final static int PUT           =  17;
	public final static int IF            =  18;
	public final static int EQUALS        =  19;
	public final static int NUM           =  20;
	public final static int TRUE          =  21;
	public final static int FALSE         =  22;
	public final static int S_QUOTE       =  23;
	public final static int CHAR_LITERAL  =  24;
	public final static int GREATER       =  25;
	public final static int G_EQUAL	      =  26;
	public final static int REL_EQUAL     =  27;
	public final static int L_EQUAL	      =  28;
	public final static int LESSER        =  29;
	public final static int NOT_EQUAL     =  30;
	public final static int PLUS          =  31;
	public final static int MINUS         =  32;
	public final static int MULTIPLY      =  33;
	public final static int DIVIDE        =  34;
	public final static int MODULO        =  35;

	/**
	 * A table representation of Cornucopia's grammar. The first column contains
	 * the production, the second column contains the number of right-hand side
	 * elements, and the remaining columns contain the right-hand side elements, if
	 * any, in reverse order.
	 */
	public final static int[][] GRAMMAR = {
												{START,        12, END_P, R_BRACE, COMPOUND_STMT, DECLARATIONS, L_BRACE, R_PARENS, ID_LIST, L_PARENS, ID, VOID, STATIC, ACCESS},
												{ACCESS,        1, PUBLIC},
												{ACCESS,        1, PRIVATE},
												{ID_LIST,       1, ID},
												{ID_LIST,       3, ID, COMMA, ID_LIST},
												{ID_LIST,       0},
												{DECLARATIONS,  6, SEMICOLON, TYPE, COLON, ID_LIST, VAR, DECLARATIONS},
												{DECLARATIONS,  0},
												{TYPE,          1, CHAR},
												{TYPE,          1, INT},
												{COMPOUND_STMT, 3, R_BRACE, STMT_LIST, L_BRACE},
												{STMT_LIST,     1, STATEMENT},
												{STMT_LIST,     3, STATEMENT, SEMICOLON, STMT_LIST},
												{STATEMENT,     1, LEFT_HS},
												{STATEMENT,     1, COMPOUND_STMT},
												{STATEMENT,     4, R_PARENS, ID, L_PARENS, GET},
												{STATEMENT,     4, R_PARENS, ID, L_PARENS, PUT},
												{STATEMENT,     5, STATEMENT, R_PARENS, EXPRESSION, L_PARENS, IF},
												{LEFT_HS,       3, RIGHT_HS, EQUALS, ID},
												{RIGHT_HS,      1, EXPRESSION},
												{EXPRESSION,    1, SIMPLE_EXPR},
												{EXPRESSION,    3, SIMPLE_EXPR, RELOP, SIMPLE_EXPR},
												{SIMPLE_EXPR,   1, TERM},
												{SIMPLE_EXPR,   3, TERM, ADDOP, SIMPLE_EXPR},
												{TERM,          1, FACTOR},
												{TERM,          3, FACTOR, MULOP, TERM},
												{FACTOR,        1, ID},
												{FACTOR,        1, NUM},
												{FACTOR,        1, TRUE},
												{FACTOR,        1, FALSE},
												{FACTOR,        3, S_QUOTE, CHAR_LITERAL, S_QUOTE},
												{RELOP,         1, GREATER},
												{RELOP,         1, G_EQUAL},
												{RELOP,         1, REL_EQUAL},
												{RELOP,         1, L_EQUAL},
												{RELOP,         1, LESSER},
												{RELOP,         1, NOT_EQUAL},
												{ADDOP,         1, PLUS},
												{ADDOP,         1, MINUS},
												{MULOP,         1, MULTIPLY},
												{MULOP,         1, DIVIDE},
												{MULOP,         1, MODULO}
											};
}
