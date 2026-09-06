class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        Arrays.sort(nums);
        // l-> smallest divisor, r-> largest divisor
        int l=1;
        int r=nums[n-1];
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canDivisible(nums,mid,threshold)){
                r=mid-1;
            } else{
                l=mid+1;
            }
        }
        return l;
    }
    boolean canDivisible(int[] nums,int divisor,int threshold){
        int sum=0;
        for(int num:nums){
            sum+=(num+divisor-1)/divisor;
            if(sum>threshold) return false;
        }
        return true;
    }
}