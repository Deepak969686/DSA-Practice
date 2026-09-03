class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return -1;
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int num : nums) {
            r += num;
            l = Math.max(l, num);
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canSum(nums, mid, k)) {
                r = mid - 1;       
            } else {
                l = mid + 1;       
            }
        }
        return l;
    }
    boolean canSum(int[] nums, int mid, int k) {
        int parts = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num <= mid) {
                sum += num;
            } else {
                parts++;
                sum = num;
            }
            if (parts > k) return false;
        }
        return true;
    }
}