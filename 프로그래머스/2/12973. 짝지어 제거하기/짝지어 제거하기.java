import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            
            if(stack.isEmpty()){
                stack.push(cur);
            } else if(stack.peek() == cur){
                stack.pop();
            } else{
                stack.push(cur);
            }
        }
        
        if(stack.isEmpty()){
            return 1;
        } else{
            return 0;
        }
    }
    
//     public String rRemove(String s){
        
//         if(s.length() == 0){
//             return s;
//         }
//         boolean flag = false;
//         StringBuilder sb = new StringBuilder();
        
//         for(int i=0; i<s.length() - 1; i++){
//             char c1 = s.charAt(i);
//             char c2 = s.charAt(i+1);
            
//             if(c1 != c2){
//                 sb.append(c1);
//             } else{
//                 i += 2;
//                 flag = true;
//             }
//         }
//         System.out.println(sb);
        
//         if(flag){
//             return rRemove(sb.toString());
//         } else{
//             return sb.toString();
//         }
//     }
}