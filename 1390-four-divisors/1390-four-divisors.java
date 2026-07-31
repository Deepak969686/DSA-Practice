class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
       
        int msum=0;
        for(int i=0;i<n;i++){
            int count=0;
            int sum=0;
            int num=nums[i];
            for(int j=1;j<=num;j++){
                if(nums[i]%j==0){
                    count++;
                    sum+=j;
                }
                if(count>4) break;
            }
            if(count==4){
                msum+=sum;
                sum=0;
                count=0;
            }
        }
        return msum;
    }
}