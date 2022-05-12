package map;

import hash.HashTable;
import hash.TableIterator;
import list.Iterator;
import set.HashSet;
import set.Set;

/**
 * An implementation of the Map interface using a HashTable
 * of entries.
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class HashMap <K,V> implements Map<K,V>{

    // Inner class to define an Entry
    class Entry<K,V>{
        K key;
        V value;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        /**
         * @return true iff the given object is an Entry, and its
         * key is equal to the key of this Entry.
         */
        public boolean equals(Object obj){
            if(! (obj instanceof Entry))
                return false;
            Entry<K,V> entry = (Entry<K, V>) obj;
            return this.key.equals(entry.key);
        }

        public int hashCode(){
            return key.hashCode();
        }

        /**
         * @return the Entry as a String
         */
        @Override
        public String toString(){
            return key+"="+value;
        }
    } // End of inner class Entry

    HashTable<Entry<K,V>> table;

    public HashMap(){
        table = new HashTable<Entry<K,V>>();
    }
    public HashMap(int size){
        table = new HashTable<Entry<K,V>>(size);
    }

    /**
     * @param key
     * @return true iff this Map contains the given key.
     */
    @Override
    public boolean containsKey(K key) {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        return table.containsKey(entry);
    }

    /**
     * @param key
     * @return Thhe value corresponding to the given key,
     * or null if not in this Map.
     */
    @Override
    public V get(K key) {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        entry = table.get(entry);
        if (entry == null) // Not found in the table?
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
        Entry<K,V> newEntry = new Entry<K,V>(key,value), oldEntry = table.get(newEntry);
        if (oldEntry == null){
            table.put(newEntry); // key not found
            return null;
        }
        V oldValue = oldEntry.value;
        oldEntry.value = value; // Change the value
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
        Entry<K,V> entry = new Entry<K,V>(key,null), result = table.get(entry);
        if (table.remove(entry))
            return result.value;
        return null;
    }

    /**
     * Clear this Map
     */
    @Override
    public void clear() {
        table.clear();
    }

    /**
     * @return true iff this Map is empty
     */
    @Override
    public boolean isEmpty() {
        return table.isEmpty();
    }

    /**
     * @return the number of entries in this Map
     */
    @Override
    public int size() {
        return table.size();
    }

    /**
     * @return a Set of all the keys in this Map
     */
    @Override
    public Set<K> keySet() {
        Set<K> kSet = null;

        Iterator<Entry<K, V>> tableIterator = table.iterator();
        while (tableIterator.hasNext()){
            kSet.add(tableIterator.next().key);
        }
        return kSet;
    }
    /**
     * @return the HashMap as a String
     */
    @Override
    public String toString(){
        return table.toString();
    }

    /** @return true iff obj is a Map, and maps the same keys
     *  to the same values as this Map
     */
    public boolean equals(Object obj){
        if(!(obj instanceof Map))
            return false;
        Map<K, V> otherMap = (Map<K, V>) obj;

        TableIterator<K, V> tableIterator = (TableIterator<K, V>) table.iterator();
        while (tableIterator.hasNext()){
            K map = tableIterator.next();
            if(!map.equals(otherMap))
                return false;
        }
        return true;
    }

    /** @return a Set of all the keys in this Map which

     * correspond to the given value

     */

    public Set<K> getKeys(V value)

    {
        Set<K> keyset = this.keySet();
        Set<K> mapSet = new HashSet<>();
        V val = value;
        for (int i = 0; i < keyset.size(); i++) {
            if(this.get(keyset.iterator().next()).equals(val))
                mapSet.add(keyset.iterator().next());
        }
        return mapSet;

    }
}
