class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;

        Set<Integer> st = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int x : nums) {
            st.add(x);
        }

        for(int i = 1; i <= n; i++) {
            if(!st.contains(i))
                ans.add(i);
        }

        return ans;
    }
}