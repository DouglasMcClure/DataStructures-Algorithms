package set;

import hash.HashTable;
import list.Iterator;

/**
 * An implementation of Set, using a HashTable
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class HashSet <E> implements Set<E>{
    HashTable<E> table = new HashTable<E>();

    @Override
    public boolean contains(Object obj) {
        return table.containsKey(obj);
    }

    @Override
    public boolean add(E value) {
        if(table.containsKey(value))
            return false; // no duplicates
        table.put(value);
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        return table.remove(obj);
    }

    @Override
    public Iterator<E> iterator() {
        return table.iterator();
    }

    /**
     * Clear this Set
     */
    @Override
    public void clear() {
        table.clear();
    }

    /**
     * @return true iff this Set is empty
     */
    @Override
    public boolean isEmpty() {
        return table.isEmpty();
    }

    /**
     * @return the number of values in this Set
     */
    @Override
    public int size() {
        return table.size();
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
        Iterator<E> iterator = table.iterator();
        while (iterator.hasNext()){
            E nextObject = iterator.next();
            if(!set.contains(nextObject))
                return false;
        }
        return true;
    }

    /**
     * @return the HashSet as a String
     */
    public String toString(){
        return table.toString();
    }

    /** @return the Set of values which this Set has in

     * common with otherSet

     */

    public Set<E> intersection (Set<E> otherSet)

    {

        Iterator<E> setIterator = otherSet.iterator();
        Set<E> thisSet = new HashSet<>();
        while (setIterator.hasNext()) {
            E val = setIterator.next();
            if (this.contains(val)) {
                thisSet.add(val);
            }
        }
        return thisSet;

    }
}
