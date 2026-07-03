class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxProfit=0;
        int[] arr=new int[n];
        arr[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            arr[i]=Math.max(prices[i],arr[i+1]);
        }
        for(int i=0;i<n;i++){
            maxProfit=Math.max(maxProfit,arr[i]-prices[i]);
        }
        return maxProfit;
    }
}