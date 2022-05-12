package recursion;

import list.ArrayList;
import list.List;

/**
 *  Documents for each Item
 *
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class Document extends Item {
    String thisItem;
    List<Document> thisDocument = new ArrayList<>();
    DocType thisDocType;

    public Document(String item, DocType docType){
        super(item);
        thisItem = item;
        thisDocType = docType;
        thisDocument.add(this);
    }

    /**
     * This returns this document
     * @return this document
     */
    @Override
    public List<Document> getAllDocs() {
        return thisDocument;
    }

    /**
     * Displays the document
     */
    @Override
    public void show() {
        System.out.println("Document Name: " + thisName);
        System.out.println("Document Type: " + thisDocType);
    }

    /**
     * This returns the document as a String
     * @return document as a String
     */
    public String toString(){
        return thisItem + ": " + thisDocType;
    }
}
