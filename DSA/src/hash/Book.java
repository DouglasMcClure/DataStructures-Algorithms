package hash;

public class Book<K> {
    Date thisDate;
    String thisTitle;
    String thisAuthor;
    int thisPageCount;
    public Book(String title, String author, int pageCount, Date date){
        this.thisTitle = title;
        this.thisAuthor = author;
        this.thisPageCount = pageCount;
        this.thisDate = date;
    }

    public String getTitle(){
        return thisTitle;
    }

    public String getAuthor(){
        return thisAuthor;
    }

    public int getPageCount(){
        return thisPageCount;
    }

    public Date getDate(){
        return thisDate;
    }
}
