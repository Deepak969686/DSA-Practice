class Solution {
    int MOD=1_000_000__007;
    String w1,w2,target;
    Long[][][][] dp;
    public int interleaveCharacters(String word1, String word2, String target) {
        this.w1=word1;
        this.w2=word2;
        this.target=target;
        int n1=word1.length();
        int n2=word2.length();
        dp=new Long[n1+1][n2+1][target.length()+1][4];
        return (int) dfs(-1,-1,0,0);
    }
    private long dfs(int i1,int i2,int idx,int mask){
        if(idx==target.length()){
            return mask==3?1:0;
        }
        if(dp[i1+1][i2+1][idx][mask]!=null) return dp[i1+1][i2+1][idx][mask];
        long ans=0;
        char ch=target.charAt(idx);
        for(int i=i1+1;i<w1.length();i++){
            if(w1.charAt(i)==ch){
                ans=(ans+dfs(i,i2,idx+1,mask|1))%MOD;
            }
        }
        for(int j=i2+1;j<w2.length();j++){
            if(w2.charAt(j)==ch){
                ans=(ans+dfs(i1,j,idx+1,mask|2))%MOD;
            }
        }
        return dp[i1+1][i2+1][idx][mask]=ans;
    }
}