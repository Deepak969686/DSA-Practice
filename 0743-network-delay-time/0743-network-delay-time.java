class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : times) {
            int u = e[0];
            int v = e[1];
            int d = e[2];
            adj.get(u).add(new int[] { v, d });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new int[] { k, 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int dis = curr[1];
            for (int[] nbr : adj.get(node)) {
                int nbrnode = nbr[0];
                int nbrdis = nbr[1];
                if (dis + nbrdis < dist[nbrnode]) {
                    dist[nbrnode] = dis + nbrdis;
                    pq.offer(new int[] { nbrnode, dist[nbrnode] });
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}