class Solution {
    int m, n;
    int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    boolean[][] vis;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    bfs(i, j, grid);
                }
            }
        }
        return count;
    }
    void bfs(int r, int c, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        vis[r][c] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] d : dir) {
                int nr = row + d[0];
                int nc = col + d[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1' && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}