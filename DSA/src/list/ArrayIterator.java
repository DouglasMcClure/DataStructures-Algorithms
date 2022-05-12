package list;

/**
 * An ArrayIterator is an Iterator which allows iteration
 * through an ArrayList.
 * @author (Douglas McClure)
 * @version (July 2018)
 */
public class ArrayIterator <E> implements Iterator<E>{
    List<E> list;
    // Position of the last value obtained by a call to next();
    int index = -1;

    //Constructor
    ArrayIterator(List<E> list){
        this.list = list;
    }

    /**
     * Returns true or false if the iterator has a next value
     * @return true or false if the index is less than the list size.
     */
    @Override
    public boolean hasNext() {
        return index < list.size() - 1;
    }

    /**
     * This moves the iterator to the next index in the list.
     * @return the next value in the iterator
     */
    @Override
    public E next() {
        index++;
        return list.get(index);
    }

    /**
     * removes the item from the iterator inside the list.
     */
    @Override
    public void remove() {
        list.remove(index);
        index--;
    }

    /**
     * This checks if there are 2 more values after the position where the index is located.
     * @return true or false if the index is less than the size minus 2
     */
    @Override
    public boolean has2More() {
        if(index < list.size() - 2)
            return true;
        return false;
    }
}
