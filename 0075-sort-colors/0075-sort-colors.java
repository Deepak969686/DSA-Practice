class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int l=0;
        int m=0;
        int r=n-1;
        while(m<=r){
            if(nums[m]==0){
                swap(nums,l,m);
                l++;
                m++;
            } else if(nums[m]==1) m++;
            else{
                swap(nums,m,r);
                r--;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}