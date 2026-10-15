
class Solution {
    public int maxVowels(String s, int k) {
        int maxvowel = 0;
        int count = 0;
        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        maxvowel = count;
        // Slide the window
        for (int right = k; right < s.length(); right++) {
            char leftChar = s.charAt(right - k);
            char rightChar = s.charAt(right);
            if (leftChar == 'a'||leftChar == 'e' || leftChar == 'i' || leftChar == 'o' || leftChar == 'u') {
                count--;
            }
            if (rightChar == 'a'||rightChar== 'e'|| rightChar == 'i' || rightChar == 'o'||rightChar == 'u') {
                count++;
            }
            maxvowel = Math.max(maxvowel, count);
        }
        return maxvowel;
    }
}
