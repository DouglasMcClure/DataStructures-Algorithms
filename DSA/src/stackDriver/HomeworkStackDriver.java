package stackDriver;
import stack.*;

/**
 * Test the Stack implementations.
 * 
 * @author (sdb 
 * @version (2020)
 */
public class HomeworkStackDriver
{
    public static void main(String args[])
    {   System.out.println ("Based on LinkedList");
        StackADT <String> names = new Stack<String>(false);     // Use LinkedList
        test(names);
        System.out.println ("\nBased on ArrayList");            // Use ArrayList
        names = new Stack<String> (true);
        test (names);
    }
     
    private static void test(StackADT<String> names)
    {
        if (! names.isEmpty())
            System.err.println ("Error in isEmpty");
        names.push ("mary");
        names.push ("joe");
        names.push ("jim");
        names.push ("joe");
        
        if (names.isEmpty())
            System.err.println ("Error in isEmpty");
        System.out.println (names);             // [mary, joe, jim, joe]
        System.out.println (names.peek());      // joe
        System.out.println (names.pop());       // joe
        System.out.println (names);             // mary joe jim
        names.push (names.push (names.push ("al")));            
        System.out.println (names);             // mary joe jim al al al
        names.clear();
        names.push("sam");
        System.out.println (names);             //  sam
    }
        
}
