package treeDriver;

import tree.*;

/**
 * Test the binary search tree implementation.
 * 
 * @author (sdb) 
 * @version (Oct 2018)
 */
public class HomeworkTestBTNoRemove
{
    
    public static void main(String[] args)
    {
    BinaryTree <String> kids = new EmptyBinarySearchTree <String> ();
    
    if (!kids.isEmpty ())
        System.err.println ("isEmpty not correct");
    
    kids = kids.add ("kimmy");
    kids = kids.add ("jimmy");
    kids = kids.add ("susie");
    kids = kids.add ("joe");
    kids = kids.add ("sue");

    if (kids.size() != 5)
	System.err.println ();

    if (kids.isEmpty())
        System.err.println ("isEmpty not correct");
     if (!(kids.containsKey ("sue")))
        System.err.println ("Not correct");
     if (kids.containsKey ("jim"))
        System.err.println ("Not correct");
     if (!(kids.get (new String("susie")).equals ("susie")))
        System.err.println ("Not correct");
     if ((kids.get ("joseph") != null))
        System.err.println ("Not correct");
     System.out.println ("Testing completed");
      
    }
}
