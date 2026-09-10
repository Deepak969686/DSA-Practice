class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        dp=new Boolean[nums.length];
        return solve(0, nums);
    }
    boolean solve(int i, int[] nums) {
        if (i >= nums.length - 1)
            return true;
        if(dp[i]!=null) return dp[i]; 
        for (int jump = 1; jump <= nums[i]; jump++) {
            if (solve(i + jump, nums))
                return dp[i]= true;
        }
        return dp[i]= false;
    }
}