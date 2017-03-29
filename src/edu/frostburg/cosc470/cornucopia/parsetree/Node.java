package edu.frostburg.cosc470.cornucopia.parsetree;

import java.util.LinkedList;

/**
 * An abstract representation of a parse tree node. Contains a 
 * reference to the parent <code>Node</code>, a <code>LinkedList</code>
 * of children nodes, the rule number of the production that this node
 * represents, and the number of children that this node has.
 * <br>
 * Defines fields and methods that all parse tree nodes use.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 */
public abstract class Node 
{
	/**
	 * A reference to this node's parent node.
	 */
	private Node parent;
	/**
	 * A list of this node's children.
	 */
	private LinkedList<Node> children;
	/**
	 * The rule number of the production that this node represents.
	 */
	private int ruleNum;
	/**
	 * The number of child node's of this node.
	 */
	private int numChildren;
	
	/**
	 * Used to create a new node.
	 * 
	 * @param _ruleNum	The rule number of the production that this node 
	 * 					represents.
	 */
	public Node(int _ruleNum)
	{
		ruleNum = _ruleNum;
		numChildren = 0;
		children = new LinkedList<Node>();
	}
	
	/**
	 * Returns the number of children that this node has.
	 * 
	 * @return	The amount of children that this node has.
	 */
	public int getNumChildren()
	{
		return numChildren;
	}
	
	/**
	 * Returns the rule number of the production that this node
	 * represents.
	 * 
	 * @return	This node's rule number.
	 */
	public int getRuleNum()
	{
		return ruleNum;
	}
	
	/**
	 * Adds a new child to the front of the child node list.
	 * 
	 * @param _node	This node's new child.
	 */
	public void addChild(Node _node)
	{
		children.addFirst(_node);
		numChildren++;
	}
	
	/**
	 * Returns the left-most child of this node.
	 * 
	 * @return	This node's left child.
	 */
	public Node getLeftChild()
	{
		return children.getFirst();
	}
	
	/**
	 * Removes this node's left-most child. Decrements child count.
	 */
	public void deleteLeftChild()
	{
		children.removeFirst();
		numChildren--;
	}
	
	/**
	 * Returns true if this node has children.
	 * 
	 * @return	<code>true</code> if this node has children, and
	 * 			<code>false</code> otherwise.
	 */
	public boolean hasChildren()
	{
		return numChildren > 0;
	}
	
	/**
	 * Returns a reference to this node's parent node.
	 * 
	 * @return	This node's parent node.
	 */
	public Node getParent()
	{
		return parent;
	}
	
	/**
	 * Sets this node's children's parent.
	 * 
	 * @param _parent	The parent node of this node's children.
	 */
	public void setParent(Node _parent)
	{
		for(Node n : children)
		{
			n.parent = _parent;
		}
	}
	
	/**
	 * Returns a String representation of this node.
	 * 
	 * @return	A String representation of this node.
	 */
	public String toString()
	{
		return "Rule Number: " + ruleNum;
	}
}


