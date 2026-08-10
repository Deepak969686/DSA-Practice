class Solution {
    int n;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        n=s.length();
        dp=new Boolean[n];
        return solve(0,s,wordDict);
    }
    boolean solve(int i,String s,List<String> wordDict){
        if(i==n) return true;
        if(dp[i]!=null) return dp[i];
        for(int j=i+1;j<=n;j++){
            String str=s.substring(i,j);
            if(wordDict.contains(str) && solve(j,s,wordDict)) return dp[i]= true;
        }
        return dp[i]= false;
    }
}