package algorithms;

import java.util.Stack;

public class charStack {


		public static void main (String[] args){
				
			System.out.println(check("{(judy,obrien))}"));
		    System.out.println(check("[{(judy,obrien)}]"));
		    System.out.println(check("[{((((judy,obrien)}]"));
		    System.out.println(check("{]"));
	}


		
		
public static boolean check(String s){
	
	Stack<Character> stack = new Stack<Character>();
	
	boolean isBalanced = true;
	
   
    	
    
		 for(int i = 0; i < s.length(); i++) {
		  char c = s.charAt(i);
		  switch(c)
	      {
		    case '(':
	        case '[':
	        case '{':
	        	stack.push(c);
	            break;
	            
	         case ')':
	         case ']':
	         case '}':
	                if (stack.isEmpty())
	                    isBalanced = false;
	                 else
	                {
	                	char openDelimiter = stack.pop();
	                
	                	isBalanced = isPaired (openDelimiter, c);
	                } // end else
	                break;
	            default:
	                break;
	    
	} // end switch
	} // end for
    

	if (!stack.isEmpty())
	    isBalanced = false;
	
	return isBalanced;
	
	}


	 private static boolean isPaired (char openDelimiter, char c)
	    {
	        return (openDelimiter == '(' && c == ')') ||
	        	   (openDelimiter == '[' && c == ']') ||
	               (openDelimiter == '{' && c == '}');
	    } // end isPaired
	

}

