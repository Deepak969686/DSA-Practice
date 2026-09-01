class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        // Give every litter an index
        int[][] id = new int[m][n];
        for (int[] row : id)
            Arrays.fill(row, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = litterCount++;
                }
            }
        }

        // All litter collected
        int fullMask = (1 << litterCount) - 1;

        Queue<int[]> q = new LinkedList<>();

        // {row, col, currentEnergy, mask}
        q.offer(new int[]{sr, sc, energy, 0});

        boolean[][][][] vis =
            new boolean[m][n][energy + 1][1 << litterCount];

        vis[sr][sc][energy][0] = true;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int e = curr[2];
                int mask = curr[3];

                if (mask == fullMask)
                    return moves;

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nc < 0 ||
                        nr >= m || nc >= n)
                        continue;

                    char ch = classroom[nr].charAt(nc);

                    if (ch == 'X')
                        continue;

                    // Moving costs 1 energy
                    if (e == 0)
                        continue;

                    int ne = e - 1;
                    int nmask = mask;

                    // Collect litter
                    if (ch == 'L') {
                        int bit = id[nr][nc];
                        nmask |= (1 << bit);
                    }

                    // Recharge
                    if (ch == 'R') {
                        ne = energy;
                    }

                    if (!vis[nr][nc][ne][nmask]) {

                        vis[nr][nc][ne][nmask] = true;

                        q.offer(new int[]{
                            nr, nc, ne, nmask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}