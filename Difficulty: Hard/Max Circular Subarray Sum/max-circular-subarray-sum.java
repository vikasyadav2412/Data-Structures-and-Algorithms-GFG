class Solution {
    public int maxCircularSum(int arr[]) {
        int totalSum = 0;
        int currMax = 0, maxSum = Integer.MIN_VALUE;
        int currMin = 0, minSum = Integer.MAX_VALUE;

        for (int num : arr) {
            totalSum += num;

            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }

        if (maxSum < 0) return maxSum; // all elements negative

        return Math.max(maxSum, totalSum - minSum);
    }
}
