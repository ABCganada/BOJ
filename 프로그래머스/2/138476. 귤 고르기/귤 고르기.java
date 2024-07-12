import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        
        int[] tmp = new int[tangerine[tangerine.length - 1] + 1];
        
        for(int i=0; i<tangerine.length; i++){
            tmp[tangerine[i]]++;
        }
        
        Arrays.sort(tmp);
        
        for(int i=tmp.length - 1; i>=0; i--){
            k -= tmp[i];
            answer++;
            
            if(k <= 0){
                break;
            }
        }
        
        return answer;
    }
}