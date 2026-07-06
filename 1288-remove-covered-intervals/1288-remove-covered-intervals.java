class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
            });


        for(int[] interval:intervals){
            //no overlap or first inteval
            if(list.isEmpty() || interval[1]>list.get(list.size()-1)[1]){
                list.add(interval); 
            } 
        }
        return list.size();
    }
}