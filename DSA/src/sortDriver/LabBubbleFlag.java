package sortDriver;
import sort.*;
import list.*;

/**
 * Test the Selection Sort algorithm.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class LabBubbleFlag
{
    static List <Integer> grades;
    static Sorter <Integer> sorter = new BubbleSort <Integer> ();
    
    
    public static void main (String[] args)
    {
     testSort(12); //  Sort a short list
     testSort(1000000);           //  Sort a longer list
     System.out.println ("\nTesting complete");
     
    }
    
    /** @return true if the list is sorted */
    private static boolean check()
    {   for (int i=0; i<grades.size()-1; i++)
            if (grades.get(i) > grades.get(i+1))
                return false;
        return true;
    }
        
    // Test the BubbleSort with a list of the given size
    private static void testSort (int size)
    {   init(size);
     System.out.println ("\nTest Bubble Sort: size is " + size);
     sorter = new BubbleSort <Integer>  ( );
     init(size);
     showList();
     sorter.sort(grades);
     showList();
     if (! check())           // Check the result
           System.err.println ("List was not sorted correctly");
    
    }
    
    // Display the list if it's size is less than 20
    private static void showList()
    {   if (grades.size() < 20)
            System.out.println (grades);
        }
        
   // Initialize the list of grades using the given size.
   // Pre: size is at least 10
    private static void init(int size)
    { grades = new ArrayList<Integer> ();
      for (int i=0; i<size; i++)
          grades.add (i);
      // change a few values
      grades.set(size-5,size-2);
      grades.set(size-7,size-3);
      grades.set(size-8,size-4);
    }
}