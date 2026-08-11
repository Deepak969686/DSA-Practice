class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currMax = 0;
        int maxSum = Integer.MIN_VALUE;
        int currMin = 0;
        int minSum = Integer.MAX_VALUE;
        for (int num : nums) {
            totalSum += num;
            // Kadane for maximum subarray
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);
            // Kadane for minimum subarray
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }
        // All elements are negative
        if (maxSum < 0) {
            return maxSum;
        }
        // Maximum circular subarray
        int circularSum = totalSum - minSum;
        return Math.max(maxSum, circularSum);
    }
}