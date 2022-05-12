package sort;

import list.List;

/**
 * Implementation of the Selection Sort Algorithm
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class SelectionSort <E extends Comparable> implements Sorter<E>{

    List<E> list;


    /**
     * @param list of values to be sorted.
     * Post: Items in the list will be arranged in
     * increasing order
     */
    @Override
    public void sort(List<E> list) {
            this.list = list;
        for (int index = 0; index < list.size()-1; index++) {
            swap(posSmallest(index), index);
        }
    }

    /**
     * @return position of the smallest item from the given start position to the end of the list.
     */
     private int posSmallest(int start){
        int result = start;
         for (int i = start+1; i < list.size(); i++) {
             if(list.get(i).compareTo(list.get(result))<0)
                 result = i;
         }
         return result;
     }

    /**
     * Exchange the items at the given positions in the list
     */
    private void swap(int x, int y){
        E temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y,temp);
    }
}
