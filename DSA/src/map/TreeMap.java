package map;

import set.Set;
import tree.BinaryTree;
import tree.EmptyBinarySearchTree;
import tree.TreeIterator;

/**
 * An implementation of the Map interface using a Binary Tree of entries
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class TreeMap <K extends Comparable, V> implements Map<K,V>{

    // Inner class to define an Entry
    class Entry<K extends Comparable,V> implements Comparable <Entry<K,V>>{
        K key;
        V value;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        /**
         * @return a positive int if this Entry is greater than other,
         * return 0 if this Entry equals other,
         * return a negative int if this Entry is less than other.
         */
        @Override
        public int compareTo(Entry<K, V> other) {
            return key.compareTo(other.key);
        }

        /**
         * @return the Entry as a String
         */
        @Override
        public String toString(){
            return key+"="+value;
        }
    } // End of inner class Entry

    BinaryTree <Entry<K,V>> tree = new EmptyBinarySearchTree<>();
    int size = 0;


    /**
     * @param key
     * @return true iff this Map contains the given key.
     */
    @Override
    public boolean containsKey(K key) {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        return tree.containsKey(entry);
    }

    /**
     * @param key
     * @return Thhe value corresponding to the given key,
     * or null if not in this Map.
     */
    @Override
    public V get(K key) {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        entry = tree.get(entry);
        if (entry==null) // Not found in the tree?
            return null;
        return entry.value; // Yes, return the value
    }

    /**
     * If the given key is already in this Map,
     * change its corresponding value to the given
     * value. If not, include the key-value pair in
     * this Map.
     *
     * @param key
     * @param value
     * @return the old value, or null if not in this Map.
     */
    @Override
    public V put(K key, V value) {
        Entry<K,V> newEntry = new Entry<K,V>(key,value), oldEntry = tree.get(newEntry);
        if (oldEntry == null){ // Key not found in the tree?
            tree = tree.add(newEntry);
            size++;
            return null;
        }
        V oldValue = oldEntry.value;
        oldEntry.value = value;
        return oldValue;
    }

    /**
     * Remove the key-value pair having the given key
     * from this Map.
     *
     * @param key
     * @return the value, or null if not in this Map
     */
    @Override
    public V remove(K key) {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        entry = tree.get(entry);
        if (entry==null)
            return null;
        size--;
        tree=tree.remove(entry);
        return entry.value;
    }

    /**
     * Clear this Map
     */
    @Override
    public void clear() {
        tree = new EmptyBinarySearchTree<>();
        size = 0;
    }

    /**
     * @return true iff this Map is empty
     */
    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    /**
     * @return the number of entries in this Map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return a Set of all the keys in this Map
     */
    @Override
    public Set<K> keySet() {
        Set<K> kSet = null;

        TreeIterator<Entry<K, V>> treeIterator = tree.iterator();
        while (treeIterator.hasNext()){
            kSet.add(treeIterator.next().key);
        }
        return (Set<K>) kSet;
    }

    /**
     * @return the Map as a String
     */
    @Override
    public String toString(){
        return tree.toString();
    }

    /** @return true iff obj is a Map, and maps the same keys
     *  to the same values as this Map
     */
    public boolean equals(Object obj){
        if(!(obj instanceof Map))
            return false;
        Map<K, V> otherMap = (Map<K, V>) obj;

        TreeIterator<Entry<K, V>> treeIterator = tree.iterator();
        while (treeIterator.hasNext()){
            Entry<K, V> map = treeIterator.next();
            if(!map.equals(otherMap))
                return false;
        }
        return true;
    }
}
