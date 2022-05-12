package queueDriver;

/**
 * Simulate print queues and print jobs assigned to queues
 * 
 * @author (sdb)  
 * @version (2020)
 */
public class PrintQueueTester 
{
    private Printer printer1;
    private Printer printer2;
    
    public static void main (String [] args)
    {   PrintQueueTester tester = new PrintQueueTester();
        tester.test();
    }
    
    public PrintQueueTester()
    {   printer1 = new Printer (5, "ROB 312");           // print speed is 5
        printer2 = new Printer (3, "CS Lab");      // print speed is 3
    }
    
    public void test()
    {   System.out.println ("First printer is " + printer1);
        System.out.println ("Second printer is " + printer2);
        printer1.add (new Doc (22));
        printer2.add (new Doc (2));
        printer1.add (new Doc (3));
        printer1.add (new Doc (5));
        printer2.add (new Doc (7));
        printer2.add (new Doc (1));
        
        for (int i=0; i<10; i++)
            {   System.out.println ("step " + i);
                printer1.print();
                printer2.print();
            }
   
    }
    }
