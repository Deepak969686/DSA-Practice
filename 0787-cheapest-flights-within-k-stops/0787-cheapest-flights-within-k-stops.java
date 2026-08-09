class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        // Create graph
        for (int[] e : flights) {
            int u = e[0];
            int v = e[1];
            int p = e[2];
            adj.get(u).add(new int[]{v, p});
        }
        // {city, price, flights}
        PriorityQueue<int[]> pq =new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0});
        // price[city][flights]
        int[][] price = new int[n][k + 2];
        for (int i = 0; i < n; i++)
            Arrays.fill(price[i], Integer.MAX_VALUE);
        price[src][0] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int city = curr[0];
            int pric = curr[1];
            int flightsUsed = curr[2];
            if (city == dst)
                return pric;
            // Already used maximum flights
            if (flightsUsed == k + 1)
                continue;
            for (int[] nbr : adj.get(city)) {
                int nbrCity = nbr[0];
                int nbrPrice = nbr[1];
                int newPrice = pric + nbrPrice;
                int newFlights = flightsUsed + 1;
                if (newPrice < price[nbrCity][newFlights]) {
                    price[nbrCity][newFlights] = newPrice;
                    pq.offer(new int[]{nbrCity, newPrice, newFlights});
                }
            }
        }
        return -1;
    }
}