class Solution {
    public int maxProfit(int[] prices) {
        int minPrice= prices[0], maxmProfit=0;
        for(int i=1;i<prices.length;++i){
            maxmProfit= Math.max(maxmProfit, prices[i]-minPrice);
            minPrice= Math.min(minPrice, prices[i]);
        }
        return maxmProfit;
    }
}