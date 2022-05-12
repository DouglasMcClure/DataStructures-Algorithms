package setDriver;
import set.*;
import list.*;


/**
 * Test the implementation of TreeSet.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class HwHashSetDriver
{
    public static void main(String[] args)
    {
        Set <Integer> values;
        values = new HashSet <Integer> ();
        
        if (!values.isEmpty())
            System.err.println  ("Error in isEmpty ");
            
        values.add (3);
        values.add (5);
        values.add (3);
        
        // No news is good news
        
        if (values.size() != 2)
            System.err.println  ("Error in size ");
         if (values.isEmpty())
            System.err.println  ("Error in isEmpty ");
            
        for (int j=0; j<5; j++)
             values.add (j * 10);
         
        if (values.contains (15))
            System.err.println ("Error in contains ");
        if (!values.contains (20))
            System.err.println ("Error in contains ");  
            
        if (values.remove (2))
            System.err.println ("Error in remove ");  
        if (!values.remove (0))
            System.err.println ("Error in remove ");  
        if (values.size() != 6)
            System.err.println  ("Error in size or remove ");
        
        Iterator<Integer> itty = values.iterator();
        while (itty.hasNext())
            if (itty.next() % 2 == 1)
                itty.remove();              // remove odd numbers
           
        if (values.size() != 4)
            System.err.println  ("Error in size or iterator ");
        
        values.clear();
        if (!values.isEmpty())
            System.err.println  ("Error in clear or isEmpty ");
        
        values.add (17);
         if (values.size() != 1)
            System.err.println  ("Error in size or clear ");
        
        System.out.println ("Testing complete");
        
    }
}
