class Solution {
    int[][] dir={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1 ) return -1;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][n];
        vis[0][0]=true;
        q.offer(new int[]{0,0,1});
        while(!q.isEmpty()){     
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int dist=curr[2];
            if(r==n-1 && c==n-1) return dist;
            for(int i=0;i<8;i++){
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr>=0 && nc>=0 && nr<n && nc <n && !vis[nr][nc] && grid[nr][nc]==0){
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc,dist+1});
                }
            }
            
        }
        return -1;
    }
}