class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];
        if (n == 1) return nums[0];
        Arrays.fill(dp,-1);
        int zeroI=solve(0,n-2,nums);
        Arrays.fill(dp,-1);
        int oneI=solve(1,n-1,nums);
        return Math.max(zeroI,oneI);
    }
    int solve(int i,int end,int[] nums){
        if(i>end) return 0;
        if(dp[i]!=-1) return dp[i];
        int notTake=solve(i+1,end,nums);
        int take=nums[i]+solve(i+2,end,nums);
        return dp[i]=Math.max(take,notTake);
    }
}