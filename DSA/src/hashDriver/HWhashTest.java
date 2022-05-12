package hashDriver;
import hash.*;


/**
 * Test the HashTable
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class HWhashTest
{
    public static void main(String[] args)
    {   
        HashTable <Integer> nums = new HashTable <Integer> (3);
        
        for (int i=0; i<20; i = i + 2)
                nums.put(i);
            
       if (nums.size() != 10)
            System.err.println ("size is not correct");
        
        if (nums.isEmpty())
            System.err.println ("Not correct");
            
        System.out.println (nums.get(16));      // should be 16
        System.out.println (nums.get(15));      // should be null
        
        if (!nums.remove(16))
            System.err.println ("Not correct");
        if (nums.remove(16))
            System.err.println ("Not correct");
       if (nums.size() != 9)
            System.err.println ("size is not correct");
        
        nums.clear();
        if (! nums.isEmpty())
            System.err.println ("Not correct");
            
       nums.put (0);
       if (nums.get(18) != null)
            System.err.println ("Not correct");
            
       if (nums.size() != 1)
            System.err.println ("Not correct");
 
}
  
}
