package tree;

public class Product extends Expr{
    public Product(Expr left, Expr right){
        super.left = left;
        super.right = right;
    }

    @Override
    public int eval() {
        return left.eval() * right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof  Product))
            return false;

        Product other = (Product) obj;
        return left.equals(other.left) && right.equals(other.right) // a*b = a*b
                ||
                right.equals(other.left) && left.equals(other.right); // b*a = b*a
    }

    @Override
    public Expr simplify() {
        Expr zero = new Constant (0);
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && left.equals(zero)) // 0 * x = x
            return zero;
        if (right instanceof Constant && right.equals(zero)) // x * 0 = x
            return zero;
        if(left instanceof Constant && left.equals(1))
            return right;
//        if(left.right.equals(right.left) || right.right.equals(left.left))
//            return this;
        else
            return left;
    }

    // Use parentheses even if not needed
    public String toString(){
        return "(" + left + "*" + right + ")";
    }
}
