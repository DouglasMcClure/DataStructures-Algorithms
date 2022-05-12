package tree;

public class Quotient extends Expr{
    public Quotient(Expr left, Expr right){
        super.left = left;
        super.right = right;
    }

    @Override
    public int eval() {
        return left.eval() / right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof  Quotient))
            return false;
        Quotient other = (Quotient) obj;
        return left.equals(other.left) && right.equals(other.right); // a/b = a/b
    }

    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && left.equals(0))
            return new Constant(0);
        if (right instanceof Constant && right.equals(0))
            throw new RuntimeException("Cannot divide by zero");
        return new Constant(this.eval());
    }

    // Use parentheses even if not needed
    public String toString(){
        return "(" + left + "/" + right + ")";
    }
}
