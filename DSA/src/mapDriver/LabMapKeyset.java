package mapDriver;
import map.*;
import set.*;
import list.Iterator;

/**
 * Test the HashMap keySet
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class LabMapKeyset
{
    public static void main(String[] args)
    {   Map <String, String> names = new HashMap <String, String> ();
        // The keys are names of people, the values are their phone area codes.
        System.out.println ("\n");
        testMap (names);
        names = new TreeMap <String, String> ();
        System.out.println ();
        testMap (names);
    }
    
    private static void testMap (Map<String, String> names)
    {
        if  (! names.isEmpty())
            System.err.println ("isEmpty incorrect");
        
        names.put ("sue", "609");
        names.put ("jim", "856");
        names.put ("sarah", "215");
        names.put ("will", "856");
        names.put ("stu", "609");
        names.put ("van", "856");
        names.put ("jim", "215");
        
        if ( names.isEmpty())
            System.err.println ("isEmpty incorrect");
        if (! names.containsKey ("van"))
            System.err.println ("containsKey incorrect");
        if (names.containsKey ("joe"))
            System.err.println ("containsKey incorrect");
        if (! (names.size() == 6))
            System.err.println ("Size is incorrect") ;
        if (! ( names.get ("jim").equals ("215")))
            System.err.println ("Incorrect value for jim") ;
        
        System.out.println ("sue's area code is " + names.remove ("sue"));
        if (! ( names.size() == 5))
            System.err.println ("Size is incorrect" );
        if (names.get ("sue") != null)
            System.err.println ("Incorrect value for sue") ;
            
        System.out.println ();
        System.out.println (names); 
        System.out.println ();
        
        // Show people from outside NJ
        Set <String> keys = names.keySet();
        Iterator<String> itty = keys.iterator();
        while (itty.hasNext())
            {   String name = itty.next();
                String areaCode = names.get(name);
                if (! (areaCode.equals ("856") || areaCode.equals ("609")))
                    System.out.println (name + "(" + areaCode + ") is not in NJ");
             }  
        System.out.println ("\n");
        
        names.clear();
        names.put ("jim", "215");
        System.out.println (names);     // Should be [jim=215]
}
  
}
