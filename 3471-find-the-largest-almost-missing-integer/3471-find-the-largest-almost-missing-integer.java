class Solution {
    public int largestInteger(int[] nums, int k) {

        int[] count = new int[51];

        // Every subarray of size k
        for (int i = 0; i <= nums.length - k; i++) {

            HashSet<Integer> set = new HashSet<>();

            // Current window
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // Count this window only once for each number
            for (int num : set) {
                count[num]++;
            }
        }

        int ans = -1;

        // Find largest number appearing in exactly one window
        for (int num = 0; num <= 50; num++) {
            if (count[num] == 1) {
                ans = num;
            }
        }

        return ans;
    }
}