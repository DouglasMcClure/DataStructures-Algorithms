package tree;

public class Mod extends Expr{
    public Mod(Expr left, Expr right){
        super.left = left;
        super.right = right;
    }

    @Override
    public int eval() {
        return left.eval() % right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof  Mod))
            return false;
        Mod other = (Mod) obj;
        return left.equals(other.left) && right.equals(other.right); // a%b = a%b
    }

    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && left.equals(0)) // 0 % x = x
            return new Constant(0);
        if (right instanceof Constant && right.equals(0)) // x % 0 = x
            throw new RuntimeException("Cannot divide by zero");
        return this;  // cannot simplify
    }

    // Use parentheses even if not needed
    public String toString(){
        return "(" + left + "%" + right + ")";
    }
}
