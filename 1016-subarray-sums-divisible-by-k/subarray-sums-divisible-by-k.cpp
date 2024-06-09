class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int n= (int)nums.size(), csum=0, ans=0;
        unordered_map<int,int> ump;
        ump[csum]=1;
        for(int i=0;i<n;++i){
            csum+= nums[i];
            while(csum<0) csum+=k;
            csum%=k;
            if(ump.find(csum)!=ump.end()){
                ans+=ump[csum];
            }
            ump[csum]++;
        }
        return ans;
    }
};