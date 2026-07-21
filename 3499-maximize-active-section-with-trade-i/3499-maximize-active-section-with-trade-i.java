class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        // Count initial active sections
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        // Augment the string
        String t = "1" + s + "1";

        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> lens = new ArrayList<>();

        // Run Length Encoding
        int i = 0;
        while (i < t.length()) {
            char c = t.charAt(i);
            int j = i;
            while (j < t.length() && t.charAt(j) == c) {
                j++;
            }
            chars.add(c);
            lens.add(j - i);
            i = j;
        }

        int ans = ones;

        // Try removing every valid 1-block
        for (i = 1; i < chars.size() - 1; i++) {
            if (chars.get(i) == '1'
                    && chars.get(i - 1) == '0'
                    && chars.get(i + 1) == '0') {

                int candidate = ones + lens.get(i - 1) + lens.get(i + 1);
                ans = Math.max(ans, candidate);
            }
        }

        return Math.min(ans, n);
    }
}