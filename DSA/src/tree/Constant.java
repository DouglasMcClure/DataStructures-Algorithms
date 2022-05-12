package tree;

/**
 * A Constant is an Expr which has a value
 * @author (Douglas McClure)
 * @version (August 2021)
 */

public class Constant extends Expr{
    int value;
    public Constant(int value){
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Constant))
            return false;
        Constant c = (Constant) obj;
        return value == c.value;
    }

    @Override
    public Expr simplify() {
        return this;
    }

    public String toString(){
        return value + "";
    }
}
