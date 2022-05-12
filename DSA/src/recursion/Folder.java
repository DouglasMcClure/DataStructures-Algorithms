package recursion;

/**
 *  Folder containing a List of Items
 *
 * @author (Douglas McClure)
 * @version (July 2021)
 */

import list.ArrayList;
import list.LinkedList;
import list.List;

public class Folder extends Item{

    List<Item> itemList = new LinkedList<>();

    String thisFolderName;

    public Folder(String folderName){
        super(folderName);
        thisFolderName = folderName;
    }

    @Override
    public List<Document> getAllDocs() {
        List<Document> documentList = new ArrayList<Document>();
        for (int i = 0; i < itemList.size(); i++) {
            documentList.addAll(itemList.get(i).getAllDocs());
        }
        return documentList;
    }

    /**
     * Displays this entire folder
     */
    @Override
    public void show() {

        System.out.println("Folder Name: " + thisFolderName);
        System.out.println("Items inside the folder: ");

        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).show();
        }

    }

    /**
     * Add the given Item to this Folder
     */
    public void addItem (Item item){
        itemList.add(item);
    }

}
