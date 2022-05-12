package hashDriver;

import java.util.Objects;

public class Book<K> {
    Date thisCopyRight;
    String thisTitle;
    String thisAuthor;
    int thisPageCount;
    public Book(String title, String author, int pageCount, Date copyRight){
        this.thisTitle = title;
        this.thisAuthor = author;
        this.thisPageCount = pageCount;
        this.thisCopyRight = copyRight;
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

    public Date getCopyRight(){
        return thisCopyRight;
    }

    @Override
    public int hashCode(){
        int hashcode = 17;
        char ch = 'c';
        hashcode = hashcode * 31 + getTitle().hashCode();
        hashcode = hashcode * 31 + getAuthor().hashCode();
        hashcode = hashcode * 31 + getCopyRight().hashCode();
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        Book book = (Book) obj;

        if(book.thisTitle.equals(this.thisTitle) && book.thisAuthor.equals(this.thisAuthor) && book.thisCopyRight.equals(this.thisCopyRight))
            return true;
        return false;
    }

    public String toString(){
        return ("Author: " + getAuthor() + ", Title: " + getTitle() + ", Copyright: " + getCopyRight() + ", Pages: " + getPageCount());
    }
}
