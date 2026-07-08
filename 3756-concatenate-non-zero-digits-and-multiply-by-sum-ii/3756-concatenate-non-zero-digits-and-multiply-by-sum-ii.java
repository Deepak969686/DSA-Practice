class Solution {
    static final int MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] digitSum = new int[n];
        digitSum[0] = s.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            digitSum[i] = digitSum[i - 1] + (s.charAt(i) - '0');
        }
        long[] numberUpTo = new long[n];
        numberUpTo[0] = s.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit != 0)
                numberUpTo[i] = (numberUpTo[i - 1] * 10 + digit) % MOD;
            else
                numberUpTo[i] = numberUpTo[i - 1];
        }

        int[] nonZero = new int[n];
        nonZero[0] = (s.charAt(0) != '0') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            nonZero[i] = nonZero[i - 1] + ((s.charAt(i) != '0') ? 1 : 0);
        }

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long sum = digitSum[r] - ((l == 0) ? 0 : digitSum[l - 1]);
            int k = nonZero[r] - ((l == 0) ? 0 : nonZero[l - 1]);
            if (k == 0) {
                ans[i] = 0;
                continue;
            }
            long before = (l == 0) ? 0 : numberUpTo[l - 1];
            long x = (numberUpTo[r] - (before * pow10[k]) % MOD + MOD) % MOD;
            ans[i] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }
}