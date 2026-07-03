class Pair {
    int node, weight;

    Pair(int n, int w) {
        this.node = n;
        this.weight = w;
    }
}

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int ans = -1;
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            if (!online[u] || !online[v])
                continue;
            adj.get(u).add(new Pair(v, wt));
            l = Math.min(l, wt);
            r = Math.max(r, wt);
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mid, n, k, adj)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int mid, int n, long k, ArrayList<ArrayList<Pair>> adj) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE); // for min dist 
        // min heap in dijktra
        PriorityQueue<Pair> pq =new PriorityQueue<>((a,b)->a.weight-b.weight);
        dist[0] = 0;
        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int wtt = curr.weight;
            int nd = curr.node;
            if (wtt > k) return false;
            if (nd == n - 1)return true;
            if(wtt > dist[nd]) continue;
            for (Pair it : adj.get(nd)) {
                int adjNode = it.node;
                long cost = it.weight;
                if (cost < mid)
                    continue;
                if (wtt + cost < dist[adjNode]) {
                    dist[adjNode] = wtt + cost;
                    pq.offer(new Pair(adjNode, (int)dist[adjNode]));
                }
            }
        }
        return false;
    }
}