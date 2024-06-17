import java.util.Stack;

class Solution {
    
    Stack<Character> stack = new Stack<>();
    
    boolean solution(String s) {
        boolean answer = true;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}