class Solution {
    int n;
    int[][] dp;
    public int maxPalindromes(String s, int k) {
        n = s.length();
        if(k==1) return n;
        dp=new int[n+1][n+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        return solve(s, k, 0, k - 1);
    }

    int solve(String s, int k, int i, int j) {
        if (i >= n || j >= n)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];    
        if (isPalindrom(s, i, j)) {
            int take = 1 + solve(s, k, j + 1, j + k);
            int grow = solve(s, k, i, j + 1);
            int slide = solve(s, k, i + 1, j + 1);
            return dp[i][j]= Math.max(take,Math.max( grow, slide));
        }
        int grow = solve(s, k, i, j + 1);
        int slide = solve(s, k, i + 1, j + 1);
        return dp[i][j]= Math.max(grow,slide);
    }
    boolean isPalindrom(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}