class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex])
                minIndex = i;

            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        int option1 = right + 1;              // both from left
        int option2 = n - left;               // both from right
        int option3 = left + 1 + n - right;   // one from each side

        return Math.min(option1, Math.min(option2, option3));
    }
}