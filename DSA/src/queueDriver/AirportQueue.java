package queueDriver;
import queue.*;
import list.*;
import java.util.Random;

/**
 * Simulate airplanes arriving at an airport.
 * Arriving planes are assigned runways FIFO,
 * but planes running low on fuel have higher
 * priority
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class AirportQueue
{
    public static void main (String[] args)
 {
    QueueADT<Airplane> arrivals = new PriorityQueue<Airplane>();
    
    Random rand = new Random(1);
    Airplane plane;
    
    for (int i=0; i<7; i++)
      { plane = new Airplane (0, rand.nextInt(8)+1, rand.nextInt(1000));
        arrivals.add(plane);  // arrival time is 0, random fuel level
      }
        
    for (int step=6; step < 30; step++)
        {   if (rand.nextFloat() < 0.6)  
                { plane = new Airplane (step, rand.nextInt(6)+1, rand.nextInt(1000));
                    arrivals.add (plane);
                }
            if (!arrivals.isEmpty())
                System.out.println (arrivals.remove () + " has landed");
        }
    }
    
}
