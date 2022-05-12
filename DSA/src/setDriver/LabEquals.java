package setDriver;
import set.*;
import list.*;


/**
 * Test the implementations of the Set interface.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class LabEquals
{
    public static void main(String[] args)
    {   
        Set <String> friends, pals;
        friends = new TreeSet <String> ();
        pals = new HashSet <String> ();
        System.out.println ("Testing equals (Object)");
        
        if (friends.equals("friends") || pals.equals("pals"))
                System.err.println ("Error in equals");
        if (! friends.equals (pals))
            System.err.println ("Error in equals");
        if (! pals.equals (friends))
            System.err.println ("Error in equals");
            
        friends.add ("joe");
        friends.add ("jim");
        if (friends.equals (pals))
            System.err.println ("Error in equals");
        if (pals.equals (friends))
            System.err.println ("Error in equals");
            
        friends.add ("joe");
        friends.add (new String ("susie"));
        pals.add ("joe");
        pals.add ("susie");
        pals.add ("jim");
        pals.add ("jimmy");
        if (friends.equals (pals))
            System.err.println ("Error in equals");
        if (pals.equals (friends))
            System.err.println ("Error in equals");
        pals.add ("joe");
        friends.add ("jimmy");
        
         if (! friends.equals (pals))
            System.err.println ("Error in equals");
        if (! pals.equals (friends))
            System.err.println ("Error in equals");
            
        friends.add("jack");
        pals.add("jill");
        if (friends.equals (pals))
            System.err.println ("Error in equals");
        if (pals.equals (friends))
            System.err.println ("Error in equals");
        
         
            // Uncomment the following when ready for problem 3
        // System.out.println (friends.size() + " friends are: " + friends);
        // System.out.println (pals.size() + " pals are: " + pals);
        System.out.println ("Testing complete");
        
    }
}