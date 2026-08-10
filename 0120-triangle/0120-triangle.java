class Solution {
    int[][] dp;
    int n;
    public int minimumTotal(List<List<Integer>> triangle) {
        n=triangle.size();
        dp=new int[n][n];
        for(int[] rows:dp) Arrays.fill(rows,Integer.MAX_VALUE);
        return solve(0,0,triangle);
    }
    int solve(int i,int j,List<List<Integer>> triangle){
        if(triangle.size()-1==i) return triangle.get(i).get(j);
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int down=solve(i+1,j,triangle);
        int diagnol=solve(i+1,j+1,triangle);
        return dp[i][j]= triangle.get(i).get(j)+Math.min(down,diagnol); 
    }
}