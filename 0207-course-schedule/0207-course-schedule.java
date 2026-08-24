class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e:prerequisites){
            int u=e[0];
            int v=e[1];
            adj.get(v).add(u);
        }
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        int[] topo=new int[n];
        int i=0;
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topo[i++]=node;
            count++;
            for(int nbr:adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }
        if(count==numCourses) return true;
        return  false;
    }
}