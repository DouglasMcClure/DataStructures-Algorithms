package tree;

public class Assign extends Expr{
    public Assign(Expr left, Expr right){
        super.left = left;
        super.right = right;
    }

    @Override
    public int eval() {
        if(left instanceof Variable && right instanceof Constant){
            Variable value = (Variable) this.left;
            value.value = right.eval();
            value.isTrue = true;
        }
        return this.right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Assign)) {
            return false;
        } else {
            Assign other = (Assign)obj;
            return this.left.equals(other.left) && this.right.equals(other.right)
                    ||
                    this.left.equals(other.right) && this.right.equals(other.left);
        }
    }

    @Override
    public Expr simplify() {
        this.right = this.right.simplify();
        return this;
    }

    public String toString(){
        return left.toString() + "=" + right.toString();
    }
}
