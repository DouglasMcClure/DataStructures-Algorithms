package tree;

public class Difference extends Expr{
    public Difference(Expr left, Expr right){
        super.left = left;
        super.right = right;
    }

    @Override
    public int eval() {
        return left.eval() - right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof  Difference))
            return false;
        Difference other = (Difference) obj;
        return left.equals(other.left) && right.equals(other.right);  // a-b = a-b
    }

    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && left.equals(0))
            return this.right;
        if (right instanceof Constant && right.equals(0))
            return this.left;
        if(left.equals(right) && right.equals(left))
            return new Constant(0);
        return this;  // cannot simplify
    }

    // Use parentheses even if not needed
    public String toString(){
        return "(" + left + "-" + right + ")";
    }
}
