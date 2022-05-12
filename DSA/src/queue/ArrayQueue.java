package queue;

import list.ArrayList;
import list.List;

/**
 * An implementation of the QueueADT interface,
 * using an ArrayList.
 * @author (Douglas McClure)
 * @version (July 2021)
 */
public class ArrayQueue <E> implements QueueADT<E>{

    List<E> values = new ArrayList<E>();

    int front = 0;
    int back = 0;
    int size = 0;

    /**
     * This adds a value to the ArrayQueue
     * @param value
     */
    @Override
    public void add(E value) {
        if(size==values.size()) { // Arrylist is full?
            values.add(back, value); // Insert
            front = (front+1) % values.size(); //Wrap around
        }
        else
            values.set(back, value); //Clobber
        back = (back+1) % values.size(); //Wrap around
        size++;
    }

    /**
     * This removes a value from the ArrayQueue
     * @return front value that is being removed
     */
    @Override
    public E remove() {
        E result = values.get(front);
        front = (front+1) % values.size();
        size--;
        return result;
    }

    /**
     * This checks if the ArrayQueue is empty or
     * it will return the value at the front of the queue
     * @return
     */
    @Override
    public E peek() {
        if(size>0)
            return values.get(front);
        return null;
    }

    /**
     * This returns the size of the ArrayQueue
     * @return the size of the ArrayQueue
     */
    @Override
    public int size() {
        return values.size();
    }

    /**
     * This clears the ArrayQueue
     */
    @Override
    public void clear() {
        values.clear();
        front = 0;
        back = 0;
        size = 0;
    }

    /**
     * This checks if the ArrayQueue is empty
     * @return true or false if the ArrayQueue is empty
     */
    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * This returns the ArrayQueue as a String
     * @return the ArrayQueue as a String
     */
    public String toString() {

        if (isEmpty())
            return "[]";

        String list = "[";

            list += values.get(front);

            for (int i = (front + 1) % values.size(); i != back; i = (i+1) % values.size()) {
                list += ", " + values.get(i);
            }

        return list + "]";
    }
}
