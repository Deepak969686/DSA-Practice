class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;

        int[] maxdp=new int[n];
        int[] mindp=new int[n];
        maxdp[0]=nums[0];
        mindp[0]=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
            maxdp[i]=Math.max(nums[i],Math.max(nums[i]*maxdp[i-1],nums[i]*mindp[i-1]));
            mindp[i]=Math.min(nums[i],Math.min(nums[i]*maxdp[i-1],nums[i]*mindp[i-1]));
            ans = Math.max(ans, maxdp[i]);
        }
        return ans;
        // int leftprod=1;
        // int rightprod=1;
        // int ans=nums[0];
        // for(int i=0;i<n;i++){
        //     leftprod=leftprod==0?1:leftprod;
        //     rightprod=rightprod==0?1:rightprod;
            
        //     leftprod=leftprod*nums[i];
        //     rightprod=rightprod*nums[n-1-i];
        //     ans=Math.max(ans,Math.max(leftprod,rightprod));
        // }
        // return ans;
    }
}