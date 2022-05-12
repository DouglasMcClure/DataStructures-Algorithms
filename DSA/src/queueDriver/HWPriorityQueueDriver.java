package queueDriver;
import queue.*;
import list.*;

/**
 * Test the PriorityQueue.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class HWPriorityQueueDriver
{
   public static void main(String[] args)
   {    QueueADT <Integer> nums = new PriorityQueue<Integer> ();
       nums.add (20);
       nums.add (15);
       nums.add (17);
       nums.add (18);
       nums.add (18);
       nums.add (22);
       
       System.out.println (nums);           //  [22,18,20,15,18,17]
       
       System.out.println (nums.remove ());
       System.out.println (nums);           //  [20,18,17,15,18]
       System.out.println (nums.remove ());
       System.out.println (nums);           //  [18,18,17,15]
       nums.add (3);
       nums.add (22);
       nums.add (20);
       if (nums.size() != 7)
            System.err.println("Error in size, add, or remove");
       
       System.out.println (nums);           //   [22,18,20,15,3,17,18]
       System.out.println (nums.remove ());
       System.out.println (nums);           //   [20,18,18,15,3,17]
       System.out.println (nums.remove ()); 
       System.out.println (nums);           //   [18,18,17,15,3]
       System.out.println (nums.remove ());
       System.out.println (nums);           //   [18,15,17, 3]
       
       System.out.println (nums.peek());    //   18
       
       while (! nums.isEmpty())
            {   System.out.println (nums.remove ());
                System.out.println (nums);
            }
       
    }

}
