class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n= (int)nums.size(), maxm=1, idx=0;
        sort(nums.begin(), nums.end());
        vector<int> cnt(n,1);
        vector<int> li(n);
        for(int i=0;i<n;++i) li[i]=i;
        for(int i=0;i<n;++i){
            for(int j=0;j<i;++j){
                if(nums[i]%nums[j]==0 && cnt[j]+1>cnt[i]){
                    cnt[i]= 1+cnt[j];
                    li[i]=j;
                    if(cnt[i]>maxm){
                        maxm= cnt[i];
                        idx=i;
                    }
                }
            }
        }
        for(int i=0;i<n;++i) cout<<cnt[i]<<" ";
        cout<<"\n";
        for(int i=0;i<n;++i) cout<<li[i]<<" ";
        vector<int> res;
        while(li[idx]!=idx){
            res.push_back(nums[idx]);
            idx=li[idx];
        }
        res.push_back(nums[idx]);
        return res;
    }
};