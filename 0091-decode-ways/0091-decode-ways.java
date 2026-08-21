class Solution {
    int n;
    int[] dp;
    public int numDecodings(String s) {
        n=s.length();
        dp=new int[n+1];
        Arrays.fill(dp,-1);
      return solve(0,s);  
    }
    int solve(int i,String s){
        if(i==n) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int singlechar=solve(i+1,s);
        int doublechar=0;
        if(i+1<n){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
                doublechar=solve(i+2,s);
            }
        }
        return dp[i]=singlechar+doublechar;
    }
}