class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] divisiblePairs = new long[max + 1];

        // Count pairs where both numbers are divisible by d
        for (int d = 1; d <= max; d++) {
            long cnt = 0;
            for (int multiple = d; multiple <= max; multiple += d) {
                cnt += freq[multiple];
            }
            divisiblePairs[d] = cnt * (cnt - 1) / 2;
        }

        // exactPairs[d] = pairs having gcd exactly d
        long[] exactPairs = new long[max + 1];

        for (int d = max; d >= 1; d--) {
            exactPairs[d] = divisiblePairs[d];
            for (int multiple = d + d; multiple <= max; multiple += d) {
                exactPairs[d] -= exactPairs[multiple];
            }
        }

        // Prefix counts in sorted gcdPairs
        long[] prefix = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            prefix[d] = prefix[d - 1] + exactPairs[d];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1; // 0-indexed query

            int l = 1, r = max;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (prefix[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }
            ans[i] = l;
        }

        return ans;
    }
}