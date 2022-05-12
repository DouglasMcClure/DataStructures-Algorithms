package recursion;

import list.List;

/**
 *  Item class
 *
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public abstract class Item {

    String thisName;

    public Item(String name) {
        thisName = name;
    }

    /**
     * @return A list of all the documents making up this Item
     * (and all contained folders)  in any order
     */
    public abstract List<Document> getAllDocs();

    /**
     * Display the name of this Item; also display all the
     * items which it contains, on separate lines.
     */
    public abstract void show();
}
