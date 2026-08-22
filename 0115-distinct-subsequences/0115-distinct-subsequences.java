class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        if(s.length()<t.length()) return 0;
        dp=new int[s.length()+1][t.length()+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        return solve(0,0,s,t);
    }
    int solve(int i,int j,String s,String t){
        if(j==t.length()) return 1;
        if (i == s.length() ) {
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) {
            int take=solve(i+1,j+1,s,t);
            int skip=solve(i+1,j,s,t);
            return dp[i][j]= take+skip;
        }
        return dp[i][j]= solve(i+1,j,s,t);
    }
}