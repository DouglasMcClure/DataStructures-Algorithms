package hashDriver;
import hash.*;
import java.util.Random;

/**
 * Test the HashTable class, with rehashing
 * 
 * @author (sdb) 
 * @version (Apr 2016)
 */
public class HWrehashTest
{
    static Random rand = new Random();     // Generate random ints
    
    public static void main(String[] args)
    {   HashTable <Integer> numbers = new HashTable <Integer> (4);
        
        for (int i=0; i<5000; i++)
            numbers.put (rand.nextInt()); 
            
        System.out.println (numbers.size() + " ints in the table");
        
        for (int i=-10000000; i<10000000; i++)
            if (numbers.containsKey(i))
                System.out.println (i + " is in the table");
            
        }
}
