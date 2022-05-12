package hash;

public class Date<K> {
    int thisDay;
    int thisMonth;
    int thisYear;
    public Date(int day, int month, int year){
        this.thisDay = day;
        this.thisMonth = month;
        this.thisYear = year;
    }
    public int getDay(){
        return thisDay;
    }
    public int getMonth(){
        return thisMonth;
    }
    public int getYear(){
        return thisYear;
    }
    public boolean equals(Date date){
        int otherDay = date.getDay();
        int otherMonth = date.getMonth();
        int otherYear = date.getYear();

        if(thisDay == otherDay && thisMonth == otherMonth && thisYear == otherYear)
            return true;
        else
            return false;
    }
}
