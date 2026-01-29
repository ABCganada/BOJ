import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
            set.add(clothes[i][1]);
        }
        
        String[] list = set.toArray(new String[0]);
        
        int[] n = new int[map.size()];
        for (int i = 0; i < map.size(); i++) {
            n[i] = map.get(list[i]);
        }
        
        int sum = 1;
        for (int i = 0; i < n.length; i++) {
            sum *= (n[i] + 1);
        }
        
        return sum - 1;
    }
}