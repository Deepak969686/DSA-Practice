class Solution {
    public int maxDigitRange(int[] nums) {
        int maxrange=Integer.MIN_VALUE;
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int temp=nums[i];
            int mindigit=9;
            int maxdigit=0;
            while(temp>0){
                int digit=temp%10;
                mindigit=Math.min(mindigit,digit);
                maxdigit=Math.max(maxdigit,digit);
                temp/=10;
            }
            int range=maxdigit-mindigit;
            if(range>maxrange){
                maxrange=range;
                ans=nums[i];
            } else if(range==maxrange){
                ans+=nums[i];
            }
        }
        return ans;
    }
}