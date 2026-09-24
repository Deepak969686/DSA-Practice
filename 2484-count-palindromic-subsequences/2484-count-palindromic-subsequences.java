class Solution {
    static final long MOD = 1000000007;
    public int countPalindromes(String s) {
        int n = s.length();
        long[][] left = new long[10][10];
        long[][] right = new long[10][10];
        long[] leftFreq = new long[10];
        long[] freq = new long[10];
        // Build pair counts for the complete string
        // right[a][b] = number of a ... b pairs
        for(int i = n - 1; i >= 0; i--) {
            int x = s.charAt(i) - '0';
            for(int b = 0; b < 10; b++) {
                right[x][b] += freq[b];
            }
            freq[x]++;
        }
        // freq = frequency of all elements initially
        long[] rightFreq = new long[10];
        for(char ch : s.toCharArray()) {
            rightFreq[ch - '0']++;
        }
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int x = s.charAt(i) - '0';
            // Remove current character from right side
            rightFreq[x]--;
            // Remove pairs (x, b) where x is current middle
            for(int b = 0; b < 10; b++) {
                right[x][b] -= rightFreq[b];
            }
            // a b x b a
            for(int a = 0; a < 10; a++) {
                for(int b = 0; b < 10; b++) {
                    ans = (ans + left[a][b] * right[b][a]) % MOD;
                }
            }
            // Add current character to left
            for(int a = 0; a < 10; a++) {
                left[a][x] += leftFreq[a];
            }
            leftFreq[x]++;
        }
        return (int) ans;
    }
}