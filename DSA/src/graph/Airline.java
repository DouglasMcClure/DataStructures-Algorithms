package graph;

import list.ArrayList;
import list.Iterator;
import list.LinkedList;
import list.List;
import map.HashMap;
import map.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * An Airline has a collection of direct Flights.
 * The Airline is capable of finding a path from an
 * origin Airport to a destination Airport.
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class Airline {
    List<Flight> flights; // Direct flights
    // Keys are Airport names, values are Airports
    Map<String,Airport> map;

    public static void main() {
        Airline airline = new Airline();

        // Read the direct flights from a text file
        airline.getFlights();

        System.out.println("Flights: " + airline.flights);
        System.out.println("Map: " + airline.map);
        System.out.println("Path from PHL to SFO");
        // Find a path:
        System.out.println(airline.path ("PHL", "SFO"));

        // Try finding other paths ...
    }

    /**
     * Read the direct flights from a text file.
     * Build the List of Flights, and a Map from
     * Airport names to Airports.
     */
    private void getFlights(){
        File inFile = new File("flights.txt");
        map = new HashMap<String, Airport>();
        flights = new ArrayList<Flight>();

        try {
            Scanner scanner = new Scanner(inFile);
            String flight, origin, dest = "";
            Airport o, d;
            while (scanner.hasNextLine()){
                flight = scanner.nextLine();  // has both o and d
                origin = flight.split(" ")[0];
                if (map.containsKey(origin))
                    o = map.get(origin); // Get the Airport
                else // Create entry in the map
                {
                    o = new Airport(origin);
                    map.put(origin, o);
                }
                if (map.containsKey(dest))
                    d = map.get(dest);
                else
                {
                    d = new Airport(dest);
                    map.put(dest,d);
                }
                flights.add(new Flight(o, d));
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    /**
     * Find a path from the Airport with the name origin, to
     * the Airport with the name dest, if possible.
     * It need not be an optimal path.
     * @return the path as a List of Airports, empty if no path is found.
     */
    private List<Airport> path (String origin, String dest){
        Airport o = map.get(origin);
        Airport d = map.get(dest);

        List<Airport> result = path(o,d);
        clearAirports(); // Clear visited flags
        return result;
    }

    /**
     * @return the path from origin to dest
     */
    private List<Airport> path (Airport origin, Airport destination){
        List<Airport> result = new LinkedList<Airport>();
        origin.visited = true;
        if (origin.equals(destination)){
            result.add(origin);
            return result;
        }
        // Recursive case
        Airport port;
        Iterator<Airport> it = getDirect(origin).iterator();
        while (it.hasNext()){
            port = it.next();
            port.visited = true;
            result = path(port, destination);
            if (result.size() > 0)
            {
                result.add(0, origin);
                return result;
            }
        }
        return result; // No path found
    }

    /**
     * @return a List of Airports which can be reahed
     * directly from the given Airport, and which have not
     * already been visited
     */
    private List<Airport> getDirect(Airport from){
        List<Airport> result = new LinkedList<Airport>();
        Iterator<Flight> it = flights.iterator();
        Flight flight;
        while (it.hasNext()){
            flight = it.next();
            if (flight.origin.equals(from) && ! flight.destination.visited)
                result.add(flight.destination);
        }
        return result;
    }

    /**
     * Reset visited flag of every Airport
     */
    private void clearAirports(){
        Flight flight;
        Airport port;
        Iterator<Flight> it = flights.iterator();
        while (it.hasNext()){
            flight = it.next();
            flight.origin.visited = false;
            flight.destination.visited = false;
        }
    }
}
