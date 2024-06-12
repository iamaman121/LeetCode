class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice= prices[0], maxmProfit=0;
        for(int i=1;i<(int)prices.size();++i){
            maxmProfit= max(maxmProfit, prices[i]-minPrice);
            minPrice= min(minPrice, prices[i]);
        }
        return maxmProfit;
    }
};