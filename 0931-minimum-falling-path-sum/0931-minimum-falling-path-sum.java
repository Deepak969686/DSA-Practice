class Solution {
    int m, n;
    int[][] dp;
    boolean[][] visited;
    public int minFallingPathSum(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        visited=new boolean[m][n];
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, solve(0, j, matrix));
        }
        return ans;
    }

    int solve(int i, int j, int[][] matrix) {
        if (i == m - 1)
            return matrix[i][j];
        if (visited[i][j]) {
            return dp[i][j];
        }
        int leftdown = Integer.MAX_VALUE / 2;
        int down = Integer.MAX_VALUE / 2;
        int rightdown = Integer.MAX_VALUE / 2;
        if (j - 1 >= 0)
            leftdown = solve(i + 1, j - 1, matrix);
        down = solve(i + 1, j, matrix);
        if (j + 1 < n)
            rightdown = solve(i + 1, j + 1, matrix);
        
        visited[i][j]=true;
        return dp[i][j] =matrix[i][j] +Math.min(leftdown, Math.min(down, rightdown));
    }
}