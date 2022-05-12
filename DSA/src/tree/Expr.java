package tree;

/**
 * An Expr is an arithmetic expression
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public abstract class Expr {
    Expr left, right; //operands

    //default Constructor
    public Expr(){}

    public Expr (Expr left, Expr right){
        this.left = left;
        this.right = right;
    }

    /**
     * @return the value of this Expr.
     */
    public abstract int eval();

    /**
     * @return true iff this Expr is the same as the given obj
     */
    public abstract boolean equals(Object obj);

    /**
     * @return a simplified version of this Expr,
     * if possible.
     */
    public abstract Expr simplify();
}
