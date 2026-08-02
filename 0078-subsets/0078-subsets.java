class Solution {
    List<List<Integer>> res=new ArrayList<>();
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        n=nums.length;
        solve(0,nums,new ArrayList<>());
        return res;
    }
    private void solve(int i,int[] nums,List<Integer> temp){
        if(i==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(i+1,nums,temp);
        temp.remove(temp.size()-1);
        solve(i+1,nums,temp);
    }
}