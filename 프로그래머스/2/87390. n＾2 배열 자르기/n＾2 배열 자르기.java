import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] answer = new int[size];
        
        for(int i=0; i<answer.length; i++) {
            long cur = i + left;
            answer[i] = (int) Math.max(cur/n + 1, cur%n + 1);
        }
        
        
        return answer;
    }
}