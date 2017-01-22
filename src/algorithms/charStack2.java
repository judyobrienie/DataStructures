package algorithms;



import java.util.*;

public class charStack2 {
	public static void main (String[] args){
		
    
    System.out.println(check("{(judy,obrien)}"));
    System.out.println(check("((judy, obrien)))"));
    System.out.println(check("((judy, obrien))]"));
    System.out.println(check("([{judy, obrien}])"));
	}
    
    public static boolean check(String s) {
       
	Stack<Character> stack = new Stack<Character>();
	
	 for(int i = 0; i < s.length(); i++) {
		 
         char c = s.charAt(i);
         if(c == '[' || c == '(' || c == '{' ) {

             stack.push(c);

         }else if(c == ']') {
             if(stack.isEmpty()) return false;
             if(stack.pop() != '[') return false;

         }else if(c == ')') {
             if(stack.isEmpty()) return false;
             if(stack.pop() != '(') return false;

         }else if(c == '}') {
             if(stack.isEmpty()) return false;
             if(stack.pop() != '{') return false;
         }

     }
     return stack.isEmpty();
 }
}