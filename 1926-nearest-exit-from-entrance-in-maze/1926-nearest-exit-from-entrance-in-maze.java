class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n=maze[0].length;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[m][n];
        q.offer(new int[]{entrance[0],entrance[1],0});
        vis[entrance[0]][entrance[1]] = true;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int steps=curr[2];
            if((r==0 || r==m-1 || c==0 || c==n-1) && (r!=entrance[0] || c!=entrance[1])) return steps;
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && !vis[nr][nc] && maze[nr][nc]=='.'){
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc,steps+1});
                }
            }
        }
        return -1;
    }
}