class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for(int i=0;i<n;i++){
            int x=points[i][0];
            int y=points[i][1];
            int dist=x*x+y*y;
            pq.offer(new int[]{x,y,dist});
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            int[] curr=pq.poll();
            ans[i][0]=curr[0];
            ans[i][1]=curr[1];
        }
        return ans;
    }
}