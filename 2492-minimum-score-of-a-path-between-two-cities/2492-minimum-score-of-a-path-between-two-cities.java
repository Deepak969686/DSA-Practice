class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] e:roads){
            int u=e[0];
            int v=e[1];
            int wt=e[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        int ans=Integer.MAX_VALUE;
        boolean[] vis=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        vis[1]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int[] it:adj.get(node)){
                int adjNode=it[0];
                int weight=it[1];
                ans=Math.min(weight,ans);
                if(!vis[adjNode]){
                    vis[adjNode]=true;
                    q.offer(adjNode);
                }
            }
        }
        return ans;
    }
}