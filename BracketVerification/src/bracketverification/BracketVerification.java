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
        Stack<Character> stack = new Stack<>(); //declare new Stack
        String str = "{()()(/)()}"; //declare and initialize a string of brackets
        boolean validBracket = true; // declare and initialize a boolean to return if brakcets are valid
        
        for(int i = 0; i < str.length(); i++){//a for loop to iterate over the string to push to the stack
            stack.push(str.charAt(i));
        }
        
        for(int i = 0; i < str.length(); i++){//a for loop to iterate the string
            char strCurrent = str.charAt(i);//set strCurrent as the current character of the String
            char stackCurrent = stack.peek();//set stackCurrent as the top character without removing it
            if(strCurrent == '{' && stackCurrent == '}' || (strCurrent == '}' && stackCurrent == '{')){
                validBracket = true;//if the brackets in str and stack are mirrors, then it is valide and moves on
                stack.pop();// if it is valide, we pop the top char so that we can check the next one
            }
            else if(strCurrent == '[' && stackCurrent == ']' || (strCurrent == ']' && stackCurrent == '[')){
                validBracket = true;//same as before but with different bracket type
                stack.pop();
            }
            else if(strCurrent == '(' && stackCurrent == ')' || (strCurrent == ')' && stackCurrent == '(')){
                validBracket = true;
                stack.pop();
            }
            else if(stack.isEmpty()){
                validBracket = true;//without this the validBracket returns false becuase there is no matching brackets - this occurs once all stack is removed
                stack.pop();
            }
            else{
              validBracket = false;//if there is no mirror in the brackets, it is false
              break;
            }
        }
        System.out.println("Brackets Valid:" +validBracket);
    }
}
