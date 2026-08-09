class Disjoint {
    int[] parent;
    int[] size;

    Disjoint(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    void UnionBySize(int u, int v) {
        int ulp_u = findparent(u);
        int ulp_v = findparent(v);
        if (ulp_u == ulp_v)
            return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }

    int findparent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findparent(parent[node]);
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        Disjoint dsu=new Disjoint(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    dsu.UnionBySize(i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(dsu.findparent(i)==i) count++;
        }
        return count;
    }
}