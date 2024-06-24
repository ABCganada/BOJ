import java.util.*;

public class Solution {
    int[] dp;
    
    public int solution(int n) {
//         dp = new int[n+1];
        
//         dp[1] = dp[2] = 1;
//         for(int i=3; i<=n; i++){
//             if(i%2 == 0){
//                 dp[i] = dp[i/2];
//             } else{
//                 dp[i] = dp[i-1] + 1;
//             }
//         }
        
        if(n == 1){
            return 1;
        } else if(n == 2){
            return 1;
        }
        
        int ans = 0;
        while(n != 0){
            if(n%2 == 0){
                n /= 2;
            } else{
                n -= 1;
                ans++;
            }
        }
        
        return ans;
    }
}