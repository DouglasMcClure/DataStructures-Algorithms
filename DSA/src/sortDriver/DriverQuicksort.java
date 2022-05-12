package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the QuickSort algorithm.
 * 
 * @author (sdb)  
 * @version (2020)
 */
public class DriverQuicksort
{   static final int MAX = 20;
    
    public static void main(String[] args)
    {
        Random rand = new Random();         // random number generator
        List <Integer> numbers = new ArrayList <Integer> ();
        Sorter<Integer>  sorter;
        sorter = new QuickSort <Integer> ();
        
        // Test QuickSort with random input
        System.out.println ("Testing Quicksort");
        for (int i=0; i<MAX; i++)
            numbers.add (rand.nextInt(50));   // random int in [0..49]
        System.out.println ("Before sorting:");
        System.out.println (numbers);
        sorter.sort (numbers );
        System.out.println ("After sorting:");
        System.out.println (numbers);
        System.out.println ();
        
        
         // Test QuickSort with ascending input
        numbers.clear();
        for (int i=0; i<MAX; i++)
            numbers.add (i * 10);           // initially in ascending order
        System.out.println ("Before sorting:");
        System.out.println (numbers);
        sorter.sort ( numbers);
        System.out.println ("After sorting:");
        System.out.println (numbers);
        System.out.println ();
        
         // Test QuickSort with descendng input
        numbers.clear();
        for (int i=0; i<MAX; i++)
            numbers.add (MAX-i);           // initially in ascending order
        System.out.println ("Before sorting:");
        System.out.println (numbers);
        sorter.sort ( numbers);
        System.out.println ("After sorting:");
        System.out.println (numbers);
        System.out.println ();
        
        numbers.clear();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(22);
        numbers.add(2);
        numbers.add(1);
        System.out.println ("Before sorting:");
        System.out.println (numbers);
        sorter.sort(numbers);
        System.out.println ("After sorting:");
        System.out.println (numbers);
        System.out.println ();
    }
}
