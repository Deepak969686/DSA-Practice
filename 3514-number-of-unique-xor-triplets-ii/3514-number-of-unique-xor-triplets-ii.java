class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048; // Since nums[i] <= 1500, XOR values are < 2048

        boolean[] pairXor = new boolean[MAX];
        boolean[] result = new boolean[MAX];

        int n = nums.length;

        // Compute all possible pair XORs (i <= j)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        // Compute triplet XORs
        for (int xor = 0; xor < MAX; xor++) {
            if (pairXor[xor]) {
                for (int num : nums) {
                    result[xor ^ num] = true;
                }
            }
        }

        // Count unique XOR values
        int count = 0;
        for (boolean val : result) {
            if (val) count++;
        }

        return count;
    }
}