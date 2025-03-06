class Solution {
    public int maxProfit(int[] prices) {
        int profitMaxm=0, minPrice=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>minPrice){
                profitMaxm= Math.max(profitMaxm, prices[i]-minPrice);
            }
            else{
                minPrice= prices[i];
            }
        }
        return profitMaxm;
    }
}