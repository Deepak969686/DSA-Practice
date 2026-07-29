class Solution {
    int[][] dp;
    int n;
    int INF = (int)1e9;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        dp = new int[n + 1][amount + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int ans = solve(0, amount, coins);
        return ans >= INF ? -1 : ans;
    }
    private int solve(int i, int amount, int[] coins) {
        if (amount == 0)
            return 0;
        if (i == n)
            return INF;
        if (dp[i][amount] != -1)
            return dp[i][amount];
        int take = INF;
        if (coins[i] <= amount)
            take = 1 + solve(i, amount - coins[i], coins);
        int notTake = solve(i + 1, amount, coins);
        return dp[i][amount] = Math.min(take, notTake);
    }
}