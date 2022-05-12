package alloc;

/**
 * A Block of memory has a starting address and a size.
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class Block {
    int start;
    int size;

    Block(int start, int size){
        this.start = start;
        this.size = size;
    }

    public String toString(){
        return "(" + start + "." + ")";
    }
}
