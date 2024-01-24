class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxm=1, minm=1, ans=INT_MIN;
        for(int i=0; i<(int)nums.size(); ++i){
            int curr=nums[i];
            int tmxm=maxm, tmnm=minm;
            if(curr==0){
                maxm=1, minm=1;
                ans=max(ans,0);
                continue;
            }
            else if(curr>0){
                maxm=max(tmxm*curr, curr);
                minm=min(tmnm*curr, curr);
            }
            else{
                maxm=max(tmnm*curr, curr);
                minm=min(tmxm*curr, curr); 
            }
            ans=max(ans,maxm);
        }
        return ans;
    }
};