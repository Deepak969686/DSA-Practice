class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int profit=Integer.MIN_VALUE;
        for(int x:prices){
            min=Math.min(min,x);
            profit=Math.max(profit,x-min);
        }
        return profit;
    }
}