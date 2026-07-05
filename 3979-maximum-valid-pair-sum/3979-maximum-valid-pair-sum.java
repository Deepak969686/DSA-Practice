class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n=nums.length;
        int maxleft=nums[0];
        long ans=0;
        for(int j=k;j<n;j++){
            maxleft=Math.max(maxleft,nums[j-k]);
            ans=Math.max(ans,maxleft+nums[j]);
        }
        return (int)ans;
    }
}