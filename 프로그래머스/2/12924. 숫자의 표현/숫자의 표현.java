class Solution {
    
    int[] map;
    
    public int solution(int n) {
        int answer = 0;
        
        map = new int[n+1];
        
        for(int i=1; i<=n; i++){
            map[i] = map[i-1] + i;
            
            if(map[i] > n){
                break;
            }
            
            if((n - map[i]) % i == 0){
                answer++;
            }
        }
        
//         for(int i=2; i<=n; i++){
//             map[i][1] = map[i-1][1] + i;
            
//             if(map[i][1] == n){
//                 answer++;
//                 break;
//             } else if(map[i][1] > n){
//                 break;
//             }
            
//             for(int j=2; j<=n-i; j++){
//                 map[i][j] = map[i][j-1] + i;
                
//                 if(map[i][j] == n){
//                     answer++;
//                     break;
//                 } else if(map[i][j] > n){
//                     break;
//                 }
//             }
//         }
        
        // for(int i=1; i<=n; i++){
        //     System.out.print(" " + map[i]);
        // }
        // System.out.println();
        
        return answer;
    }
}