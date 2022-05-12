package tree;

public class Variable extends Expr{
    char thisVar;
    int value;
    protected boolean isTrue;
    public Variable (char variable){
        this.thisVar = variable;
    }
    @Override
    public int eval() {
        // 2a)
        // return thisVar;
        // 2b)
        if(isTrue)
            return value;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object obj) {

        if(! (obj instanceof Variable))
            return false;
        Variable otherVar = (Variable) obj;
        return thisVar == otherVar.thisVar;
    }

    @Override
    public Expr simplify() {
            return this;
    }

    public String toString(){
        return thisVar + "";
    }
}
