package setDriver;
import set.*;
import list.*;


/**
 * Test the implementations of Set.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class HwTreeSetDriver 
{
    public static void main(String[] args)
    {
        Set <Integer> values;
        values = new TreeSet <Integer> ();
        
        System.out.println (values);
        System.out.println ("removing from empty tree: " + values.remove(3));
        
        values.add (3);
        values.add (5);
        values.add (3);
        for (int j=0; j<200; j++)
        for (int i=0; i<20; i++)
            values.add (i/3);
        
        System.out.println ("size is " + values.size());   // should be 7
        System.out.println ("set is " + values);
        
        Set <String> names = new TreeSet <String> ();
      
        names.add ("joseph");
        names.add ("jim");
        names.add ("jack");
        names.add ("mary");
        names.add ("jimmy");
        names.add ("sue");
        names.add (new String ("mary"));
        
        System.out.println (names.size() + " names");   // should be 6
        System.out.println ("set of Strings is " + names);
        
        // Selectively remove long names
        System.out.println ("Removing long names");
        Iterator <String> itty;
        itty = names.iterator();
        while (itty.hasNext())
            {   if (itty.next().length() > 3)
                    itty.remove();
                }
     
        System.out.println ("set of Strings is " + names);
        
        names.add("james");
        names.add("flora");
        itty = names.iterator();
         for (int i=0; i<3; i++)
            {   System.out.println (itty.next()) ;      // flora, james, jim on separate lines
                    itty.remove();
                }
          System.out.println ("names is " + names);       //  names is [sue]
    }
}
