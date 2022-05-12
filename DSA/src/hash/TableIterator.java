package hash;

import list.Iterator;

/**
 * A TableIterator permits the client to iterate thru a HashTable.
 * @author (DouglasMcClure)
 * @version (August 2021)
 */
public class TableIterator <K, V> implements Iterator<K>{
    HashTable<K> table;
    int index = 0; // Current ArrayList index
    Iterator<K> itty; // For a LinkedList
    TableIterator(HashTable<K> table){
        this.table = table;
        setItty(index);
    }

    /**
     * Set the iterator to the LinkedList at the given
     * index in the ArrayList.
     */
    private void setItty(int index){
        itty = table.lists.get(index).iterator();
    }

    /**
     * @return the index of the next non-empty LinkedList,
     * or -1 if none.
     */
    private int nextList(){
        for (int i = index+1; i < table.lists.size(); i++) {
            if (!table.lists.get(i).isEmpty())
                return i;
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        if(itty.hasNext())
            return true;
        return nextList() > 0;
    }

    @Override
    public K next() {
        if(!itty.hasNext()){
            index = nextList();
            setItty(index); // next non-empty list
        }
        return itty.next();
    }

    @Override
    public void remove() {
        itty.remove();
        table.size--;
    }

    @Override
    public boolean has2More() {
        return false;
    }
}
