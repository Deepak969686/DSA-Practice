class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component=new int[n];
        Arrays.fill(component,-1);
        int compID=0;
        component[0]=compID;
        
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]>maxDiff) compID++;
            component[i]=compID;
        } 
        boolean[] ans =new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            if(component[u]==component[v]) ans[i]=true;
            else ans[i]=false;
        }
        return ans;
    }
}