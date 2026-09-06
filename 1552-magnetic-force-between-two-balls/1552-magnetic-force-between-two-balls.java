class Solution {
    public int maxDistance(int[] position, int m) {
        int n=position.length;
        Arrays.sort(position);
        // l-> minforce , r-> maxforce
        int l=1;
        int r=position[n-1]-position[0];
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canPlace(position,mid,m)){
                l=mid+1;
            } else{
                r=mid-1;
            }
        }
        return r;
    }
    boolean canPlace(int[] position,int mid,int m){
        int prev=position[0];
        int countball=1;
        for(int i=1;i<position.length;i++){
            int curr=position[i];
            if(curr-prev>=mid){
                countball++;
                prev=curr;
            }
            if(countball==m) return true;
        }
        return false;
    }
}