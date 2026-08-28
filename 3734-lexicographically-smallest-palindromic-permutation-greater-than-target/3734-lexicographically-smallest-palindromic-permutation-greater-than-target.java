class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;

        int oddIdx = -1, oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) { oddCount++; oddIdx = i; }
        }
        if (n % 2 == 0) {
            if (oddCount != 0) return "";
        } else {
            if (oddCount != 1) return "";
        }
        char center = (n % 2 == 1) ? (char) ('a' + oddIdx) : '\0';

        int[] halfPool = new int[26];
        for (int i = 0; i < 26; i++) halfPool[i] = freq[i] / 2;

        int L = n / 2;
        int[] pool = halfPool.clone();
        int m = 0;
        for (int i = 0; i < L; i++) {
            int c = target.charAt(i) - 'a';
            if (pool[c] > 0) { pool[c]--; m++; }
            else break;
        }

        if (m == L) {
            if (n % 2 == 1) {
                int tIdx = target.charAt(L) - 'a';
                if (oddIdx > tIdx) {
                    String half = target.substring(0, L);
                    String tail = new StringBuilder(half).reverse().toString();
                    return half + center + tail;
                } else if (oddIdx == tIdx) {
                    String half = target.substring(0, L);
                    String tailCand = new StringBuilder(half).reverse().toString();
                    if (tailCand.compareTo(target.substring(L + 1)) > 0) {
                        return half + center + tailCand;
                    }
                }
                // else fall through to backtrack
            } else {
                String half = target.substring(0, L);
                String tailCand = new StringBuilder(half).reverse().toString();
                if (tailCand.compareTo(target.substring(L)) > 0) {
                    return half + tailCand;
                }
                // else fall through to backtrack
            }
            if (L == 0) return "";
            pool[target.charAt(L - 1) - 'a']++;
            return backtrack(target, pool, L - 1, center, n);
        } else {
            return backtrack(target, pool, m, center, n);
        }
    }

    private String backtrack(String target, int[] pool, int d, char center, int n) {
        while (d >= 0) {
            int tc = target.charAt(d) - 'a';
            int found = -1;
            for (int c = tc + 1; c < 26; c++) {
                if (pool[c] > 0) { found = c; break; }
            }
            if (found != -1) {
                pool[found]--;
                StringBuilder half = new StringBuilder();
                half.append(target, 0, d);
                half.append((char) ('a' + found));
                for (int c = 0; c < 26; c++) {
                    for (int t = 0; t < pool[c]; t++) half.append((char) ('a' + c));
                }
                String halfStr = half.toString();
                String tail = new StringBuilder(halfStr).reverse().toString();
                return (n % 2 == 1) ? halfStr + center + tail : halfStr + tail;
            }
            if (d == 0) break;
            pool[target.charAt(d - 1) - 'a']++;
            d--;
        }
        return "";
    }
}