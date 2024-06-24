class Solution {
    
    public int[] solution(String s) {
        int cnt = 0;
        int del0 = 0;
        
        while(!s.equals("1")){
            cnt++;
            int length1 = 0;
            
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    length1++;
                } else{
                    del0++;
                }
            }
            
            s = Integer.toBinaryString(length1);
        }
        
        return new int[]{cnt, del0};
    }
}