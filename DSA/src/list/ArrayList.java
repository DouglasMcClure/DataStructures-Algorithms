package list;

/**
 * An implementation of the List interface,
 * using an array to store the values.
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class ArrayList <E> implements List<E> {

    int size = 0;
    E[] values;

    //Constructors
    public ArrayList()
    {
        this (10); //default array size
    }

    public ArrayList (int cap){
        values = (E[]) new Object[cap];
    }

    // Copy Constructor
    public ArrayList(List<E> other){
        this(other.size());
        for (int i = 0; i < other.size(); i++) {
            add(other.get(i));
        }
    }
    /**
     * This gets the value at the specified index inside the arraylist.
     * @param index
     * @return the value at that index in the arraylist.
     */
    @Override
    public E get(int index) {
        return values[index];
    }

    /**
     * This sets the value at the specified index inside the arraylist.
     * @param index
     * @param value
     * @return the value of the index inside the arraylist.
     */
    @Override
    public E set(int index, E value) {
        E result = values[index];
        values[index] = value;
        return result;
    }

    /**
     * This adds the value to the arraylist.
     * @param value
     */
    @Override
    public void add(E value) {
        add(size, value);
    }

    /**
     * This adds a value at the specified index to the arraylist.
     * @param index
     * @param value
     */
    @Override
    public void add(int index, E value) {
        // Is the array full?
        if (values.length == size)
            alloc();  // allocate a bigger array
        // Make room for the insertion
        for (int i = size; i > index; i--)
            values[i] = values[i-1];
        values[index] = value;
        size++;
    }

    /**
     * This removes a value at the specified index in the arraylist.
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        E result = values[index];
        for (int i = index; i < size-1; i++)
            values[i] = values[i+1];
        size--;
        return result;
    }

    /**
     * This gets the size of the arraylist
     * @return the size of the arraylist
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This clears the arraylist
     */
    @Override
    public void clear() {
        size = 0;
        values = (E[]) new Object[10];
    }

    /**
     * This checks if the arraylist is empty
     * @return true or false if size equals 0
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This gets the index of the specified object inside the arraylist.
     * @param obj
     * @return the index or -1 if nothing is found
     */
    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < size -1; i++) {
            Object otherObject;
            otherObject = values[i];

            if (otherObject.equals(obj))
                return i;
        }
        
        return -1;
    }

    /**
     * Barebones method.
     * @param obj
     * @return 0
     */
    @Override
    public int indexOfLast(Object obj) {
        return 0;
    }

    /**
     * Checks if the arraylist contains the object.
     * @param obj
     * @return true or false if the object is in the arraylist
     */
    @Override
    public boolean contains(Object obj) {
        if(indexOf(obj) != -1)
            return true;
        return false;
    }

    /**
     * This checks if the object has been removed
     * @param obj
     * @return true or false if the object is in the arraylist
     *         if true remove the object
     */
    @Override
    public boolean remove(Object obj) {
        if(contains(obj)) {
            remove(indexOf(obj));
            return true;
        }
        else
            return false;
    }

    /**
     * This creates an iterator returning a new ArrayIterator to iterate through this Arraylist
     * @return new ArrayIterator to iterate through this Arraylist
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(this);
    }

    /**
     * This creates an iterator returning a new ArrayListIterator to iterate through this Arraylist
     * @return new ArrayListIterator to iterate through this Arraylist
     */
    @Override
    public ListIterator<E> listIterator() {
        return new ArrayListIterator<E>(this);
    }

    /**
     * This creates a list iterator returning a new ArrayListIterator to iterate through this Arraylist
     * @param start iterating at given start position.
     * Initial call to previous() returns the value
     * @return new ArrayListIterator that has the specified start for this Arraylist.
     */
    @Override
    public ListIterator<E> listIterator(int start) {
        return new ArrayListIterator<E>(this, start);
    }

    /**
     * This adds all the items to this Arraylist.
     * @param list
     */
    @Override
    public void addAll(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    /**
     * This checks if the object is equal to the other object
     * @param obj
     * @return true or false if the object is equal to the other object
     *         or if it even is an instance of a list
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof List))
        {
            return false;
        }
        List list = (List)obj;

        if (list.size() != size())
        {
            return false;
        }

        Iterator thisIterator = iterator();

        Iterator otherIterator = list.iterator();

        while(thisIterator.hasNext())
        {

            Object thisElement =  thisIterator.next();

            Object otherElement = otherIterator.next();

            if(!thisElement.equals(otherElement))
            {
                return false;
            }
        }

        return true;
    }

    //Allocate space in array
    private void alloc(){
        E[] tempArray = (E[]) new Object[2*values.length];
        for (int i = 0; i < size; i++)
            tempArray[i] = values[i];
        values = tempArray;
    }

    /**
     * @return this List as a String
     */
    public String toString(){
        if(isEmpty())
            return "[]";
        
        String list = "[";
        for (int i = 0; i < size; i++) {
            list += values[i] + ",";
        }
        char[] charArr = list.toCharArray();
        charArr[charArr.length - 1] = ']';

        return String.valueOf(charArr);
    }
}
