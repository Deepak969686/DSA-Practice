class Solution {
    int m, n;
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        dp=new Boolean[m][n];
        return solve(m - 1, n - 1, s, p);
    }
    boolean solve(int i, int j, String s, String p) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (j < 0) {
            return false;
        }
        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
            return dp[i][j]= solve(i - 1, j - 1, s, p);
        }
        if (p.charAt(j) == '*') {
            return dp[i][j]= solve(i - 1, j, s, p) || solve(i, j - 1, s, p);
        }

        return dp[i][j]  =false;
    }
}