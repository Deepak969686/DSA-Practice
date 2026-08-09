class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        dp=new int[n+1][n+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        String rev = new StringBuilder(s).reverse().toString();
        return solve(0,0,s,rev);
    }
        int solve(int i,int j,String s1,String s2){
        if(i==s1.length() || j==s2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return 1+solve(i+1,j+1,s1,s2);
        return dp[i][j]=Math.max(solve(i+1,j,s1,s2),solve(i,j+1,s1,s2));
    }
}