class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        if(n==0) return 0;
        int currMin= prices[0], maximumProfit=0;
        for(int i=1;i<n;i++){
            maximumProfit= Math.max(prices[i]-currMin, maximumProfit);
            currMin= Math.min(currMin, prices[i]);
        }
        return maximumProfit;
    }
}