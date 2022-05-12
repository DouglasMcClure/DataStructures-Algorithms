package sort;

import list.List;
import list.ListIterator;

/**
 * Sort a LinkedList in time 0(n^2), using a ListIterator.
 * This will be slow for an ArrayList.
 * @author (Douglas McClure)
 * @version (July 2021)
 */
public class BubbleSortLinked <E extends Comparable> implements Sorter<E>{
    List<E> list;

    /**
     * Post: Items in the list will be arranged in increasing order
     * @param list of values to be sorted.
     */
    @Override
    public void sort(List<E> list) {
        this.list = list;
        E left, right; //Neighboring Values
        ListIterator<E> itty;

            for (int i = 0; i < list.size(); i++) {
                itty = list.listIterator();
                right = itty.next();
                for (int j = 0; j < list.size() - i - 1; j++) {
                    left = right;
                    right = itty.next();
                    if (left.compareTo(right) > 0) {
                        itty.remove();
                        itty.previous();
                        itty.add(right);
                        right = itty.next();
                    }
                }
            }
    }
}
