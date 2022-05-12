package listDriver;
import list.*;

/**
 * Lab Problem.  Method to search a list for the first pair of equal neighbors.
 *               Delete the first member of that pair.
 * 
 * @author (sdb and PUT YOUR NAME HERE!) 
 * @version (2020)
 */
public class LabDeleteListIterator
{
    
    static List <Student> roster;
    
    public static void main(String[] args)
    {   roster = new ArrayList<Student>();
        test();
        roster = new LinkedList<Student>();
        test();
    }
    
    private static void init()
    {   deleteFirstOfDup();
        roster.add (new Student ("jim", 2222));
        deleteFirstOfDup();
        roster.add (new Student ("joseph", 2345));
        roster.add (new Student ("joe", 2345));
        roster.add (new Student ("mary", 3333));
        roster.add (new Student ("maryLou", 3333));
        System.out.println("Before deletions " + roster);
    }
    
    private static void test()
    {   
        init();
        deleteFirstOfDup();
        if (roster.size() != 4)
            System.err.println ("Deletion is incorrect");
        System.out.println ("Roster is " + roster);
    }
    
    /** Search the roster for the first pair of neighbors which are
     *  equal.  Delete the first member of that pair.
     */
    private static void deleteFirstOfDup()
    {   ///////////  PUT YOUR CODE HERE ///////////////
        
        ListIterator<Student> rosterListIterator = roster.listIterator();
        Student thisStudent;
        boolean pairFound = false;
        if(rosterListIterator.hasNext()){
            thisStudent = rosterListIterator.next();
            while(rosterListIterator.hasNext() && !pairFound){
                Student otherStudent = rosterListIterator.next();
                    if (thisStudent.getId() == otherStudent.getId()) {
                        rosterListIterator.previous();
                        rosterListIterator.previous();
                        rosterListIterator.remove();
                        pairFound = true;
                    }else
                        thisStudent = otherStudent;
            }
        }
    }
        
}
