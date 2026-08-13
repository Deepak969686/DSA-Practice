class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        List<Integer> ans = new ArrayList<>();
        int left = 0;
                    char[] target = p.toCharArray();
            Arrays.sort(target);
        for (int right = k - 1; right < s.length(); right++) {
            String str = s.substring(right - k + 1, right + 1);
            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            if (Arrays.equals(target, ch)) {
                ans.add(right - k + 1);
            }
        }
        return ans;
    }
}