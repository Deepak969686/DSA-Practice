class Solution {
    List<List<Integer>> res = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        solve(new ArrayList<>(), nums);
        return res;
    }

    void solve(List<Integer> temp, int[] nums) {
        if (temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {

            if (!set.contains(nums[i])) {

                temp.add(nums[i]);
                set.add(nums[i]);

                solve(temp, nums);

                set.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}