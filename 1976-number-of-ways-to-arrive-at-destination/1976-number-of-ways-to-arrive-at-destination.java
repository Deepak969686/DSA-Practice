class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : roads) {
            int u = e[0];
            int v = e[1];
            int d = e[2];
            adj.get(u).add(new int[]{v, d});
            adj.get(v).add(new int[]{u, d});
        }

        PriorityQueue<long[]> pq =new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        long[] times = new long[n];
        int[] ways = new int[n];
        Arrays.fill(times, Long.MAX_VALUE);
        times[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});
        int MOD = 1000000007;
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long time = curr[1];
            if (time > times[node])
                continue;
            for (int[] nbr : adj.get(node)) {
                int nbrnode = nbr[0];
                long nbrtime = nbr[1];
                long currtime = time + nbrtime;
                if (currtime < times[nbrnode]) {
                    times[nbrnode] = currtime;
                    ways[nbrnode] = ways[node];
                    pq.offer(new long[]{nbrnode, currtime});
                }
                else if (currtime == times[nbrnode]) {
                    ways[nbrnode] = (ways[nbrnode] + ways[node]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}