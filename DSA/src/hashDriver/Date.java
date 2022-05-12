package hashDriver;

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

    @Override
    public int hashCode(){
        int hashcode = 17;
        hashcode = hashcode * 31 + getDay();
        hashcode = hashcode * 31 + getMonth();
        hashcode = hashcode * 31 + getYear();
        return hashcode;
    }

    @Override
    public boolean equals(Object obj){
        Date otherDate = (Date) obj;

        if(otherDate.thisDay == this.thisDay && otherDate.thisMonth == this.thisMonth && otherDate.thisYear == this.thisYear)
            return true;
        return false;
    }

    public String toString(){
        return getDay() + "/" + getMonth() + "/" + getYear();
    }
}
