package mapDriver;
import map.*;
import set.*;
import list.Iterator;

/**
 * Test the Map classes
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class LabHashMapEquals
{
    public static void main(String[] args)
    {   Map <String, String> friends = new HashMap <String, String> ();
        Map <String, String> pals = new HashMap <String, String> ();
 
        init (friends);
        if (friends.equals(pals))
            System.err.println ("error");
         if (pals.equals(friends))
            System.err.println ("error");
        init (pals);
        if (!friends.equals(pals))
            System.err.println ("error");
         if (!pals.equals(friends))
            System.err.println ("error");

         System.out.println ("\njim is not a pal: " + pals.remove("jim"));
         if (friends.equals(pals))
            System.err.println ("error");
         if (pals.equals(friends))
            System.err.println ("error");
         System.out.println ("jim is not a friend: " + friends.remove("jim"));
          if (!friends.equals(pals))
            System.err.println ("error");
         if (!pals.equals(friends))
            System.err.println ("error");
         pals.put("will", "215");
         if (pals.equals(friends))
            System.err.println ("error");
         if (friends.equals(pals))
            System.err.println ("error");
         friends.remove("van");
         pals.remove("stu");
         if (pals.equals(friends))
            System.err.println ("error");
         if (friends.equals(pals))
            System.err.println ("error");
         
         
         System.out.println ("friends are " + friends);
         System.out.println ("pals are " + pals);
         
    }
    
    private static void init (Map<String, String> people)
    {        
        people.put ("sue", "609");
        people.put ("jim", "856");
        people.put ("sarah", "215");
        people.put ("will", "856");
        people.put ("stu", "609");
        people.put ("van", "856");
        people.put (new String ("jim"), "215");
        System.out.println (people);
    }
    
  
}
