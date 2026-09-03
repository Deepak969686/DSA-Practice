class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE;
        for(int num:nums1){
            min=Math.min(min,num);
        }
        for(int x:nums1){
            if(x%2==min%2){
                continue;
            }
            int val=x-min;
            if(val%2!=min%2) return false;
        }
        return true;
    }
}