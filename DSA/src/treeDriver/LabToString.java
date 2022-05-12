package treeDriver;

import tree.*;
import list.*;

/**
 * Test the binary search tree implementation.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class LabToString
{
    
    public static void main(String[] args)
    {
    BinaryTree <String> kids = new EmptyBinarySearchTree <String> ();
    
    if (!kids.isEmpty ())
        System.out.println ("Not correct 1");
    
    kids = kids.add ("kimmy");
    kids = kids.add ("jimmy");
    kids = kids.add ("susie");
    kids = kids.add ("joe");
    kids = kids.add ("jo");  //
    kids = kids.add ("sue");
    kids = kids.add ("al");

    // sequence
    System.out.println ("The kids are\n" + kids + "\n");      // Lab problem
   
    }
}
