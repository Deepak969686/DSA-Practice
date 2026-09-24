class Solution {
    int n;
    int[][] dp;
    public int lastStoneWeightII(int[] stones) {
        n = stones.length;
        int totalSum = 0;
        for(int num : stones) {
            totalSum += num;
        }
        int target = totalSum / 2;
        dp = new int[n][target + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(0, 0, stones, totalSum, target);
    }
    private int solve(int i, int sum1, int[] stones,int totalSum, int target) {
        if(i == n) {
            int sum2 = totalSum - sum1;
            return Math.abs(sum1 - sum2);
        }
        if(dp[i][sum1] != -1) return dp[i][sum1];
        int notTake = solve(i + 1, sum1,stones, totalSum, target);
        int take = Integer.MAX_VALUE;
        if(sum1 + stones[i] <= target) {
            take = solve(i + 1, sum1 + stones[i], stones, totalSum, target);
        }
        return dp[i][sum1] = Math.min(take, notTake);
    }
}