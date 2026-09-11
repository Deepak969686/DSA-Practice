class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(i, j, 0, board, word, vis))
                        return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int r, int c, int i, char[][] board, String word, boolean[][] vis) {
        if(i == word.length()) return true;
        if(r < 0 || c < 0 || r >= m || c >= n || vis[r][c] || board[r][c] != word.charAt(i)) return false;
        vis[r][c] = true;
        for(int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if(dfs(nr, nc, i + 1, board, word, vis))
                return true;
        }
        vis[r][c] = false;
        return false;
    }
}