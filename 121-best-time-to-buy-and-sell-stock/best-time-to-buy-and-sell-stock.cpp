class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minm= (int)1e5, maxProfit=0;
        for(int x:prices){
            if(x-minm>maxProfit) maxProfit= x-minm;
            if(x<minm) minm=x;
        }
        return maxProfit;
    }
};