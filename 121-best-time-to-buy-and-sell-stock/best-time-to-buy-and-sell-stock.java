class Solution {
    public int maxProfit(int[] prices) {
        int stockMinValue= Integer.MAX_VALUE, maxProfit= 0;
        for(int stockValue : prices){
            maxProfit = Math.max(maxProfit, stockValue-stockMinValue);
            stockMinValue = Math.min(stockMinValue, stockValue);
        }
        return maxProfit;
    }
}