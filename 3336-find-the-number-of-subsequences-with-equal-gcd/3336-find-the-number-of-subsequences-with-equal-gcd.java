class Solution {
    int MOD = 1_000_000_007;
    int[][][] dp;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int subsequencePairCount(int[] nums) {

        dp = new int[nums.length][201][201];

        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(nums, 0, 0, 0);
    }

    private int solve(int[] nums, int i, int first, int second) {

        if (i == nums.length) {
            return (first != 0 && second != 0 && first == second) ? 1 : 0;
        }

        if (dp[i][first][second] != -1)
            return dp[i][first][second];

        int skip = solve(nums, i + 1, first, second);

        int take1 = solve(nums, i + 1, gcd(first, nums[i]), second);

        int take2 = solve(nums, i + 1, first, gcd(second, nums[i]));

        return dp[i][first][second] =
                (int) (((long) skip + take1 + take2) % MOD);
    }
}