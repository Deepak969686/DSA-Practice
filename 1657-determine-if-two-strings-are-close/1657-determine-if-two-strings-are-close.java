class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n != m) return false;
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
            set1.add(ch);
        }
        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
            set2.add(ch);
        }
        if (!set1.equals(set2)) return false;
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}
