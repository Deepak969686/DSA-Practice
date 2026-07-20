class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(nums.length==0) return 0;
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int curr=1;
        int max=1;
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) == 1) curr++;
            else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }   
        max = Math.max(max, curr);
        return max;
    }
}