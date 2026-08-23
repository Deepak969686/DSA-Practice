class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length + 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            boolean[] vis = new boolean[V];
            if (dfs(u, v, vis, adj)) {
                return new int[]{u, v};
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[]{-1, -1};
    }

    boolean dfs(int node, int target,boolean[] vis,ArrayList<ArrayList<Integer>> adj) {
        if (node == target) {
            return true;
        }
        vis[node] = true;
        for (int nbr : adj.get(node)) {
            if (!vis[nbr]) {
                if (dfs(nbr, target, vis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
}