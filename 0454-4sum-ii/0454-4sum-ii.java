class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n=nums1.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum=0;
                sum=nums1[i]+nums2[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int count=0;
        for(int k=0;k<n;k++){
            for(int l=0;l<n;l++){
                int sum=0;
                sum=(nums3[k]+nums4[l]);
                if(map.containsKey(-sum)) count+=map.get(-sum);
            }
        }
        return count;
    }
}