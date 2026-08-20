class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(mat[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int k = 0; k < m + n - 1; k++) {
            List<Integer> list = map.get(k);
            if (k % 2 == 0) {
                Collections.reverse(list);
            }
            res.addAll(list);
        }
        int[] ans = new int[m * n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}