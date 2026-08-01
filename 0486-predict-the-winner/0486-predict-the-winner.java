class Solution {
    int[][] dp;
    int n;
    public boolean predictTheWinner(int[] nums) {
        n=nums.length;
        dp=new int[n+1][n+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        return solve(nums, 0, n-1) >= 0;
    }
    private int solve(int[] nums,int i,int j){
        if(i==j) return nums[i];
        if(dp[i][j]!=-1) return dp[i][j];
        int take_i=nums[i]-solve(nums,i+1,j);
        int take_j=nums[j]-solve(nums,i,j-1);
        return Math.max(take_i,take_j);
    }
}