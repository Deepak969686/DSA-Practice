class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPredecessor(words[i],words[j])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    ans=Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }
    boolean isPredecessor(String curr,String prev){
        int i=0,j=0;
        if(curr.length()<=prev.length() || curr.length()-prev.length()!=1 ) return false;
        while(i<curr.length() && j<prev.length()){
            if(curr.charAt(i)==prev.charAt(j)){
                j++;
                i++;
            } else{
                i++;
            }
        }
        return j==prev.length();
    } 
}