package hash;

import list.ArrayList;
import list.Iterator;
import list.LinkedList;
import list.List;

/**
 * Provide quick acces to data values, using ArrayList of LinkedLists.
 * Performance is improved when the client's hashCode() minimizes collisions.
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class HashTable <K>{
    List<List<K>> lists;
    // Maximum legnth for a LinkedList:
    private static final int MAX = 5;
    int size = 0;

    public HashTable(int cap){
        lists = new ArrayList<List<K>>(cap);
        for (int i = 0; i < cap; i++) {
            lists.add(new LinkedList<K>());
        }
    }

    /**
     * Use this constructor for small HashTables
     * Default ArrayList size is 10
     */
    public HashTable(){
        this(10);
    }

    /**
     * @return a valid index to the ArrayList, using the client's hashCode() method
     */
    private int getCode(Object obj){
        int result = obj.hashCode();
        result = Math.abs(result);
        result = result % lists.size(); // valid index
        return result;
    }

    /**
     * @return true iff the given obj is in this HashTable.
     */
    public boolean containsKey(Object obj){
        int code = getCode(obj);
        return lists.get(code).contains(obj);
    }

    /**
     * Add the given key to this HashTable
     */

    public void put (K key){
        int code = getCode(key);
        lists.get(code).add(key);
        if (lists.get(code).size() > MAX) // too long?
            rehash();
    }

    /**
     * Allocate a new ArrayList, instantiate the
     * LinkedLists, and add all values to the new
     * HashTable.
     */
    private void rehash(){
        List<List<K>> newTable = new ArrayList<List<K>>(lists.size() *2);
        for (int i = 0; i < lists.size()*2; i++) {
            newTable.add(new LinkedList<K>());
        }
        Iterator<K> itty = iterator();
        while (itty.hasNext()){
            K value = itty.next();
            int index = Math.abs(value.hashCode())
                    % newTable.size();
            newTable.get(index).add(value);
        }
    }

    /**
     * @return a matching key from this HashTable,
     * or null if not found.
     */
    public K get(K key){
        int code = getCode(key);
        List<K> list = lists.get(code);
        int index = list.indexOf(key);
        if (index < 0)
            return null; // key not found
        return list.get(index);
    }

    public int getPos(Object obj){
        int code = getCode(obj);
        List list = lists.get(code);
        int index = list.indexOf(obj);
        return index;
    }

    /**
     * Remove the given obj from this HashTable, if
     * possible
     * @return true iff it was removed.
     */
    public boolean remove(Object obj){
        int code = getCode(obj);
        List<K> list = lists.get(code);
        if(list.remove(obj)){
            size--;
            return true;
        }
        return false;
    }
    /**
     * @return the number of keys in this HashTable
     */
    public int size(){
        return size;
    }
    /**
     * Clear this HashTable
     */
    public void clear(){
        int listLength = lists.size();
        lists.clear();
        for(int i =0; i<listLength;i++)
            lists.add(new LinkedList<>());
        size = 0;
    }
    /**
     * @return true iff this HashTable is empty
     */
    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    public String toString(){
        if (size == 0) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        str.append("[");
        boolean addComma = false;
        for (int i = 0; i < lists.size(); i++) {
            List<K> list = lists.get(i);
            if (!list.isEmpty()) {
                if (addComma) str.append(",");

                str.append(list.toString().replace("]","").replace("[",""));
                addComma = true;
            }
        }
        str.append("]");
        return str.toString();
    }

    public Iterator<K> iterator() {
        return new TableIterator<>(this);
    }
}
