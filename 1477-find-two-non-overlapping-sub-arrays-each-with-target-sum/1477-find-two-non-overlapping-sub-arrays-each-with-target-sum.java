class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = 1000000;

        // dp[i] = minimum length of a valid subarray
        // completely inside indices [0 ... i-1]
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);

        int left = 0;
        int sum = 0;
        int ans = INF;

        for(int right = 0; right < n; right++) {

            sum += arr[right];

            while(sum > target) {
                sum -= arr[left];
                left++;
            }

            // Found a subarray [left ... right]
            if(sum == target) {

                int len = right - left + 1;

                // Previous non-overlapping subarray
                if(dp[left] != INF) {
                    ans = Math.min(ans, len + dp[left]);
                }

                // Store current subarray as best one ending here
                dp[right + 1] = Math.min(dp[right], len);
            }
            else {
                dp[right + 1] = dp[right];
            }
        }

        return ans == INF ? -1 : ans;
    }
}