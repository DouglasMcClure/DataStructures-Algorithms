package treeDriver;
import tree.*;

/**Test the Expression tree classes.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class LabExprDriver 
{
  public static void main(String[] args)
  {
      System.out.println ("\n\nTesting problem 1");
      Expr e1 = new Sum (new Constant(3), new Constant(5));       //  3 + 5
      Expr e2 = new Sum (new Constant(5), new Constant(3));       //  3 + 5
      e1 = new Quotient (e1, e2);
      System.out.println ("The quotient is " + e1);                 // (3+5) / (5+3)
      System.out.println ("It simplifies to " + e1.simplify());       // 1
      e1 = new Quotient (e2, e2);
      System.out.println (e1 + " simplifies to " + e1.simplify());

      e1 = new Difference (new Constant(3), new Constant(5));       //  3 - 5
      e2 = new Difference (new Constant(5), new Constant (3));      //  5 - 3
      if (e1.equals (e2))
        System.err.println ("Not correct: equals in Difference ");


      Expr zero = new Constant (0);
      Expr one = new Constant (1);
      e1 = new Sum (new Constant (3), zero);        // 3 + 0
      System.out.println (e1 + " simplifies to " + e1.simplify());           // 3

      e1 = new Product (new Constant (4), zero);    // 4 * 0
      System.out.println (e1 + " simplifies to " + e1.simplify());            // 0

      e1 = new Product (e2, one);                   //  (5-3) * 1
      System.out.println (e1 + " simplifies to " + e1.simplify());            //  (5 - 3)

      /////////// Uncomment the following when ready for problem 2(a)
//       System.out.println ("\n\nTesting problem 2(a)");
//
//       boolean ok = false;
//         e1 = new Sum (new Variable('x'), new Variable('y'));            //  x + y
//         try { e1.eval(); }
//         catch (IllegalArgumentException iae)
//             {   ok = true; }
//         if (!ok)
//             System.err.println ("Cannot eval a variable, unless it has a value");
//         e1.simplify();
//         new Quotient(new Variable('w'), e1).simplify();
//         new Difference (e1,e1).simplify();
//
//         e2 = new Sum (new Variable('y'), new Variable('x'));            //  y+x
//         Expr e3 = new Difference (e1, e2);                                   // (x+y) - (y+x)
//         System.out.println (e3 + "Simplifies to " + e3.simplify());          // 0
//         System.out.println();
//
//         Expr e = new Quotient (new Variable('x'), new Variable('x'));       // x / x
//         e = new Product ( new Variable('y'), e);                    //   y * (x/x)
//         e = new Difference (e, new Variable('y'));                   //   y * (x/x) - y
//         e = new Sum (e, new Constant(1));                             //   (y * (x/x) - y) + 1
//         System.out.println (e + "simplifies to " + e.simplify());        //   1
//
//             e1 = new Difference (new Variable ('a'), new Variable ('b'));
//             e2 = new Difference (new Variable ('b'), new Variable ('a'));
//             if (e1.equals (e2))
//                 System.out.println ("Not correct");
//             e1 = new Quotient (new Variable ('a'), new Variable ('b'));
//             e2 = new Quotient (new Variable ('b'), new Variable ('a'));
//             if (e1.equals (e2))
//                 System.out.println ("Not correct");

 ////////  Uncomment the following when ready for problem 2(b)
          System.out.println ("\nTesting problem 2(b)");

           Expr a = new Variable ('a');
           Expr b = new Variable ('b');
           boolean ok = false;

 try {     System.out.println (new Sum(a,b).eval()); }
 catch (IllegalArgumentException iae)
     {     ok = true; }
      if (!ok)
             System.err.println ("Cannot eval a variable, unless it has a value");
      ok = false;

      e1 = new Sum (new Assign(a, new Constant(5)),
                             new Assign (b, new Constant (7)));          // e1 = (a=5) + (b=7)
 try {     System.out.println (new Sum(a,b).eval()); }
 catch (IllegalArgumentException iae)
     {     ok = true; }
        if (!ok)
             System.err.println ("Cannot eval a variable, unless it has a value");

        System.out.println ("The value of " + e1 + " is " + e1.eval());

        System.out.println (a + " is " + a.eval());
        System.out.println (b + " is " + b.eval());

        (new Assign (b, new Constant(5))).eval();                              // b = 5, discard the result
        if (b.equals(a))
             System.err.println ("Incorrect: a and b are different expressions");

        (new Assign (b, a)).eval();                                           // b = a;
        (new Assign (a, new Constant (0))).eval();                            // a = 0;
        if (b.eval() != 5)
             System.err.println ("Incorrect: Variables should store values, not expressions");

        e1 = new Assign(a, new Sum (b, new Constant (0)));
        System.out.print (e1 + " simplifies to ");
	  System.out.println (e1.simplify());

	  Expr x = new Variable('x');
      Expr y = new Variable('y');
      Expr z = new Variable('z');
      System.out.println("Testing Question 1");
      try {
          System.out.println(new Quotient(x,y).eval());
      }catch (IllegalArgumentException iae){
          ok = true;
      }
      if (!ok)
          System.err.println ("Cannot eval a variable, unless it has a value");
      ok = false;
      e1 = new Product(new Quotient(x,y), new Quotient(y,z));
      System.out.println(e1 + " simplified is " + e1.simplify());

  }
  
}
