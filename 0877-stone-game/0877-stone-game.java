class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        dp=new int[n][n];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        int sum=0;
        for(int p:piles) sum+=p;
        int alice=solve(0,n-1,piles);
        int bob=sum-alice;
        return alice>bob;
    }
    int solve(int i,int j,int[] piles){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int take_i=piles[i]+Math.min(solve(i+2,j,piles),solve(i+1,j-1,piles));
        int take_j=piles[j]+Math.min(solve(i+1,j-1,piles),solve(i,j-1,piles));
        return dp[i][j]=Math.max(take_i,take_j);
    }
}
