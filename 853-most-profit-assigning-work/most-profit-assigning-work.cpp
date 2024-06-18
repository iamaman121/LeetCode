class Solution {
public:
    static bool comp(pair<int,int> a, pair<int,int> b){
        if(a.first==b.first) return a.second>b.second;
        return a.first>b.first;
    }
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        int n= (int)profit.size();
        vector<pair<int,int>> proDiff(n);
        for(int i=0;i<n;++i){
            proDiff[i]= {profit[i], difficulty[i]};
        }
        sort(proDiff.begin(), proDiff.end(), comp);
        sort(worker.rbegin(), worker.rend());
        int idx= 0, totalProfit= 0;
        for(int i=0;i<(int)worker.size();++i){
            while(idx<n && proDiff[idx].second>worker[i]){
                ++idx;
            }
            if(idx<n) totalProfit+= proDiff[idx].first;
        }
        return totalProfit;
    }
};