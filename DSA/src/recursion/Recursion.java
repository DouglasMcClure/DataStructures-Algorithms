package recursion;

/**
 * Recursion method to return the quotient without using /, %, or *
 *
 * @author (Douglas McClure)
 * @version (July 2021)
 */

public class Recursion {

    public static void main(String[] args){
        System.out.println(div(14, 5));
    }

    /**
     * @return the quotient when x is divided by y.
     * Pre:  x >= 0, y>0
     */
    public static int div(int x, int y){
            if(x - y == 0)
                return 1;
            else if (x < y)
                return 0;
            else
                return (1 + div(x - y , y));
    }

}
