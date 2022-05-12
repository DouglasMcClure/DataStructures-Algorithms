package stackDriver;
import stack.*;
import java.util.Scanner;
/**
 * Evaluate postfix expressions
 * Assume that numbers and operators are separated by one space.
 * Assume that the expressions are well-formed.
 * @author (sdb and PUT YOUR NAME HERE) 
 * @version (2020)
 */
public class LabPostfix
{

    public static void main(String[] args){
        postfixEval();
    }

    // read postfix expressions from the keyboard, and evaluate
    public static void postfixEval()
    {   Stack <Integer> stack = new Stack <Integer> ();
        
        // read expression from the keyboard
        Scanner scanner = new Scanner (System.in);
        
        String input;       // store an entire expression
        String [] opInts;   // Each string is an operator or an int.
        int right;           // store right operand
            
        System.out.println ("Enter postfix expressions, or Enter to terminate");
        input = scanner.nextLine();
        while (input.length() > 0)               // Empty input line terminates the program
            {   opInts = input.split (" ");      // An array of Strings, delimiter is space
                char first;
                
                ////////////////  fill in the body of this loop:
                for (String s : opInts)
                    {   // Is the string s a number or operator?
                        // If the first character in the string is a numeric digit,
                        // then it must be a number.

                        first = s.charAt(0);

                        boolean isDigit = Character.isDigit(first);

                        if(isDigit){
                            int digit = Integer.parseInt(s);
                            stack.push(digit);
                        }else {
                            int firstValue = stack.pop();
                            int secondValue = stack.pop();
                            switch (s) {
                                case "+":
                                    stack.push(secondValue + firstValue);
                                    break;
                                case "/":
                                    stack.push(secondValue / firstValue);
                                    break;
                                case "%":
                                    stack.push(secondValue % firstValue);
                                    break;
                                case "*":
                                    stack.push(secondValue * firstValue);
                                    break;
                                case "-":
                                    stack.push(secondValue - firstValue);
                                    break;
                            }
                        }
                        
                    }       // reached end of an expression
                    if (!stack.isEmpty())
                        System.out.println (stack.peek());
                    stack.clear();
                    
                    input = scanner.nextLine();
                }
            }
                
            
}
