package algorithms;
import java.util.Stack;



/**
 * @author Judy
 *
 */
public class convertToPostfix {
	public static void main (String[] args){

		System.out.println(convertPostfix("A*B-(C+D)+E"));
		System.out.println(convertPostfix("A+B*C"));
		System.out.println(convertPostfix("x ^ y / (5 * z) + 10")); 
		System.out.println(convertPostfix("A+B*C"));
		System.out.println(convertPostfix("a+b*c-d"));
		System.out.println(convertPostfix("11+2"));
		
	}	



	//Algorithm convertToPostfix (infix)
	// Converts an infix expression to an equivalent postfix expression.

	public static String convertPostfix(String infix){
		
		Stack<Character> operatorStack = new Stack<Character>();

		StringBuffer postfix = new StringBuffer();
		
		Character topOperator;
		
		for(int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
		if(Character.isLetterOrDigit(c))
			postfix.append(c);
		    if (i+1 >= infix.length() || !Character.isLetterOrDigit(infix.charAt(i+1)))
                     postfix.append(" ");
		
			else
				
				
			{
				switch(c)

				{
				case '^':
					operatorStack.push (c);
					break;
				case '+':
				case '-':
				case '*':
				case '/':
					while (!operatorStack.isEmpty () &&
							getPrecedence(c) <= getPrecedence(operatorStack.peek()))
					{
						postfix.append(operatorStack.peek() + " ");
						operatorStack.pop();
						
					}
					operatorStack.push (c);
					break;

				case '(':
					operatorStack.push (c);
					break;

				case ')':  // stack is not empty if infix expression is valid
					topOperator = operatorStack.pop();
					while (topOperator != '(')
					{
						postfix.append(topOperator + " ");
						topOperator = operatorStack.pop();
						
					}
					break;
				default:
					break;
				}
			}
		}
			while (!operatorStack.isEmpty())
			{
				topOperator = operatorStack.pop();
				postfix.append(topOperator + " ");
			
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