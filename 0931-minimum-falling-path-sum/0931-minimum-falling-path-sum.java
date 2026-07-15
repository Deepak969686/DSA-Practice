class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Base Case
        for (int col = 0; col < n; col++) {
            dp[n - 1][col] = matrix[n - 1][col];
        }

        // Fill DP from bottom to top
        for (int r = n - 2; r >= 0; r--) {
            for (int c = 0; c < n; c++) {

                int down = dp[r + 1][c];

                int downLeft = (c > 0) ? dp[r + 1][c - 1] : Integer.MAX_VALUE;

                int downRight = (c < n - 1) ? dp[r + 1][c + 1] : Integer.MAX_VALUE;

                dp[r][c] = matrix[r][c] +
                        Math.min(down, Math.min(downLeft, downRight));
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            ans = Math.min(ans, dp[0][col]);
        }

        return ans;
    }
}

// class Solution {
//     int n;
//     int[][] dp;
//     public int minFallingPathSum(int[][] matrix) {
//         n = matrix.length;
//         int ans = Integer.MAX_VALUE;
//         dp=new int[n][n];

//         for (int[] row : dp) {
//             Arrays.fill(row, Integer.MAX_VALUE);
//         }

//         for (int col = 0; col < n; col++) {
//             ans = Math.min(ans, solve(matrix, 0, col));
//         }
//         return ans;
//     }
//     private int solve(int[][] matrix, int r, int c) {
//         if (c < 0 || c >= n)
//             return Integer.MAX_VALUE;
//         if (r == n - 1)
//             return matrix[r][c];
//         if(dp[r][c]!=Integer.MAX_VALUE) return dp[r][c];
//         int downLeft = solve(matrix, r + 1, c - 1);
//         int down = solve(matrix, r + 1, c);
//         int downRight = solve(matrix, r + 1, c + 1);
//         return dp[r][c]=matrix[r][c] +Math.min(downLeft, Math.min(down, downRight));
//     }
// }