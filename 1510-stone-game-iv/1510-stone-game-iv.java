class Solution {
    int[] dp;
    public boolean winnerSquareGame(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
    boolean solve(int n) {
        // No stones -> current player loses
        if (n == 0) {
            return false;
        }
        // Already calculated
        if (dp[n] != -1) {
            return dp[n] == 1;
        }
        // Try every square number
        for (int i = 1; i * i <= n; i++) {
            int remaining = n - i * i;
            // If opponent loses, current player wins
            if (!solve(remaining)) {
                dp[n] = 1;
                return true;
            }
        }
        // No winning move
        dp[n] = 0;
        return false;
    }
}