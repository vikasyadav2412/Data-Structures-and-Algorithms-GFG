import java.util.*;

class Solution {
    public int countBalanced(String[] arr) {
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        
        int n = arr.length;
        int[] diff = new int[n];
        
        for (int i = 0; i < n; i++) {
            int vowel = 0, consonant = 0;
            for (char ch : arr[i].toCharArray()) {
                if (vowelsSet.contains(ch)) vowel++;
                else consonant++;
            }
            diff[i] = vowel - consonant;
        }
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        int prefixSum = 0, count = 0;
        
        for (int val : diff) {
            prefixSum += val;
            if (freqMap.containsKey(prefixSum)) {
                count += freqMap.get(prefixSum);
            }
            freqMap.put(prefixSum, freqMap.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}
