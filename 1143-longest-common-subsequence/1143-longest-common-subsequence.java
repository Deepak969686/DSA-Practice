class Solution {
    int[][] dp;
    int m,n;
    public int longestCommonSubsequence(String text1, String text2) {
        m=text1.length();
        n=text2.length();
        dp=new int[m+1][n+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        return solve(0,0,text1,text2);
    }
    int solve(int i,int j,String s1,String s2){
        if(i==s1.length() || j==s2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return 1+solve(i+1,j+1,s1,s2);
        return dp[i][j]=Math.max(solve(i+1,j,s1,s2),solve(i,j+1,s1,s2));
    }
}