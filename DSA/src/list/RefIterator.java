package list;

/**
 * A RefIterator is an Iterator which allows iteration through a LinkedList.
 * @author (Douglas McClure)
 * @version (July 2021)
 */
public class RefIterator <E> implements Iterator<E>{
    LinkedList<E> list;
    // Reference to the Node storing the last value
    //obtained by a call to next()
    Node<E> cursor;

    //Constructor
    RefIterator(LinkedList<E> list){
        this.list = list;
        cursor = list.head;
    }

    /**
     * Returns true or false if the iterator has a next value
     * @return true or false if the next value for cursor doesn't equal the end of the list.
     */
    @Override
    public boolean hasNext() {
        return cursor.next != list.tail;
    }

    /**
     * This moves the iterator to the next index in the list.
     * @return the next value of the list
     */
    @Override
    public E next() {
        cursor = cursor.next;
        return cursor.value;
    }

    /**
     * Removes the value from the list
     */
    @Override
    public void remove() {
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        list.size--;
    }

    /**
     * Returns true or false if the RefIterator has a next value
     * @return if the next value for cursor doesn't equal the end of the list.
     */
    @Override
    public boolean has2More() {
        if(cursor.next != list.tail){
            if(cursor.next.next != list.tail) {
                    return true;
            }
        }
        return false;
    }
}
