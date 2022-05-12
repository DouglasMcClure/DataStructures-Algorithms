package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the binary search algorithm.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class HomeworkTestSearch
{
    static ArrayList <Integer> grades = new ArrayList <Integer> ();
    static Random rand = new Random();
    static int MAX = 20;
    
    public static void main (String[] args)
    {
        
    Sorter <Integer> selection = new SelectionSort ( );
    Sorter <Integer> bubble = new BubbleSort ( );
    Sorter <Integer> quick = new QuickSort ( );

// Choose one of the following sorting algorithms, and uncomment that line:
    testSort (selection);
//     testSort (bubble);
 //    testSort (quick);

    BinarySearch<Integer> searcher = new BinarySearch<Integer> (grades);
    for (int i=0; i<MAX; i++)
        {   int target = rand.nextInt(MAX*3+10)-5;
            int ndx = searcher.search (target);
            System.out.print ("target " + target);
            if (ndx<0)
                System.out.println (" not found");
            else
                System.out.println (" found at position " + ndx);
        }
        
    
    }
    
    private static void testSort (Sorter<Integer> sorter)
    {   init();
        
        System.out.println (sorter.getClass().toString());
        System.out.println (grades);
        sorter.sort(grades);
        System.out.println (grades + "\n");
    
    }
    
    private static void init()
    {   grades.clear(); 
        for (int i=0; i<MAX; i++)
            grades.add (rand.nextInt(MAX*3));
    }
}
