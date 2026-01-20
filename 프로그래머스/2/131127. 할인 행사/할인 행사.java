import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int day = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        if(check(want, number, map)) {
            day++;
        }
        
        for(int i=10; i<discount.length; i++) {
            String rmWant = discount[i-10];
            String addWant = discount[i];
            map.put(rmWant, map.get(rmWant) - 1);
            map.put(addWant, map.getOrDefault(addWant, 0) + 1);
            
            if(check(want, number, map)) {
                day++;
            }
            
        }
        
        
        return day;
    }
    
    public boolean check(String[] want, int[] number, HashMap<String, Integer> current) {
        for(int i=0; i<want.length; i++) {
            if(current.getOrDefault(want[i], 0) != number[i]) {
                return false;
            }
        }
        
        return true;
    }
}