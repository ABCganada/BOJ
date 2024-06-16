class Solution {
    int min, max;
    public String solution(String s) {
        String[] tmp = s.split(" ");
        
        min = max = Integer.parseInt(tmp[0]);
        
        for(int i=1; i<tmp.length; i++){
            int num = Integer.parseInt(tmp[i]);
            
            if(min > num) min = num;
            if(max < num) max = num;
        }
        
            
        String answer = min + " " + max;
        return answer;
    }
}