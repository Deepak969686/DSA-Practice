class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        int count = 1;
        int ans = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == 1) {
                count++;
            } else {
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}