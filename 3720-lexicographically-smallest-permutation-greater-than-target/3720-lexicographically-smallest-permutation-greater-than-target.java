class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        int m = 0;
        for (int i = 0; i < n; i++) {
            int c = target.charAt(i) - 'a';
            if (cnt[c] > 0) {
                cnt[c]--;
                m++;
            } else break;
        }

        int k;
        if (m == n) {
            // entire string matched target exactly; back off one position
            cnt[target.charAt(n - 1) - 'a']++;
            k = n - 1;
        } else {
            k = m;
        }

        while (k >= 0) {
            int tc = target.charAt(k) - 'a';
            int found = -1;
            for (int c = tc + 1; c < 26; c++) {
                if (cnt[c] > 0) { found = c; break; }
            }
            if (found != -1) {
                cnt[found]--;
                StringBuilder sb = new StringBuilder();
                sb.append(target, 0, k);
                sb.append((char) ('a' + found));
                for (int c = 0; c < 26; c++) {
                    for (int t = 0; t < cnt[c]; t++) sb.append((char) ('a' + c));
                }
                return sb.toString();
            }
            if (k == 0) break;
            cnt[target.charAt(k - 1) - 'a']++;
            k--;
        }
        return "";
    }
}