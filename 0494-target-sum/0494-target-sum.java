class Solution {
    int n;
    public int findTargetSumWays(int[] nums, int target) {
        n=nums.length;
        return solve(0,0,nums,target);
    }
    private int solve(int i,int currsum,int[] nums,int target){
        if(i==n){
            if(target==currsum) return 1;
            else return 0;
        }
        int plus=solve(i+1,currsum+nums[i],nums,target);
        int minus=solve(i+1,currsum-nums[i],nums,target);
        return plus+minus;
    }
}