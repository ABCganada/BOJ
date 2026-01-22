import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        char[] ds = new char[len*2];
        for(int i=0; i<len; i++) {
            ds[i] = ds[i+len] = s.charAt(i);
        }
        
        for(int i=0; i<len; i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            
            for(int j=i; j<len+i; j++) {
                char cur = ds[j];
                
                if(stack.isEmpty()) {
                    if(!isOpen(cur)) {
                        flag = false;
                        break;
                    } else {
                        stack.push(cur);
                    }
                } else {
                    if(isMatch(stack.peek(), cur)) {
                        stack.pop();
                    } else {
                        if(isOpen(stack.peek())) {
                            if(isOpen(cur)) {
                                stack.push(cur);
                            } else {
                                flag = false;
                                break;
                            }
                        } else {
                            stack.push(cur);
                        }
                    }
                    
                }
            }
            
            if(stack.isEmpty() && flag) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isOpen(char c) {
        if(c == '{' || c == '[' || c == '(') {
            return true;
        }
        
        return false;
    }
    
    public boolean isMatch(char c1, char c2) {
        if(c1 == '{' && c2 == '}' || c1 == '[' && c2 == ']' || c1 == '(' && c2 == ')') {
            return true;
        }
        
        return false;
    }
}