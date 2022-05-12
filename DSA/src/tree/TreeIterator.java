package tree;

import list.Iterator;
import queue.Queue;
import queue.QueueADT;

/**
 * An Iterator for a BinaryTree, using an InOrder transversal.
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class TreeIterator <E> implements Iterator<E> {

    QueueADT<E> queue = new Queue<E>();
    BinaryTree<E> tree;
    // Last value obtained by next()
    private E lastGotten;

    public TreeIterator(BinaryTree<E> tree){
        this.tree = tree;
        buildQ(tree);
    }

    /**
     * Build the queue of values using InOrder transversal
     */
    private void buildQ(BinaryTree<E> tree)
    {
        if (tree.isEmpty())
            return;
        buildQ(tree.getLeft());
        queue.add(tree.getValue());
        buildQ(tree.getRight());
    }

    /**
     * This checks if the TreeIterator has a next value
     * @return if the queue is empty
     */
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /**
     * This makes TreeIterator the next value in the tree
     * @return the value being removed
     */
    @Override
    public E next() {
        lastGotten = queue.peek();
        return queue.remove();
    }

    /**
     * This removes a value from the tree
     */
    @Override
    public void remove() {
        // Has 2 children or not removing the root?
        if(!tree.getLeft().isEmpty() && !tree.getRight().isEmpty() || !tree.getValue().equals(lastGotten))
        {
            tree = tree.remove(lastGotten);
            return;
        }
        E repl; // replacement value
        if (tree.getLeft().isEmpty())
            repl = getSuccessorvalue();
        else
            repl = getPredecessorValue();
        tree.remove(repl);
        tree.setValue(repl);
    }

    /**
     * @return sucessor of this BinarySearchTree.
     * Smallest value in family of right child
     */
    private E getSuccessorvalue(){
        BinaryTree<E> result = tree.getRight();
        while (!result.getLeft().isEmpty())
            result = result.getLeft();
        return result.getValue();
    }

    /**
     * @return predecessor of this BinarySearchTree.
     * Largest value in family of left child
     */
    private E getPredecessorValue(){
        BinaryTree<E> result = tree.getLeft();
        while (!result.getRight().isEmpty())
            result = result.getRight();
        return result.getValue();
    }

    @Override
    public boolean has2More() {
        return false;
    }
}
