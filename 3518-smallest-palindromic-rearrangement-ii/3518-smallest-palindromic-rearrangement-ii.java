class Solution {

    static final long LIMIT = 1000000L;

    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int[] half = new int[26];
        int len = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];
            if ((freq[i] & 1) == 1)
                mid = (char) ('a' + i);
        }

        if (countWays(half) < k)
            return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < len; pos++) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                long ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                }

                k -= ways;
                half[c]++;
            }
        }

        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (mid != 0)
            ans.append(mid);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long countWays(int[] freq) {

        int total = 0;
        for (int x : freq)
            total += x;

        long ans = 1;

        for (int f : freq) {

            if (f == 0)
                continue;

            ans *= nCr(total, f);

            if (ans > LIMIT)
                return LIMIT;

            total -= f;
        }

        return ans;
    }

    private long nCr(int n, int r) {

        if (r > n)
            return 0;

        r = Math.min(r, n - r);

        long res = 1;

        for (int i = 1; i <= r; i++) {

            res = res * (n - r + i) / i;

            if (res > LIMIT)
                return LIMIT;
        }

        return res;
    }
}