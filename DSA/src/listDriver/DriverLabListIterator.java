package listDriver;

import list.*;
  
/**
 * Test Iterators and ListIterators.
 * 
 * @author (sdb) 
 * @version (2020) 
 */
public class DriverLabListIterator
{
    public static void main(String[] args)
    {   
    List <String> names;
    System.out.println ("Testing Iterators for ArrayLists");
    testIterators (new ArrayList<String>());
    System.out.println ("Testing Iterators for LinkedLists");
    testIterators (new LinkedList<String>());
    System.out.println();
    

     System.out.println ("Testing ListIterators for ArrayLists");
     testListIterators (new ArrayList<String> ());
    System.out.println ("\nTesting ListIterators for LinkedLists");
    testListIterators (new LinkedList<String> ());
}

    private static void testIterators (List <String> names)
    {   names.add ("jim");
        names.add ("mary");
        names.add ("joe");
        names.add ("sue");
        Iterator <String> itty = names.iterator();
        while (itty.hasNext())
            if (itty.next().length() > 3)
                itty.remove();
        System.out.println (names);     // should be [jim, joe, sue]
    }
    
   private static void testListIterators (List<String> names)
   {
       
   names.add ("jim");
   names.add ("mary");
   names.add ("joe");
   names.add ("sue");
   System.out.println (names);
    ListIterator <String> itty = names.listIterator();
   System.out.println ("Test the add method:");       
    System.out.println (itty.next());       // "jim"
    System.out.println (itty.next());       // "mary"
    itty.add ("harry");
       System.out.println(itty.has2More());
    System.out.println (names);             // [jim, mary, harry, joe, sue]
    System.out.println (itty.next());       // "joe"
    itty.add ("bill");
    System.out.println (itty.previous());   // bill
    itty.add ("james");                   
    System.out.println (itty.next());       // bill
    System.out.println (names);             // [jim, mary, harry, joe, james, bill, sue]
    if (names.size() != 7)
        System.err.println ("Error in ListIterator");

    System.out.println(itty.has2More());
}

    }   