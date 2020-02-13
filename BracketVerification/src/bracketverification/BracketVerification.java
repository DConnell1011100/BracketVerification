/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bracketverification;
import java.util.Stack;
/**
 *
 * @author danco
 */
public class BracketVerification {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String str = "{]}";
        boolean validBracket = true;
        
        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));
        }
        
        for(int i = 0; i < str.length(); i++){
            char strCurrent = str.charAt(i);
            char stackCurrent = stack.peek();
            if(strCurrent == '{' && stackCurrent == '}' || (strCurrent == '}' && stackCurrent == '{')){
                validBracket = true;
                stack.pop();
            }
            else if(strCurrent == '[' && stackCurrent == ']' || (strCurrent == ']' && stackCurrent == '[')){
                validBracket = true;
                stack.pop();
            }
            else if(strCurrent == '(' && stackCurrent == ')' || (strCurrent == ')' && stackCurrent == '(')){
                validBracket = true;
                stack.pop();
            }
            else if(stack.isEmpty()){
                validBracket = true;
                stack.pop();
            }
            else{
              validBracket = false;
              break;
            }
        }
        System.out.println("Brackets Valid:" +validBracket);
    }
}
