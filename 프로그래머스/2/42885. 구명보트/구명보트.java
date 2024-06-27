import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int turn = 0;
        // boolean[] visit = new boolean[people.length]; 
        
        Arrays.sort(people);    //오름차순
        
        int f = 0;
        int r = people.length-1;
        
        while(f <= r){
            turn++;
            if(people[f] <= limit - people[r]){
                f++;
            }
            r--;
        }
        
        // for(int i=people.length-1; i>=0; i--){  //무거운 놈부터 체크
        //     if(!visit[i]){
        //         turn++;
        //         visit[i] = true;
        //         for(int j=0; j<i; j++){ //가벼운 놈 체크
        //             if(!visit[j] && people[j] <= limit - people[i]){
        //                 visit[j] = true;
        //                 break;
        //             }
        //         }
        //     } else{
        //         break;
        //     }
        // }
        return turn;
    }
}