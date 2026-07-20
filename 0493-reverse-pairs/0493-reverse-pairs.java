class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    private int countPair(int[] nums,int low,int mid,int high){
        int right=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && nums[i]>2L*nums[right]){
                right++;
            }
            count+=(right-(mid+1));
        }
        return count;
    }
    private int mergeSort(int[] nums, int low, int high) {
        int count=0;
        if (low >= high)return count;
        int mid = low + (high - low) / 2;
        count+=mergeSort(nums, low, mid);
        count+=mergeSort(nums, mid + 1, high);
        count+=countPair(nums,low,mid,high);
        merge(nums, low, mid, high);
        return count;
    }

    private void merge(int[] nums,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        int[] temp = new int[high - low + 1];
        int i=0;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
            temp[i++]=nums[left++];
            } else{
                temp[i++]=nums[right++];
            }
        }
        while(left<=mid){
            temp[i++]=nums[left++];
        } 
        while(right<=high){
            temp[i++]=nums[right++];
        }
        for(int j=low;j<=high;j++){
            nums[j]=temp[j-low];
        }
    }
}