class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i = k;
        while (set.contains(i)) {
            i += k;
        }
        return i;
    }
}