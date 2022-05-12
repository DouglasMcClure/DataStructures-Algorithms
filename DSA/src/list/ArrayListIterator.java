package list;

/**
 * A ListIterator specifically for ArrayLists
 * @author (Douglas McClure)
 * @version (July 2021)
 */
public class ArrayListIterator <E> extends  ArrayIterator<E> implements ListIterator<E>{
    /*
        index is in the super class. Implicit cursor is between positions index and index+1

                                   0   1   2   3   4
                                   a   b   c   d   e
                        index   -1  0   1   2   3   4   implicit cursor
     */

    //forward => iterating left to right using next()
    //!forward => iterating right to left, using previous()
    private boolean forward = true;
    //Constructors
    ArrayListIterator(List<E> list){
        super (list);
    }
    ArrayListIterator(List<E> list, int start){
        super(list);
        index = start - 1;
    }

    /**
     * This checks if there is a previous value in the iterator
     * @return true or false if the index is greater than or equal to 0
     */
    @Override
    public boolean hasPrevious() {
        return index >= 0;
    }

    /**
     * This moves the iterator to the previous value
     * @return the previous value
     */
    @Override
    public E previous() {
        forward = false;
        index--;
        return list.get(index + 1);
    }

    /**
     * This adds a value to the iterator
     * @param value
     */
    @Override
    public void add(E value) {
        if(forward) {
            list.add(index + 1, value);
            index = index + 1;
        }
        if(!forward) {
            list.add(index + 1, value);
            index = index + 1;
        }
    }

    /**
     * This removes a value from the iterator
     */
    public void remove(){
        if(forward)
        {
            list.remove(index);
            index--;
        }
        else
            list.remove(index+1);
    }

    /**
     * This moves the iterator to the next value
     * @return the next value
     */
    public E next(){
        forward = true;
        return super.next();
    }
}
