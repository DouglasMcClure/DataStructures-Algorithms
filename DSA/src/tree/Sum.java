package tree;

/**
 * An Expr which is the sum of two Exprs
 * @author (Douglas McClure)
 * @version (August 2021)
 */
public class Sum extends Expr{
    public Sum(Expr left, Expr right){
        super.left = left;
        super.right = right;
    }

    @Override
    public int eval() {
        return left.eval() + right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Sum))
            return false;
        Sum other = (Sum) obj;
        return left.equals(other.left) && right.equals(other.right) // a+b = a+b
                ||
                left.equals(other.right) && right.equals(other.left); // b+a = b+a
    }

    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && left.eval() == 0) // 0 + x = x
            return right;
        if (right instanceof Constant && right.eval() == 0) // x + 0 = x
            return left;
        return this;  // cannot simplify
    }

    // Use parentheses even if not needed
    public String toString(){
        return "(" + left + "+" + right + ")";
    }

}
