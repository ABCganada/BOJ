import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Integer[] c = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(c, Collections.reverseOrder());
        
        int hIdx = 0;
        for(Integer i : c) {
            hIdx++;
            if(i < hIdx) {
                return hIdx-1;
            }
        }
        return hIdx;
    }
}