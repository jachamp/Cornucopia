package edu.frostburg.cosc470.cornucopia.collections;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Represents a stack that uses an underlying <code>LinkedList</code> data structure.
 * Elements are added and removed from the end of the <code>LinkedList</code>.
 * 
 * @author 	James Champ
 * @version	0.8, May 16, 2016
 * @param <T>	The type that this stack holds.
 * 
 * @see LinkedList
 */

public class LinkedListStack<T> implements Stack<T> 
{
	/**
	 * The stack.
	 */
	private LinkedList<T> stack;
	
	/**
	 * The amount of objects on the stack.
	 */
	private int count;
	
	/**
	 * Creates a new stack object.
	 */
	public LinkedListStack()
	{
		stack = new LinkedList<T>();
		count = 0;
	}
	
	/**
	 * Removes and returns the top object on the stack. Increments count.
	 * 
	 * @return	The top object on the stack.
	 */
	@Override
	public T pop() 
	{
		if(stack.isEmpty())
		{
			throw new NoSuchElementException("Illegal pop operation: The stack is empty.");
		}
		
		count--;
		
		return stack.remove(count);
	}

	/**
	 * Adds the given object to the top of the stack. Decrements count.
	 * 
	 * @param _elem	The element being pushed onto the stack.
	 */
	@Override
	public void push(T _elem) 
	{
		stack.add(_elem);
		count++;
	}

	
	/**
	 * Returns, but does not remove, the top element of the stack.
	 * 
	 * @return	The top object of the stack.
	 * @see edu.frostburg.cosc470.cornucopia.collections.Stack#peek()
	 */
	@Override
	public T peek() 
	{
		if(stack.isEmpty())
		{
			throw new NoSuchElementException("Illegal peek operation: The stack is empty.");
		}
		
		return stack.get(count - 1);
	}

	/**
	 * Returns the number of objects on the stack.
	 * 
	 * @return	The number of objects on the stack.
	 * @see edu.frostburg.cosc470.cornucopia.collections.Stack#size()
	 */
	@Override
	public int size() 
	{	
		return count;
	}

	/**
	 * Returns <b>true</b> if the stack contains more than 0 objects.
	 * 
	 * @return	<code>true</code> if the stack is empty, and <b>false</b> 
	 * 			otherwise.
	 * @see edu.frostburg.cosc470.cornucopia.collections.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() 
	{
		if(count == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	/**
	 * Returns a <code>String</code> representation of the stack's
	 * contents. Contents are listed from bottom to top.
	 * <br>
	 * Used for debugging purposes.
	 * 
	 * @return	A <code>String</code> representation of the 
	 * 			stack's contents.
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Bottom: ");
		for(int i = 0; i < stack.size(); i++)
		{
			sb.append(stack.get(i) + "  ");
		}
		sb.append("top");
		return sb.toString();
	}
}
