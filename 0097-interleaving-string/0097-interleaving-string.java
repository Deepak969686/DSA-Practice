class Solution {
    int n, m, N;
    Boolean[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();
        N = s3.length();
        dp=new Boolean[n+1][m+1][N+1];
        if (n + m != N) return false;
        return solve(0, 0, 0, s1, s2, s3);
    }
    boolean solve(int i, int j, int k,String s1, String s2, String s3) {
        if (i == n && j == m && k == N) {
            return true;
        }
        if (k >= N) {
            return false;
        }
        if(dp[i][j][k]!=null) return dp[i][j][k];
        boolean result = false;
        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            result = solve(i + 1, j, k + 1, s1, s2, s3);
        }
        if (result) {
            return dp[i][j][k]= true;
        }
        if (j < m && s2.charAt(j) == s3.charAt(k)) {
            result = solve(i, j + 1, k + 1, s1, s2, s3);
        }
        return dp[i][j][k]= result;
    }
}