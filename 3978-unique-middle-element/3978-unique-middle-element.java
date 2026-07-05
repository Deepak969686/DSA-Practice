class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int m=(r-l)/2;
        int me=nums[m];
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==me) count++;
        }
        return count==1;
    }
}