package tools;

import java.util.Stack;

public class NumberFormatter {
    public NumberFormatter(){}
    public String format(Integer number){
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < number.toString().length() ; i++){
            stack.push(number.toString().charAt(i));
        }
        String res = "";
        while(stack.size() > 3){
            for(int i = 0; i < 3; i++) res = stack.pop() + res;
            res = "." + res;
        }
        while(!stack.isEmpty()) res = stack.pop() + res;
        return res;
    }
}

