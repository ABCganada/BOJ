class Solution {
    
    StringBuilder sb = new StringBuilder();
    
    public String solution(String s) {
        
        boolean flag = false;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                sb.append(" ");
                flag = false;
                continue;
            }
            
            if(!flag){
                if(Character.isLowerCase(s.charAt(i))){
                    sb.append(Character.toUpperCase(s.charAt(i)));
                } else{
                    sb.append(s.charAt(i));
                }
                flag = true;
            } else{
                if(Character.isUpperCase(s.charAt(i))){
                    sb.append(Character.toLowerCase(s.charAt(i)));
                } else{
                   sb.append(s.charAt(i)) ;
                }
            }
        }
        
        return sb.toString();
    }
}