class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivoti = -1;

        // Step 1: Find pivot
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivoti = i - 1;
                break;
            }
        }

        // Step 2: Find successor and swap
        if (pivoti != -1) {
            for (int j = n - 1; j > pivoti; j--) {
                if (nums[j] > nums[pivoti]) {
                    swap(nums, j, pivoti);
                    break;
                }
            }
        }

        // Step 3: Reverse suffix
        reverse(nums, pivoti + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}