class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        solve(0, nums);
        return res;
    }

    void solve(int idx, int[] nums) {
        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);
            res.add(temp);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            solve(idx + 1, nums);
            swap(nums, i, idx);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}