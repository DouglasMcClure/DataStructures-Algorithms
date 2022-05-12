package queue;

import list.ArrayList;
import list.List;

/**
 * A priorityQueue is a Queue, in which each item has
 * a priority. When removing, the value with the highest
 * priority is removed (not FIFO).
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class PriorityQueue<E extends Comparable> implements QueueADT<E>{
    List<E> values = new ArrayList<E>();

    /**
     * @return position of parent's bigger child
     */
    private int biggerChild (int parent){
        int left = 2*parent +1, // left child
        right = left + 1;
        if (right >= values.size()) // has a right child?
            return left;

        if (greater (left, right)) // left > right?
            return left;
        return right;
    }

    /**
     * @return true iff the value at position x is
     * greater than value at position y
     */
    private boolean greater (int x, int y){
        return values.get(x).compareTo(values.get(y)) > 0;
    }

    /**
     * Add the given value at the back of this QueueADT
     *
     * @param value
     */
    @Override
    public void add(E value) {
            int added, parent;
            values.add(value);
            added = values.size() -1;
            parent = (added-1) / 2;
            while (added>0 && greater (added, parent)){
                swap(added, parent); // added moves up
                added = parent;
                parent = (added-1) / 2;
            }
    }

    /**
     * Remove the value which is at the front of the QueueADT
     *
     * @return The value which was removed.
     * Pre: This QueueADT is not empty.
     */
    @Override
    public E remove() {
        E result = values.get(0); // highest priority
        int last = values.size()-1;
        int avail = 0;           // Position of an available
                                 // slot.
        int bc = biggerChild (0);// Position of bigger child.
        while (2*avail+1 < last &&
        greater (bc, last)){
            values.set(avail, values.get(bc));
            avail = bc;
            bc = biggerChild (avail);
        }
        values.set(avail, values.get(last));
        values.remove(last);
        return result;
    }

    /**
     * @return the value is at the front of this QueueADT,
     * or null if this QueueADT is empty.
     */
    @Override
    public E peek() {
        if(values.isEmpty())
            return null;
        return values.get(0);
    }

    /**
     * @return the size of this QueueADT
     */
    @Override
    public int size() {
        return values.size();
    }

    /**
     * Clear this QueueADT
     */
    @Override
    public void clear() {
        values.clear();
    }

    /**
     * @return true iff this QueueADT is empty
     */
    @Override
    public boolean isEmpty() {
       return values.isEmpty();
    }

    /**
     * Exchange the items at the given positions in the list
     */
    private void swap(int x, int y){
        E temp = values.get(x);
        values.set(x, values.get(y));
        values.set(y,temp);
    }

    /**
     * This returns the queue as a String
     * @return the queue as a String
     */
    public String toString(){
        return values.toString();
    }
}
