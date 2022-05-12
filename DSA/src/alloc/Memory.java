package alloc;

import list.Iterator;
import list.LinkedList;
import list.List;

/**
 * Simulate the allocation and freeing of
 * memory.
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class Memory {
    //Blocks which are in use, not available
    List<Block> allocated = new LinkedList<Block>();

    //Available Blocks
    List<Block> free = new LinkedList<Block>();
    static final int MAX = 4096; // size of memory

    public Memory(){
        free.add(new Block(0, MAX)); // all of memory is free.
    }

    /**
     * Allocate a block of the given size, if possible.
     * @return its position in memory,
     * or -1 if not possible.
     * Algorithm: First-fit
     */
    public int allocate(int size){
        Block b, newBlock = null;
        Iterator<Block> freeItty = free.iterator();
        while (freeItty.hasNext()){
            b = freeItty.next();
            if (b.size >= size){ // big enough?
                newBlock = new Block(b.start, size);
                allocated.add(newBlock);
                b.start = b.start + size;
                b.size = b.size - size;
                if(b.size == 0){
                    freeItty.remove();
                }
                return newBlock.start;
            }
        }
        return -1;
    }

    /**
     * Make the block at the given start position
     * available.
     * @return true iff there is such a block.
     */
    public boolean free (int start){
        Block b;
        Iterator<Block> itty = allocated.iterator();
        while (itty.hasNext()){
            b = itty.next();
            if (b.start == start){
                itty.remove();
                free.add(0,b); // Add at beginning
                return true;
            }
        }
        return false;
    }

}
