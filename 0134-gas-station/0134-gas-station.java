class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas=0;
        int totalcost=0;
        for(int i=0;i<gas.length;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
        }
        if(totalgas<totalcost) return -1;
        int total=0;
        int res=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                res=i+1;
                total=0;
            }
        }
        return res;
    }
}