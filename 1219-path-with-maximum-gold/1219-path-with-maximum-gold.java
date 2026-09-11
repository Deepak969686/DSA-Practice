class Solution {
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    int m,n;
    int maxgold=0;
    public int getMaximumGold(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    maxgold=Math.max(maxgold,dfs(i,j,grid,vis));
                }
            }
        }
        return maxgold;
    }
    int dfs(int r,int c,int[][] grid,boolean[][] vis){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]==0 || vis[r][c]) return 0;
        vis[r][c]=true;
        int currgold=grid[r][c];
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            currgold=Math.max(currgold,grid[r][c]+dfs(nr,nc,grid,vis));
        }
        vis[r][c]=false;
        return currgold;
    }
}