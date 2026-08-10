class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n+1][n+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        System.out.println(solve(0,-1,nums));
        return solve(0,-1,nums);
    }
    int solve(int i,int prev,int[] nums){
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int notTake=solve(i+1,prev,nums);
        int take=0;
        if(prev==-1 || nums[i]>nums[prev]){
            take=1+solve(i+1,i,nums);
        }
        return dp[i][prev+1]=Math.max(take,notTake);
    }
}