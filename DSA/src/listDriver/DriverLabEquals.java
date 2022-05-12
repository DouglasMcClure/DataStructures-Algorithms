package listDriver;
import list.*;

/**
 * Data Structures and Algorithms.
 *
 *Compare lists for equality
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class DriverLabEquals
{   static final int MAX = 1000000;
    public static void main(String[] args)
    {
   System.out.println ("Testing the equals(Object) method for lists");
   List <String> strings1 = new LinkedList <String>();
   List <String> strings2 = new ArrayList <String>();
   if (! strings1.equals(strings2))
        System.err.println ("Error");
   if (! strings2.equals(strings1))
        System.err.println ("Error");
        
   init(strings1);
   init(strings2);
   testEquals(strings1, strings2);
   System.out.println ("Testing finished");
}

private static void init(List<String> list)
{   java.util.Random rand = new java.util.Random(10);  //Random number generator
   
    for (int i=0; i<MAX; i++)
        list.add ("str" + i);
}

private static void testEquals (List <String> l1, List <String> l2)
{   if (l1.equals("l1"))
        System.err.println ("Error in equals(Object)");
    if (l2.equals("l2"))
        System.err.println ("Error in equals(Object)");
    if (! l1.equals(l2))
        System.err.println ("Error in equals(Object)");
    if (! l2.equals(l1))
        System.err.println ("Error in equals(Object)");
    l1.add ("Mary");
    l2.add (new String ("Mary"));
    if (! l1.equals(l2))
        System.err.println ("Error in equals(Object)");
    if (! l1.equals(l2))
        System.err.println ("Error in equals(Object)");
    l1.add("Joe");
    l1.add("joe");
    l2.add("joe");
    l2.add("joe");
    if (l1.equals(l2))
        System.err.println ("Error in equals(Object)");
    if (l1.equals(l2))
        System.err.println ("Error in equals(Object)");
    
}
    
}
