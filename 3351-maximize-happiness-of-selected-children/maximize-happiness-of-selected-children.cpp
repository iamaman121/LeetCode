#define ll long long
class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness, int k) {
        ll ans=0;
        int neg=0;
        sort(happiness.rbegin(), happiness.rend());
        for(int i=0;i<min(k,(int)happiness.size());++i){
            ans+=(ll)max(0, happiness[i]-(neg+i));
        }
        return ans;
    }
};