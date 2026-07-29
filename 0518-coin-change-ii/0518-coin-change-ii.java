class Solution {
    int[][] dp;
    int n;
    public int change(int amount, int[] coins) {
        n=coins.length;
        dp=new int[n+1][amount+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        return solve(0,amount,coins);
    }
    private int solve(int i,int amount,int[] coins){
        if(i==n) return 0;
        if(amount==0) return 1;
        if(dp[i][amount]!=-1) return dp[i][amount];
        if(coins[i]>amount) return solve(i+1,amount,coins);
        int take=solve(i,amount-coins[i],coins);
        int notTake=solve(i+1,amount,coins);
        return dp[i][amount]=take+notTake;
    }
}