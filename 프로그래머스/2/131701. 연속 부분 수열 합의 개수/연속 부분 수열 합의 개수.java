import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> e = new LinkedList<>();
        for(int i=0; i<elements.length; i++) {
            e.add(elements[i]);
        } 
        
        while(cnt < elements.length) {
            int n = 0;
            for(int i=0; i<elements.length; i++) {
                n += e.get(i);
                if(!map.containsKey(n)) {
                    map.put(n, 1);
                    answer++;
                }
            }
            
            int target = e.removeFirst();
            e.add(target);
            cnt++;
        }
        
        return answer;
    }
}