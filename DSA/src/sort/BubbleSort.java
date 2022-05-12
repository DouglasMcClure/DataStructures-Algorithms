package sort;

import list.List;

public class BubbleSort <E extends Comparable> implements Sorter<E>{
    List<E> list;

    /**
     * @param list of values to be sorted.
     * Post: Items in the list will be arranged in increasing order
     */
    @Override
    public void sort(List<E> list) {
        this.list = list;
        boolean isSorted = false;
            for (int index = 0; index < list.size() - 1; index++) {
                while (!isSorted) {
                    isSorted = true;
                    for (int i = 0; i < list.size() - index - 1; i++) {
                        if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                            swap(i, i + 1);
                            isSorted = false;
                        }
                    }
                }
            }
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
