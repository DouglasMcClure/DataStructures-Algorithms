package sort;

import list.List;

/**
 * Sort a given List using HeapSort algorithm
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class HeapSort <E extends Comparable> implements Sorter<E>{
    List<E> list;
    @Override
    public void sort(List<E> list) {
        this.list = list;

        int last = list.size() - 1;
        heapify(0); // Make the list a heap
        while (last > 0){
            swap (0, last);
            last--;
            percDown(0, last);
        }
    }

    /**
     * Make the part of the list beginning at root into a heap
     */
    private void heapify(int root){
        int max  = list.size()-1;
        if(root >= max)
            return; // base case
        heapify(root*2+1); // heapify left child
        heapify(root*2+2); // heapify right child
        percDown(root,max); // percDown the root.
    }

    /**
     * Move the root down, so as to make this part of
     * the list into a heap. Do not go beyond max.
     */
    private void percDown(int root, int max){
        int bc = biggerChild(root,max);
        while (2*root+1 <= max // has a child?
            && greater(bc, root)) // and bigger child
        {  // greater than root
            swap(root,bc); // root moves down
            root = bc; // to bigger child
            bc = biggerChild(root,max);
        }
    }

    /**
     * @return the position of the bigger child of
     * given root position.
     * Pre: root has a left child
     */
    private int biggerChild(int root, int max){
        int left = 2*root+1,
                right = 2*root+2;
        if (right > max) // Has no right child
            return left;
        if (greater(left,right)) // Compare child values
            return left;
        return right;
    }
    /**
     * @return true iff the value at position p1 is greater than the value at position p2.
     */
    private boolean greater(int p1, int p2){
        int cmp = list.get(p1).compareTo(list.get(p2));
        return cmp > 0;
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
