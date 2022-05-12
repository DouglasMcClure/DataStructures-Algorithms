package listDriver;

public class Student {

    String n = "";
    int id = 0;

    Student(String name, int idNumber){
        n = name;
        id = idNumber;
    }

    public String getName(){
        return n;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return n + " " + id;
    }
}
