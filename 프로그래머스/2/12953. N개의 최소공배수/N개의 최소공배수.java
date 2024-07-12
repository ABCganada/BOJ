import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        Arrays.sort(arr);
        
        for(int i=1; i<arr.length; i++){
            if(arr[i]%answer == 0){
                answer = arr[i];
            } else{
                for(int j=2; j<=answer; j++){
                    int cur = arr[i] * j;
                    if(cur%answer == 0){
                        answer = cur;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}