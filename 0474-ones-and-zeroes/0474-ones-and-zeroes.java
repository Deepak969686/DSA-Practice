class Solution {
    int len;
    int[][][] dp;

    public int findMaxForm(String[] strs, int m, int n) {
        len = strs.length;
        dp = new int[len][m + 1][n + 1];
        for (int[][] matrix : dp) {
            for (int[] rows : matrix) {
                Arrays.fill(rows, -1);
            }
        }
        return solve(0, strs, m, n);
    }

    int solve(int i, String[] s, int m, int n) {
        if (i >= len)
            return 0;
        String ch = s[i];
        int zeros = 0;
        int ones = 0;
        for (int j = 0; j < ch.length(); j++) {
            if (ch.charAt(j) == '0')
                zeros++;
            else
                ones++;
        }
        if (dp[i][m][n] != -1)
            return dp[i][m][n];

        int notTake = solve(i + 1, s, m, n);
        int take = 0;
        if (zeros <= m && ones <= n)
            take = 1 + solve(i + 1, s, m - zeros, n - ones);
        return dp[i][m][n] = Math.max(take, notTake);
    }
}