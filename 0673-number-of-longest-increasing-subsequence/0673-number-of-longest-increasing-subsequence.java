class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] len=new int[n];
        Arrays.fill(len,1);
        int[] count=new int[n];
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(len[j]+1>len[i]){
                        len[i]=len[j]+1;
                        count[i]=count[j];
                    } else if(len[j]+1==len[i]){
                        count[i]+=count[j];
                    }
                }
            }
        }
        int maxlen=1;
        for(int i=0;i<n;i++){
            maxlen=Math.max(maxlen,len[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
           if(len[i]==maxlen){
            ans+=count[i];
           }
        }
        return ans;
    }
}