package set;

import list.Iterator;
import tree.BinaryTree;
import tree.EmptyBinarySearchTree;
import tree.TreeIterator;

/**
 * An implementation of Set, using a BinaryTree
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class TreeSet <E extends Comparable> implements Set<E>{
    BinaryTree<E> tree = new EmptyBinarySearchTree<>();
    int size = 0;

    /**
     * @param obj
     * @return true iff this Set contains the given
     * object.
     */
    @Override
    public boolean contains(Object obj) {
        return tree.containsKey(obj);
    }

    /**
     * Add the given value to this Set, if not already in
     * this Set.
     *
     * @param value
     * @return true iff it was added.
     */
    @Override
    public boolean add(E value) {
        if(tree.containsKey(value))
            return false; // no duplicates
        tree = tree.add(value);
        size++;
        return true;
    }

    /**
     * Remove the given Object from this Set, if possible.
     *
     * @param obj
     * @return true iff it was removed.
     */
    @Override
    public boolean remove(Object obj) {
        if(! contains(obj))
            return false;
        tree = tree.remove(obj);
        size--;
        return true;
    }

    /**
     * @return an Iterator for this Set
     */
    @Override
    public Iterator<E> iterator() {
        return tree.iterator();
    }

    /**
     * Clear this Set
     */
    @Override
    public void clear() {
        tree = new EmptyBinarySearchTree<>();
        size = 0;
    }

    /**
     * @return true iff this Set is empty
     */
    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    /**
     * @return the number of values in this Set
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true iff obj is a Set which contains the same values as
     * this Set, and only those values which are in this Set
     */
    public boolean equals (Object obj){
        if(!(obj instanceof Set))
            return false;
        Set set = (Set) obj;
        if(this.size() != set.size())
            return false;
        TreeIterator<E> treeIterator = tree.iterator();
        while (treeIterator.hasNext()){
            E nextObject = treeIterator.next();
            if(!(set.contains(nextObject)))
                return false;
        }
        return true;
    }

    /**
     * @return the TreeSet as a String
     */
    public String toString(){
        return tree.toString();
    }
}
