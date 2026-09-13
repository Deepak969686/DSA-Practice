class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int maxlen = 0;
        for(int num : nums){
            maxlen = Math.max(maxlen, num);
        }
        int[] sum = new int[maxlen + 1];
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            sum[num] = num * freq;
        }
        int[] dp = new int[maxlen + 1];
        dp[1] = sum[1];
        for(int i = 2; i <= maxlen; i++){
            dp[i] = Math.max(dp[i-1],sum[i] + dp[i-2]);
        }
        return dp[maxlen];
    }
}