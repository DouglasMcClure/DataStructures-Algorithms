package list;

/**
 * A Node stores one value in a LinkedList and
 * a reference to the next Node in the List.
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class Node <E>{
    E value;
    Node<E> next;
    Node<E> prev;

    //Constructor
    Node(E value, Node<E> next, Node<E> prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
