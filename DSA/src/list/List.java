package list;

/**
 * An ADT for a Collection in which duplicates are permitted, and order is maintained.
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public interface List<E>{
    /**
     * @return the value at the given index in this List. @param 0 <= index < size
     */
    E get(int index);

    /**
     * Set the value at the given index to the given value.
     * @return the old value. @param 0 <= index < size
     */
    E set(int index, E value);

    /**
     * Add the given value at the end of this List.
     */
    void add(E value);

    /**
     * Insert the given value at the given index in this List @param 0 <= index <= size
     */
    void add (int index, E value);

    /**
     * Remove the value at the given index from this List.
     * @return the value which was removed. @param 0 <= index < size
     */
    E remove (int index);

    /**
     * @return the size of this List
     */
    int size();

    /**
     *  Clear this List
     */
    void clear();

    /**
     * @return true iff this List is empty
     */
    boolean isEmpty();

    /** @return the position of the first occurrence of the given Object in this List,
     * or -1 if it is not in this List
     */
    int indexOf (Object obj);

    /**
     * @return the position of the last occurence of the given Object in this List,
     * or -1, if not found
     */
    int indexOfLast(Object obj);

    /**
     * @return true only if the given Object is in this List
     */
    boolean contains (Object obj);

    /** Remove the first occurrence of the given object from this List.       @return true iff it was removed*/
    boolean remove (Object obj);

    /** @return true only if the parameter obj is a List and contains the same elements
     * (in the same sequence) as this List.
     */
    boolean equals (Object obj);

    /**@return an Iterator for this List
     */
    Iterator<E> iterator();

    /**
     * @return a ListIterator for this List
     */
    ListIterator<E> listIterator();

    /**@return a ListIterator for this List.
     * @param start iterating at given start position.
     * Initial call to previous() returns the value
     * at position start-1
     */
    ListIterator<E> listIterator(int start);

    /**
     * Add all items to the list
     */
    void addAll(List<E>list);
}
