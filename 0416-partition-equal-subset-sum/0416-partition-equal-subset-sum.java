class Solution {
    int n;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        n=nums.length;
        int total=0;
        for(int num:nums) total+=num;
        if(total%2!=0) return false;
        int target=total/2;
        dp=new Boolean[n][target+1];
        return solve(0,nums,target);
    }
    boolean solve(int i,int[] nums,int target){
        if(target==0) return true;
        if(i>=n) return false;
        if(dp[i][target]!=null) return dp[i][target];
        boolean notTake=solve(i+1,nums,target);
        boolean take=false;
        if(nums[i]<=target){
            take=solve(i+1,nums,target-nums[i]);
        }
        return dp[i][target]= take || notTake;
    }
}