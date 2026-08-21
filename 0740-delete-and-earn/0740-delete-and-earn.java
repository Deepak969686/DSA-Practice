class Solution {
    int[] sum;
    int[] dp;
    public int deleteAndEarn(int[] nums) {
        int maxlen=0;
        for(int num:nums) maxlen=Math.max(maxlen,num);
        dp=new int[maxlen+1];
        Arrays.fill(dp,-1);
        sum=new int[maxlen+1];
        for (int num : nums) {
            sum[num] += num;
        }
        return solve(0, maxlen);
    }
    int solve(int i,int maxlen){
        if(i>maxlen) return 0;
        if(dp[i]!=-1) return dp[i];
        int skip = solve(i + 1, maxlen);
        int take = sum[i] + solve(i + 2, maxlen);
        return dp[i]= Math.max(take, skip);
    }
}