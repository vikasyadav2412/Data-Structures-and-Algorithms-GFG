import java.util.*;

class Solution {
    public ArrayList<Integer> asciirange(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (first[idx] == -1) first[idx] = i;
            last[idx] = i;
        }

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (int) s.charAt(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && last[i] > first[i]) {
                int sum = prefix[last[i]] - prefix[first[i] + 1];
                if (sum > 0) result.add(sum);
            }
        }
        return result;
    }
}
