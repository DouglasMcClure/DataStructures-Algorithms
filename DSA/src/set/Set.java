package set;

import list.Iterator;

/**
 * A collection with no duplicated. Ordering
 * of the values need not be maintained
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public interface Set <E>{
    /**
     * @return true iff this Set contains the given
     * object.
     */
    boolean contains(Object obj);
    /**
     * Add the given value to this Set, if not already in
     * this Set.
     * @return true iff it was added.
     */
    boolean add(E value);
    /**
     * Remove the given Object from this Set, if possible.
     * @return true iff it was removed.
     */
    boolean remove(Object obj);
    /**
     * @return an Iterator for this Set
     */
    Iterator<E> iterator();
    /**
     * Clear this Set
     */
    void clear();
    /**
     * @return true iff this Set is empty
     */
    boolean isEmpty();
     /**
      * @return the number of values in this Set
     */
     int size();
    /**
     * @return true iff obj is a Set which contains the same values as
     * this Set, and only those values which are in this Set
     */
    boolean equals (Object obj);
}
