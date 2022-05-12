package listDriver;
import list.*;

/**
 * Test methods added to the List interface
 * 
 * @author (sdb) 
 * @version (Sep 2019)  
 */
public class DriverArrayList
{
/**
 *  This main method tests the ArrayList class
 */
    public static void main (String [] args)
    {   List<String> friends = new ArrayList <String> ();

        System.out.println ("Testing problem 2");
    friends.add ("joe");
    friends.add ("mary");
    friends.add ("jim");
    friends.add ("joe");                            // Lists may contain duplicate elements
    friends.add (2, "sally");                       // Insert at position 2
    friends.remove (0);                             // Remove joe at position 0 
    if (friends.size() != 4)
        System.err.println ("Error in add, remove or size");
    String s1 = "sal";
    String s2 = "ly";       // s1 + s2 is "sally"
    System.out.println ("sally is at position " + friends.indexOf(s1 + s2));  // should be 1
    if (friends.indexOf(s1+s2) != 1)
        System.err.println ("Error in indexOf"); 
 ////////  Uncomment the following lines when ready for problem 2(b)
 if  (friends.contains ("Jim"))
 System.err.println ("Not correct");
 if (!friends.contains ("jim"))
 System.err.println ("Not correct");
 friends.add ("mary");
 if (friends.indexOf("mary") != 0)
 System.err.println ("Not correct");
  
        
 //////////// Uncomment the following when ready for problem 3
     System.out.println ("\n\n Testing problem 3");
     System.out.println ("The list of friends is " + friends);
     friends.clear();
     if (! friends.isEmpty())
             System.err.println ("Error in clear or isEmpty");
     System.out.println (friends);
     for (int i=0; i< 25; i++)
             friends.add ("str" + i);
     System.out.println (friends);
    
     // Testing for efficiency
     for (int i=0; i<500000; i++)
         friends.add ("str" + i);
     for (int i=0; i<100000; i++)
         if (friends.indexOf(new String("str3")) != 3)
             System.err.println ("Not correct");
     for (int i=0; i<100; i++)
        {
          if (friends.indexOf("foo") != -1)
             System.err.println ("Not correct");
          if (friends.contains("foo"))
             System.err.println ("Not correct");
         }
     System.out.println ("Testing finished");
         
     }
}      
