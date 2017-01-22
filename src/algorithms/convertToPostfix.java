package algorithms;
import java.util.Stack;



/**
 * @author Judy
 *
 */
public class convertToPostfix {
	public static void main (String[] args){

		System.out.println(convertToPostfix("A*B-(C+D)+E"));
		System.out.println(convertToPostfix("A+B*C"));
		System.out.println(convertToPostfix("x ^ y / (5 * z) + 10")); 
		System.out.println(convertToPostfix("A+B*C"));
		System.out.println(convertToPostfix("a+b*c-d"));
		System.out.println(convertToPostfix("1+2*3-4"));
		
	}	



	//Algorithm convertToPostfix (infix)
	// Converts an infix expression to an equivalent postfix expression.

	public static String convertToPostfix(String infix){

		Stack<Character> stack = new Stack<Character>();

		StringBuffer postfix = new StringBuffer();

		Character topOperator;
		for(int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
				
			if(Character.isLetterOrDigit(c))
				postfix.append(c);
					
			else
			{
				switch(c)

				{
				case '^':
					stack.push (c);
					break;
				case '+':
				case '-':
				case '*':
				case '/':
					while (!stack.isEmpty () &&
							getPrecedence(c) <= getPrecedence(stack.peek()))
					{
						postfix.append(stack.peek());
						stack.pop();
						
					}
					stack.push (c);
					break;

				case '(':
					stack.push (c);
					break;

				case ')':  // stack is not empty if infix expression is valid
					topOperator = stack.pop();
					while (topOperator != '(')
					{
						postfix.append(topOperator);
						topOperator = stack.pop();
					}
					break;
				default:
					break;
				}
			}
		}
			while (!stack.isEmpty())
			{
				topOperator = stack.pop();
				postfix.append(topOperator);
			}
			return postfix.toString();

		}



		/** Task: Determines the precedence of a given operator.
		 *  @param operator  a character that is (, ), +, -, *, /, or ^
		 *  @return an integer that indicates the precedence of operator: 
		 *          0 if ( or ), 1 if + or -, 2 if * or /, 3 if ^, -1 if 
		 *          anything else */
		private static int getPrecedence(char operator)
		{
			switch (operator)
			{
			case '(': case ')': return 0;
			case '+': case '-': return 1;
			case '*': case '/': return 2;
			case '^':           return 3;
			} // end switch

			return -1;
		} // end getPrecedence


		
	}