package tree;

import list.*;

import javax.management.ObjectName;

/**
 * A BinaryTree whose left child's value is smaller, and
 * whose right child's value is greater than
 * the value of this BinarySearchTree.
 * All non-empty children are also BinarySearchTrees.
 * @author (Douglas McClure)
 * @version (July 2021)
 */
public class BinarySearchTree <E extends Comparable> implements BinaryTree<E>{

    BinaryTree<E> left = new EmptyBinarySearchTree<E>(), right = new EmptyBinarySearchTree<E>();
    E value;
    int size = 1; // size of the family

    //static fields needed for add and remove
    static boolean removed = false;
    static boolean added = false;

    public BinarySearchTree (E value){
        this.value = value;
    }

    /**
     * This adds the value to the tree
     * @param value
     * @return this tree
     */
    private BinaryTree<E> addHelper (E value){
        int cmp = this.value.compareTo(value);
        if(cmp < 0)  // add to family of right child
            right = right.add(value);
        if(cmp > 0) // add to family of left child
            left = left.add(value);
        if (added)
            size++;
        return this;
    }

    //Fill in accessor and other mutator methods

    /**
     * This gets the value of the tree
     * @return the value of the tree
     */
    @Override
    public E getValue() {
        return this.value;
    }

    /**
     * This gets the left child for this tree
     * @return the left child for this tree
     */
    @Override
    public BinaryTree<E> getLeft() {
        return this.left;
    }

    /**
     * This gets the right child for this tree
     * @return the right child for this tree
     */
    @Override
    public BinaryTree<E> getRight() {
        return this.right;
    }

    // Mutator methods

    /**
     * This sets the value
     * @param value
     */
    @Override
    public void setValue(E value) {
            this.value = value;
    }

    /**
     * Set the left child of this Binary Tree to the given Binary Tree.
     */
    @Override
    public void setLeft(BinaryTree<E> left) {
        this.left = left;
        size = left.size() + right.size() + 1;
    }

    /**
     * Set the right child of this Binary Tree to the given Binary Tree.
     */
    @Override
    public void setRight(BinaryTree<E> right) {
        this.right = right;
        size = left.size() + right.size() + 1;
    }

    /**
     * This checks if the tree is empty
     * @return true or false if size is greater than 0
     */
    @Override
    public boolean isEmpty() {
        if(size > 0)
            return false;
        return true;
    }

    /**
     * This returns the size of the tree
     * @return the size of the tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This gets the value of this tree
     * @param value
     * @return the value of the tree.
     */
    @Override
    public E get(E value) {
        int cmp = this.value.compareTo(value);
        if (cmp == 0)
            return this.value;  // found it
        if (cmp < 0)
            return right.get(value);  // Search right child
        return left.get(value);  // Search left child
    }

    /**
     * This adds an item to addhelper to add to the tree
     * @param value
     * @return the addhelper method to add the value either to the left or right
     */
    @Override
    public BinaryTree<E> add(E value) {
        added = false; // static field
        return addHelper (value);
    }

    /**
     *
     * @param obj
     * @return true or false if the tree contains the object.
     */
    @Override
    public boolean containsKey(Object obj) {
        int cmp = value.compareTo(obj);
        if (cmp == 0)
            return true;  // Found it
        if(cmp < 0)
            return right.containsKey(obj);  // Search right child
        return left.containsKey(obj);  // Search left child
    }

    /**
     * This removes the Object from this tree
     * @param obj
     * @return the remove helper method to remove the root
     */
    @Override
    public BinaryTree<E> remove(Object obj) {
        removed = false;
        return removeHelper(obj);
    }

    /**
     * This creates a new TreeIterator
     * @return a new TreeIterator
     */
    @Override
    public TreeIterator<E> iterator() {
        return new TreeIterator<E>(this);
    }

    /**
     * This returns the tree as a String
     * @return this tree as a string
     */
    public String toString(){
        TreeIterator<E> treeIterator = new TreeIterator<E>(this);
        String treeString = "[";
        if (isEmpty())
            return "[]";
        while (treeIterator.hasNext()){
            E thisTree = treeIterator.next();
            treeString += thisTree + ",";
        }
        char[] charArr = treeString.toCharArray();
        charArr[charArr.length - 1] = ']';

        return String.valueOf(charArr);
    }

    /**
     * This removes the object from the tree
     * @param obj
     * @return new tree / the only kid / this tree
     */
    public BinaryTree<E> removeHelper(Object obj){
        int cmp = value.compareTo(obj);
        if (cmp == 0){ // removing the root
            removed = true;
            List<BinaryTree<E>> kids = children();
            if(kids.size() == 0) // no children
                return new EmptyBinarySearchTree<E>();
            if(kids.size() == 1)
                return kids.get(0);
            // Two children
            BinaryTree<E> sucessor = getSucessor();
            setValue(sucessor.getValue());
            return this;
        }
        if(cmp > 0)
            left = left.remove(obj); // Remove from family if left child.
        if (cmp < 0)
            right = right.remove(obj); // Remove from family if right child.
        if(removed)
            size--;
        return this;
    }

    /**
     * @return a list of this BinarySearchTree's children
     */
    private List<BinaryTree<E>> children(){
        List<BinaryTree<E>> result = new ArrayList<BinaryTree<E>>();
        if (! left.isEmpty())
            result.add(left);
        if (! right.isEmpty())
            result.add(right);
        return result;
    }

    /**
     * @return the successor of this BinaryTree.
     * Successor is the smallest value in the family of the right child
     */
    private BinaryTree<E> getSucessor(){
        BinaryTree<E> temp = right;
        while (!temp.getLeft().isEmpty())
            temp = temp.getLeft();
        return temp;
    }
}
