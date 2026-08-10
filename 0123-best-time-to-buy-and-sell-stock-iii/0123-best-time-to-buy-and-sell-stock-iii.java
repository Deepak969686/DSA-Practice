class Solution {
    int n;
    int[][][] dp;
    public int maxProfit(int[] prices) {
        n=prices.length;
        dp=new int[n][2][3];
        for(int[][] matrix:dp){
            for(int[] rows:matrix) Arrays.fill(rows,-1);
        }
        return solve(0,1,2,prices);
    }
    int solve(int i,int buy,int count,int[] prices){
        if(i==n || count==0) return 0;
        if(dp[i][buy][count]!=-1) return dp[i][buy][count];
        if(buy==1){
            return dp[i][buy][count]= Math.max(-prices[i]+solve(i+1,0,count,prices),solve(i+1,1,count,prices));
        } else{
            return dp[i][buy][count]= Math.max(prices[i]+solve(i+1,1,count-1,prices),solve(i+1,0,count,prices));
        }
    }
}