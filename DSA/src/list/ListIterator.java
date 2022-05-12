package list;

/**
 * An Iterator which can go to the previous value as well as the next value.
 * @author (Douglas McClure)
 * @version (July 2021)
 */
public interface ListIterator<E> extends Iterator<E> {
    /*
        Implicit cursor
        a   b   c   d
               ^
        next() -> c
        previous() -> b
     */

    /**
     * @return true only if there is a previous value
     */
    boolean hasPrevious();

    /**
     * @return the previous value, and move the implicit cursor
     * to the left
     */
    E previous();

    /** Insert the given value just prior to the implicit cursor position.
     * A subsequent call to previous()
     * should return the inserted value, and a subsequent call to next() should be unaffected.
     */
    public void add (E value);

}
