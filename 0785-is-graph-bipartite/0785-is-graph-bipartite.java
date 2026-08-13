class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int node, int col,int[] color, int[][] graph) {
        color[node] = col;
        for (int nbr : graph[node]) {
            if (color[nbr] == -1) {
                if (!dfs(nbr, 1 - col, color, graph)) {
                    return false;
                }
            }
            else if (color[nbr] == col) {
                return false;
            }
        }
        return true;
    }
}