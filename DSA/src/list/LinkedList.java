package list;

/**
 * An implementation of the List interface,
 * using references instead of an array.
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class LinkedList<E> implements List<E> {

    int size = 0;
    //Dummy head node
    Node<E> head = new Node<E> (null, null, null);
    Node<E> tail = new Node<E> (null, null, head);
    private Node<E> ref;



    /**
     * Sets the value of the index to the reference node
     * Post: ref refers to the node at the given index
     * Pre: 0 <= index < size
     * @param index
     */
    private void setRef(int index){
        int closerTo = size / 2;
        if(index < closerTo) {
            ref = head.next;
            for (int i = 0; i < index; i++) {
                ref = ref.next;
            }
        }
        else{
            ref = tail.prev;
            for (int i = size - 1; i > index; i--) {
                ref = ref.prev;
            }
        }
    }

    //Constructor
    public LinkedList(){
        head.next = tail;
    }

    /**
     * This gets the value in the list at the given index
     * @param index
     * @return the value of the reference node
     */
    @Override
    public E get(int index) {
        setRef(index);
        return ref.value;
    }

    /**
     * This sets the value to a specific index in the list
     * @param index
     * @param value
     * @return returns the reference value of the list
     *         before setting value equal to the reference value
     */
    @Override
    public E set(int index, E value) {
        setRef(index);
        E result = ref.value;
        ref.value = value;
        return result;
    }

    /**
     * This adds the value to the list
     * @param value
     */
    @Override
    public void add(E value) {
        Node<E> temp = new Node<E>(value, tail, tail.prev);
        tail.prev.next = temp;
        tail.prev = temp;
        size++;
    }

    /**
     * This adds the value to the list at a specific index
     * @param index
     * @param value
     */
    @Override
    public void add(int index, E value) {
        setRef(index);
        Node<E> temp = new Node<E> (value, ref, ref.prev);
        ref.prev.next = temp;
        ref.prev = temp;
        size++;
    }

    /**
     * This removes a value at a specific index in the list
     * @param index
     * @return returns the value of the
     *         reference node/object being removed from the list
     */
    @Override
    public E remove(int index) {
        setRef(index);
        ref.next.prev = ref.prev;
        ref.prev.next = ref.next;
        size--;
        return ref.value;
    }

    /**
     * This gets the size of the list
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This clears the list
     */
    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * This checks if the list is empty
     * @return true or false if the size is equal to 0/empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This gets the index of the given object inside this list
     * @param obj
     * @return the index of the object or -1 if the object is not found
     */
    @Override
    public int indexOf(Object obj) {
        Node<E> current = head.next;
        for (int i = 0; i < size; i++) {
            if (obj.equals(current.value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * This gets the index of the last object in the list
     * @param obj
     * @return if the object given is the last object if so return the index else return -1
     */
    @Override
    public int indexOfLast(Object obj) {
        Node<E> current = tail.prev;
        for (int i = size - 1; i > -1; i--) {
            if(obj.equals(current.value))
                return i;
            else
                current = current.prev;
        }
        return -1;
    }

    /**
     * Checks if the list contains this object
     * @param obj
     * @return true or false if the list contains this object
     */
    @Override
    public boolean contains(Object obj) {
        if(indexOf(obj) != -1){
            return true;
        }
        else
            return false;
    }

    /**
     * Checks if the object was removed
     * @param obj
     * @return true or false if the object is inside the list
     */
    @Override
    public boolean remove(Object obj) {
        if(contains(obj)) {
            remove(indexOf(obj));
            return true;
        }else
            return false;
    }

    /**
     * Checks if the object is equal to another object in the list
     * @param obj
     * @return true or false if the object is equal to the other object in the list
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof List)) {

            return false;

        }
        List list = (List) obj;

        if (list.size() != size()) {

            return false;

        }

        Iterator thisIterator = iterator();

        Iterator otherIterator = list.iterator();

        while (thisIterator.hasNext()) {

            Object thisElement = thisIterator.next();

            Object otherElement = otherIterator.next();

            if (!thisElement.equals(otherElement)) {

                return false;

            }
        }

        return true;
    }

    /**
     * This creates a RefIterator
     * @return a new RefIterator for this list
     */
    @Override
    public Iterator<E> iterator() {
        return new RefIterator<E>(this);
    }

    /**
     * This creates a RefListIterator
     * @return a new RefListIterator for this list
     */
    @Override
    public ListIterator<E> listIterator() {
        return new RefListIterator<E>(this);
    }

    /**
     * This creates a RefListIterator at a specific starting position
     * @return a new RefListIterator for this list at a specific starting position
     */
    @Override
    public ListIterator<E> listIterator(int start) {
        return new RefListIterator<E>(this, start);
    }

    /**
     * Barebones method for addall method
     * @param list
     */
    @Override
    public void addAll(List<E> list) {

    }

    /**
     * Makes the list into a String
     * @return the list as a String
     */
    public String toString(){
        Node<E> current = head;
        String result = "";
        if(isEmpty()){
            return "[]";
        }
        else {
            result += "[";
            for (int i = 0; i < size; i++) {
                current = current.next;
                i++;
                if (i < size) {
                    result += current.value + ",";
                    i--;
                } else
                    result += current.value + "]";

            }
            return result;
        }
    }
}
