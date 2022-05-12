package queue;

import list.LinkedList;
import list.List;

/**
 * An implementation of the QueueADT interface,
 * using a LinkedList.
 * @author (Douglas McClure)
 * @version (July 2021)
 */
public class Queue <E> implements QueueADT<E>{

    List<E> values = new LinkedList<E>();

    //front is at position 0 (head)
    //back is at position size-1 (tail)

    /**
     * Adds a value to the Queue
     * @param value
     */
    @Override
    public void add(E value) {
        values.add(value);
    }

    /**
     * Removes a value from the Queue
     * @return the value being removed from the front
     */
    @Override
    public E remove() {
        return values.remove(0);
    }

    /**
     * This checks if the queue is empty or
     * it will return the value at the front of the queue
     * @return empty/null or the front value of the queue
     */
    @Override
    public E peek() {
        if(values.isEmpty())
            return null;
        return values.get(0);
    }

    /**
     * This returns the size of the queue
     * @return the size of the queue
     */
    @Override
    public int size() {
        return values.size();
    }

    /**
     * This clears the queue
     */
    @Override
    public void clear() {
        values.clear();
    }

    /**
     * This checks if the queue is empty
     * @return true or false if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * This returns the queue as a String
     * @return the queue as a String
     */
    public String toString(){
        return values.toString();
    }
}
