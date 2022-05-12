package stack;

import list.ArrayList;
import list.LinkedList;
import list.List;

/**
 * An implementation of the StackADT interface using a List.
 * Client may opt for an ArrayList or a LinkedList.
 * Top of the Stack is at the end of the List.
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class Stack <E> implements StackADT<E>{

    List<E> values = new ArrayList<E>();


    /**
     * Default constructor.
     * Use an ArrayList
     */
    public Stack(){

    }

    /**
     * Constructor
     * @param arrayBased => Use an ArrayList.
     *       !arrayBased => Use a LinkedList.
     */
    public Stack(boolean arrayBased){
        if(!arrayBased)
            values = new LinkedList<E>();
    }

    /**
     * This pushes the value onto the stack
     * @param value
     * @return the value being pushed onto the stack
     */
    @Override
    public E push(E value) {
        values.add(value);
        return value;
    }

    /**
     * This removes the value from the stack
     * @return the value being removed from the stack
     */
    @Override
    public E pop() {
        return values.remove(values.size()-1);
    }

    /**
     * This allows you to check the last value in the stack
     * @return the last value in the stack
     */
    @Override
    public E peek() {
        return values.get(values.size()-1);
    }

    /**
     * This checks if the stack is empty
     * @return true or false if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * This clears the stack
     */
    @Override
    public void clear() {
            values.clear();
    }

    /**
     * This returns the size of the stack
     * @return the size of the stack
     */
    @Override
    public int size() {
        return values.size();
    }

    /**
     * This returns the stack as a String
     * @return the stack as a String
     */
    public String toString(){
        return values.toString();
    }
}
