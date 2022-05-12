package listDriver;

import list.*;

/**
 * Test the ListIterator classes 
 * 
 * @author (sdb) 
 * @version (Feb 2019)
 */
public class HomeworkListIterator
{
/**
 *  This main method tests ListIterators
 */
    public static void main (String[] args)
    {   List<Character> letters = new LinkedList <Character> ();
        System.out.println ("Testing ListIterators\n");
        System.out.println ("Testing LinkedList");
        testListIterator (letters);
        System.out.println ("Testing ArrayList");
        letters = new ArrayList <Character> ();
        testListIterator (letters);
    }

    private static void testListIterator (List<Character> letters)
    {   letters.add ('a');
        letters.add ('b');
        letters.add ('c');
        letters.add ('d');
        ListIterator <Character> itty = letters.listIterator();
        System.out.println (itty.next());   // a
        System.out.println (itty.next());   // b
        System.out.println (itty.previous());   // b
        itty.remove();                      // remove the b
        System.out.println (letters);       // [a, c, d]
        itty = letters.listIterator();
        while (itty.hasNext())              // print forward
            System.out.println (itty.next());   
        System.out.println();
        itty = letters.listIterator (letters.size());  // start at end
        while (itty.hasPrevious())              // print in reverse order
            System.out.println (itty.previous());
    }


    }


