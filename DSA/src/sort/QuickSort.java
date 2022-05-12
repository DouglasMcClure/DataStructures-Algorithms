package sort;

import list.List;

/**
 * Implementation of the QuickSort algorithm
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class QuickSort <E extends Comparable> implements Sorter<E>{
    List<E> list;

    @Override
    public void sort(List<E> list) {

        this.list = list;
        qSort(0, list.size()-1);

    }

    private void qSort(int start, int end){
        int p;
        if(start >= end) //Base case
            return;
        p = partition (start, end);
        qSort(start, p-1);  // Left part
        qSort(p+1, end); // Right part
    }

    /**
     * Partition the values from start to end about a pivot value.
     * @return the pivot position.
     */
    private int partition(int start, int end){
        int p = (start+end)/2; //pivot position
        E pivot = list.get(p); //pivot value

        for (int i = p; i <= end; i++) {
            if (pivot.compareTo(list.get(i))>0){
                list.set(p,list.get(i));
                p++;
                list.set(i, list.get(p));
            }
        }
        list.set(p, pivot); // Put pivot back into the list.

        return p;

    }
}
