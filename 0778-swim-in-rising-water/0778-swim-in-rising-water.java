class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    int n;
    public int swimInWater(int[][] grid) {
        n = grid.length;
        int l = 0, r = n * n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean[][] vis = new boolean[n][n];
            if (ispossibleToReach(0, 0, grid, mid, vis)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    boolean ispossibleToReach(int r,int c,int[][] grid, int mid,boolean[][] vis) {
        if (grid[r][c] > mid) return false;
        vis[r][c] = true;
        if (r == n - 1 && c == n - 1) return true;
        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nc >= 0 && nr < n && nc < n && !vis[nr][nc] && grid[nr][nc] <= mid) {
                if (ispossibleToReach(nr, nc, grid, mid, vis))
                    return true;
            }
        }
        return false;
    }
}