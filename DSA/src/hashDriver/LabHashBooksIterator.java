package hashDriver;
import hash.*;
import list.Iterator;

/**
 * Test the HashTable class, using Book as the generic type.
 * 
 * @author (sdb) 
 * @version (2020)
 */ 
public class LabHashBooksIterator
{
   public static void main(String[] args)
   {    HashTable <Book> library = new HashTable <Book> ();
       
        library.put (new Book ("Java", "Barnes", 300, new Date(12,20,1985)));
        library.put (new Book ("Java", "Barnes", 300, new Date(1,2,1995)));
        library.put (new Book ("Java", "Barnes", 310, new Date(12,20,2000)));
        library.put (new Book ("Compilers", "Bergmann", 306, new Date(12,20,1985)));
        library.put (new Book ("Networks", "Stallings", 500, new Date(12,20,1985)));
        library.put (new Book ("Java", "Barnes", 305, new Date(12,20,1985)));
      
        Date date = new Date (12,20,1985);
        if (library.isEmpty())
            System.err.println ("Not correct");
        if (! library.containsKey (new Book ("Java", "Barnes", 0, date)))
            System.err.println ("Not correct");
            
        System.out.println ("The size of our library is " + library.size()); 
        
        System.out.println (library.get (new Book ("Compilers", "Bergmann", 0, date)));
        
        if (!library.remove (new Book ("Java", "Barnes", 0, date)))
             System.err.println ("Not correct");
        if (!library.remove (new Book ("Java", "Barnes", 0, date)))
             System.err.println ("Not correct");
        if (library.remove (new Book ("Java", "Barnes", 0, date)))
             System.err.println ("Not correct");
             
          
        library.put (new Book ("OED", "Oxford Faculty", 1500, new Date(1,20,2012)));
        library.put (new Book ("Moby Dick", "Melville", 676, new Date(3,22,1888)));
        System.out.println ("The library is \n" + library);
        removeLongBooks(library, 306);
        System.out.println ("\nThe library of small books is \n" + library);
        
        library.clear();
        if (!library.isEmpty())
            System.err.println ("Not correct");
            
        library.put (new Book ("Java", "Barnes", 305, date));
        if (library.size() != 1)
            System.err.println ("Not correct");
          }       
        
        // Remove books with more than max pages from the given lib.
        /** @author PUT YOUR NAME HERE  */
        private static void removeLongBooks (HashTable<Book> lib, int max)
        {
            TableIterator tableIterator = (TableIterator) lib.iterator();
            while (tableIterator.hasNext()){
                Book thisBook = (Book) tableIterator.next();
                if(thisBook.getPageCount() > max)
                    tableIterator.remove();
            }

        }
}
