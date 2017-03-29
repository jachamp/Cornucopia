package edu.frostburg.cosc470.cornucopia.collections;

/**
 * Represents a "first in-first out" data structure.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 * @param <T> The type of object that this stack holds.
 */
public interface Stack <T>
{
	
	/**
	 * Removes and returns the top element of the stack.
	 * 
	 * @return	The top element of the stack.
	 */
	T pop();
	
	/**
	 * Adds the given element to the stack.
	 * 
	 * @param _elem	The element being stored in the stack.
	 */
	void push(T _elem);
	
	/**
	 * Returns the top element of the stack.
	 * 
	 * @return The top element of the stack.
	 */
	T peek();
	
	/**
	 * Returns the number of elements on the stack.
	 * 
	 * @return	The number of elements on the stack.
	 */
	int size();
	
	/**
	 * Returns true if the stack is empty.
	 * 
	 * @return <code>true</code> if the stack is empty, <code>false</code>
	 * 			otherwise.
	 */
	boolean isEmpty();
}
