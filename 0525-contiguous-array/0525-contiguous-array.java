class Solution {
    public int findMaxLength(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefix=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i]==1?1:-1;
            if(map.containsKey(prefix)) ans=Math.max(ans,i-map.get(prefix));
            else  map.put(prefix,i);
        }
        return ans;
    }
}