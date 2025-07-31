import java.util.*;

class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
     
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            map.put(l, map.getOrDefault(l, 0) + 1);
            map.put(r + 1, map.getOrDefault(r + 1, 0) - 1);
        }
        
        int active = 0;
        int prev = -1;
        int answer = -1;
        
        // Step 2: Sweep line
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int point = entry.getKey();
            
            if (active >= k) {
              
                answer = point - 1; 
            }
            
            active += entry.getValue();
            prev = point;
        }
        
        return answer;
    }
}
