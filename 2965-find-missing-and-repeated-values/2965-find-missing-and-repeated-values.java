class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        Set<Integer> st = new HashSet<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (st.contains(grid[i][j]))
                    ans[0] = grid[i][j];
                st.add(grid[i][j]);
            }
        }
        for (int i = 1; i <=n*n; i++) {
            if (!st.contains(i))
                ans[1]= i;
        }
        return ans;
    }
}