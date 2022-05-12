package queue;

/**
 * A First-in First-out List.
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public interface QueueADT <E> {

    /**
     * Add the given value at the back of this QueueADT
     */
    void add(E value);

    /** Remove the value which is at the front of the QueueADT
     * @return The value which was removed.
     * Pre: This QueueADT is not empty.
     */
    E remove();

    /**
     * @return the value is at the front of this QueueADT,
     * or null if this QueueADT is empty.
     */
    E peek();

    /** @return the size of this QueueADT
     */
    int size();

    /** Clear this QueueADT
     */
    void clear();

    /** @return true iff this QueueADT is empty
     */
    boolean isEmpty();

}
