package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the HeapSort algorithm.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class HomeworkTestHeapsort
{
    static ArrayList <Integer> grades = new ArrayList <Integer> ();
    static Random rand = new Random();
    
    public static void main (String[] args)
    {
    
     System.out.println ("Test Heap Sort:");
     Sorter <Integer> sorter = new HeapSort<Integer> ( );
     testSort (sorter);

    }
    
    private static void testSort (Sorter<Integer> sorter)
    {   init();
        
        System.out.println ("Before sorting:");
        System.out.println (grades);
        System.out.println ("After sorting:");
        sorter.sort(grades);
        System.out.println (grades + "\n");
        System.out.println ( );
    
    }
    
    private static void init()
    {   grades.clear(); 
        for (int i=0; i<20; i++)
             grades.add (rand.nextInt(150));

    }
}
