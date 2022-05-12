package stack;

/**
 * A stack is a Last-In First-out List.
 * Access is limited to the 'top' of the Stack.
 * @author (Douglas McClure)
 * @version (July 2021)
 */
public interface StackADT<E> {
    /**
     *Add the given value at the top of this StackADT
     * @return the value which was pushed.
     */
    E push(E value);

    /**
     * Remove the value at the top of this StackADT.
     * @return the value removed.
     * Pre: This StackADT is not empty.
     */
    E pop();

    /**
     * @return the value at the top of this StackADT.
     * Pre: This StackADT is not empty.
     */
    E peek();

    /** @return true iff this StackADT is empty.
     */
    boolean isEmpty();

    /** clear this StackADT
     * Post:  clear() now returns true
     */
    void clear();

    /** @return the size of this StackADT.
     */
    int size();
}
