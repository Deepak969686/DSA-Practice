class Solution {
    int[][] dp;
    public int numSquares(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            int root=(int)Math.sqrt(i);
            if(root*root==i) list.add(i);
        }
        dp=new int[list.size()][n+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        return solve(0,list,n);
    }
    int solve(int i,List<Integer>list ,int target){
        if(target==0) return 0;
        if(i==list.size()) return Integer.MAX_VALUE/2;
        if(dp[i][target]!=-1) return dp[i][target];
        int notTake=solve(i+1,list,target);
        int take=Integer.MAX_VALUE/2;
        if (list.get(i) <= target) take=1+solve(i,list,target-list.get(i));
        return dp[i][target]= Math.min(notTake,take);
    }
}