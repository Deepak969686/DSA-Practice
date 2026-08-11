class Solution {
    List<List<Integer>> res=new ArrayList<>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        n=nums.length;
        solve(nums,new boolean[nums.length],new ArrayList<>());
        return res;
    }
    void solve(int[] nums,boolean[] used,List<Integer> temp){
        if(temp.size()==n){
            res.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=0;i<n;i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            temp.add(nums[i]);
            used[i]=true;
            solve(nums,used,temp);
            used[i]=false;
            temp.remove(temp.size()-1);
        }

    }
}