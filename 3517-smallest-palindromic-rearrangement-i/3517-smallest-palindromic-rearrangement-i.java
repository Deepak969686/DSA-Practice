class Solution {
    public String smallestPalindrome(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        // Build left half and middle
        for (int i = 0; i < 26; i++) {

            // Add half of the characters to left
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            // Middle character (if odd frequency)
            if (freq[i] % 2 == 1) {
                mid.append((char) ('a' + i));
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        return left.toString() + mid.toString() + right.toString();
    }
}