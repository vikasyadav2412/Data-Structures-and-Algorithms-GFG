class Solution {
    public int countIncreasing(int[] arr) {
        // code here
        int len = 1;
        int ans = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
                ans += (len - 1);
            } else {
                len = 1;
            }
        }
        
        return ans;
    }
}
