package tree;

import list.Iterator;

/**
 * A BinaryTree which has no value and no children
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class EmptyBinarySearchTree <E extends Comparable> implements BinaryTree<E>{

    @Override
    public E getValue() {
        return null;
    }

    @Override
    public BinaryTree<E> getLeft() {
        return null;
    }

    @Override
    public BinaryTree<E> getRight() {
        return null;
    }

    @Override
    public void setValue(E value) {

    }

    @Override
    public void setLeft(BinaryTree<E> left) {

    }

    @Override
    public void setRight(BinaryTree<E> right) {

    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E get(E value) {
        return null;
    }

    @Override
    public BinaryTree<E> add(E value) {
        BinarySearchTree.added = true;
        return new BinarySearchTree<E> (value);
    }

    @Override
    public boolean containsKey(Object obj) {
        return false;
    }

    @Override
    public BinaryTree<E> remove(Object obj) {
        return this;
    }

    @Override
    public TreeIterator<E> iterator() {
        return null;
    }

    public String toString(){
        return "";
    }
}
