package recursion;


/**
 * Test the Item, Folder, and Document classes
 * 
 * @author (sdb) 
 * @version (Feb 2019)
 */
public class FileSystem
{
    public static void main(String [] args){
        Folder dsa= new Folder ("DSA");
        dsa.addItem(new Document("lists", DocType.JAVA));
        dsa.addItem(new Document("sorting", DocType.JAVA));
        dsa.addItem(new Document("sorting", DocType.JAVA));
        Folder cs = new Folder ("CS");
        cs.addItem (dsa);
        cs.addItem (new Document("resume", DocType.WORD));
        Folder os = new Folder ("OS");
        os.addItem (new Document ("cpu performance", DocType.SPREADSHEET));
        cs.addItem (os);
        Folder english  = new Folder ("English");
        Folder poetry = new Folder ("Poetry");
        english.addItem (poetry);
        poetry.addItem (new Document ("Shakespeare", DocType.WORD));
        poetry.addItem (new Document ("Poe", DocType.WORD));
        english.addItem (new Document("Sherlock Holmes", DocType.WORD));
        Folder school = new Folder ("School");
        school.addItem (english);
        school.addItem (cs);
        school.addItem (new Document ("Me", DocType.PHOTO));

        System.out.println ("All docs: " + school.getAllDocs());
        System.out.println ("\nFolder details: \n");
        school.show();
    }
    
}
