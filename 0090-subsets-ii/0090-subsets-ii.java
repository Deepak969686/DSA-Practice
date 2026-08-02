class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(0, nums, new ArrayList<>());
        return res;
    }
    private void solve(int start, int[] nums, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            solve(i + 1, nums, temp);
            temp.remove(temp.size() - 1);
        }
    }
}