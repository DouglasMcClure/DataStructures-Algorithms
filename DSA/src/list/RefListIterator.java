package list;

/**
 * A ListIterator specifically for LinkedLists
 * @author (Douglas McClure)
 * @version (July 2021)
 */
public class RefListIterator<E> extends RefIterator<E> implements ListIterator<E>{
    /*
        cursor, in the superclass, is a reference to the last value returned by a call to
        next() or previous().
     */
    private boolean forward = true;

    //Constructor
    RefListIterator (LinkedList<E> list){
        super(list);
    }

    //@param start is starting position for iteration
    RefListIterator (LinkedList<E> list, int start){
        super(list);
        for (int i = 0; i < start; i++) {
            cursor = cursor.next;
        }
    }

    /**
     * This checks if there is a next value for the iterator
     * @return true or false if the list is empty
     *         and if the next cursor value equals the end of the list
     */
    @Override
    public boolean hasNext() {
        if (list.isEmpty())
            return false;
        if (forward)
            return cursor.next != list.tail;
        return true;
    }

    /**
     * This moves the iterator to the next value for cursor
     * @return the next value for cursor
     */
    @Override
    public E next() {
        if(forward)
            cursor = cursor.next;
        forward = true;
        return cursor.value;
    }

    /**
     * This checks if there is a previous value in the iterator
     * @return true or false the previous value of cursor doesn't equal the front of the list
     */
    @Override
    public boolean hasPrevious() {
        if(!forward)
            return cursor.prev != list.head;
        return cursor != list.head; // initial call to hasPrevious() ?
    }

    /**
     * This moves the iterator to the previous value
     * @return the previous value for cursor
     */
    @Override
    public E previous() {
        if(!forward)
            cursor = cursor.prev;
        forward = false;
        return cursor.value;
    }

    /**
     * This adds a value to the iterator
     * @param value
     */
    @Override
    public void add(E value) {

        if(forward) {
            list.add(list.indexOf(cursor.next.value), value);
            cursor = cursor.next;
        }
        if (!forward){
            list.add(list.indexOf(cursor.value), value);
        }
    }

    /**
     * This removes a value from the iterator
     */
    @Override
    public void remove() {
        super.remove();
        if (forward)
            cursor = cursor.prev;
        else
            cursor = cursor.next;
    }
}
