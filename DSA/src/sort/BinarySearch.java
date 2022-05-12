package sort;

import list.List;

/**
 * Binary Search Algorithm of a sorted List.
 * For fast performance, the List should be an ArrayList
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class BinarySearch <E extends Comparable>{
    private List<E> list;
    public BinarySearch (List<E> list){
        this.list = list;
    }

    /**
     * @return a postion of the target, or -1 if not found
     */
    public int search(E target){
        return binSrch(0, list.size()-1, target);
    }

    /**
     * @return a position of the target from start thru end,
     * or -1 if not found
     */
    private int binSrch(int start, int end, E target){
        if (start>end)
            return -1; //target not found
        int mid = (start+end)/2;
        int cmp = target.compareTo(list.get(mid));
        if(cmp == 0)
            return mid; //found the target at mid
        if(cmp < 0)
            return binSrch(start, mid-1, target); // search left half
        return binSrch(mid+1, end, target); // search right half
    }
}
