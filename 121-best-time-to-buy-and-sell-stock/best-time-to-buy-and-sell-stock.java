// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        if(n<2) return 0;
        int minPrice= prices[0], maxProfit= 0;
        for(int i=1;i<n;i++){
            maxProfit= Math.max(prices[i]-minPrice, maxProfit);
            minPrice= Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}