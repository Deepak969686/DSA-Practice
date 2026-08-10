class Solution {
    int m,n;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        m=word1.length();
        n=word2.length();
        dp=new int[m][n];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        return solve(0,0,word1,word2);
    }
    int solve(int i,int j,String s1,String s2){
        if(i==m) return n-j;
        if(j==n) return m-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return solve(i+1,j+1,s1,s2);
        }
        int insert=1+solve(i,j+1,s1,s2);
        int delete=1+solve(i+1,j,s1,s2);
        int replace=1+solve(i+1,j+1,s1,s2);
        return dp[i][j]= Math.min(insert,Math.min(delete,replace));
    }
}