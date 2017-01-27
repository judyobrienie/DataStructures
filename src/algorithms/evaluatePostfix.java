
package algorithms;

import java.util.*;

public class evaluatePostfix {
	
	
    public static void main(String[] args) {
        System.out.println(postfixEvaluate("11 2 +"));               // 3
        System.out.println(postfixEvaluate("1 2 3 * + 4 +"));       // 11
        System.out.println(postfixEvaluate("4 2 ^"));                 // 16
        System.out.println(postfixEvaluate("10 2 ^"));                 // 100
    }
    
    
    
    @SuppressWarnings("resource")
	public static int postfixEvaluate(String postfix) {
	 	Stack<Integer> valueStack = new Stack<Integer> ();
		
		Scanner tokens = new Scanner(postfix);
		
		while (tokens.hasNext()) {
			if (tokens.hasNextInt()) {
				
				valueStack.push(tokens.nextInt());
			} else {
				int operandTwo = valueStack.pop();
				int operandOne = valueStack.pop();
				String function = tokens.next();
				
				 switch (function)
				    {
				        
				          
				                case "+":
				                	valueStack.push(operandOne + operandTwo);
				                	break;
				                case "-":
				                	valueStack.push(operandOne - operandTwo);
				                	break;
				                case "*":
				                	valueStack.push(operandOne * operandTwo);
				                	break;
				                case "/":
				                	valueStack.push(operandOne / operandTwo);
				                	break;
				                case "^":
				                	valueStack.push( (int) Math.pow(operandOne, operandTwo));
				                
				                   
				                default:
				                    break;
				    }// end of switch
				
				
			
			}// end of else
		}// end of while
		return valueStack.peek();
    }
}


