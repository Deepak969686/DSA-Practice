class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for(int num : nums) {

            int rem = num % k;

            long[] newDp = new long[k];

            // Start a new subarray with current number
            newDp[rem]++;

            // Extend previous subarrays
            for(int r = 0; r < k; r++) {

                int newRem = (r * rem) % k;

                newDp[newRem] += dp[r];
            }

            // Add current subarrays to answer
            for(int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            dp = newDp;
        }

        return ans;
    }
}