package queue;

import graph.Airport;

public class Airplane<E extends Comparable> implements Comparable {
    int flight;
    int arrivalTime;
    int fuelLevel;
    // gallons of jet fuel remaining
    public Airplane (int arrival, int fuel, int flight)
    {
        arrivalTime = arrival;
        fuelLevel = fuel;
        this.flight = flight;
        System.out.println (this + " has arrived at time " + arrival);
    }

    @Override
    public int compareTo(Object o) {
        Airplane otherAirplane = (Airplane) o;
        if(this.fuelLevel < 4)
            return this.fuelLevel;
        if(this.fuelLevel > otherAirplane.fuelLevel)
            return otherAirplane.fuelLevel;
        return this.fuelLevel;
    }

    public String toString(){
        return "Flight: " + flight + " Arrival Time: " + arrivalTime + " Fuel Level: " + fuelLevel;
    }
}
