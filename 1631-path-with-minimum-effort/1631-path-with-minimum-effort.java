class Solution {
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        int[][] effort=new int[m][n];
        for(int[] rows:effort) Arrays.fill(rows,Integer.MAX_VALUE);
        effort[0][0]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int r=curr[0];
            int c=curr[1];
            int curreffort=curr[2];
            if(r==m-1 && c==n-1) return curreffort;
            for(int i=0;i<4;i++){
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr>=0 && nc>=0 && nr<m && nc<n ){
                    int diff=Math.abs(heights[nr][nc]-heights[r][c]);
                    int neweffort=Math.max(curreffort,diff);
                    if(neweffort<effort[nr][nc]){
                        effort[nr][nc]=neweffort;
                        pq.offer(new int[]{nr,nc,effort[nr][nc]});
                    }
                }
            }
        }
        return 0;
    }
}