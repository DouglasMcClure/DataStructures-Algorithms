package graph;

/**
 * An Airport has a name
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class Airport {
    String name;
    boolean visited = false;

    public Airport(String name){
        this.name = name;
    }
    public boolean equals(Object obj){
        if (! (obj instanceof Object))
            return false;
        Airport other = (Airport) obj;
        return name.equals(other.name);
    }
    public String toString(){
        return name;
    }
}
