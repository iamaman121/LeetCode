class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int zero=-1, ans=1, n=(int)nums.size();
        bool prob=false;
        for(int i=0;i<(int)nums.size();++i){
            if(nums[i]==0){
                if(zero==-1){
                    zero=i;
                }
                else{
                    prob=true;
                }
            }
            else ans*=nums[i];
        }
        vector<int> res(n);
        if(prob) {
            
        }
        else if(zero!=-1){
            res[zero]=ans;
        }
        else{
            for(int i=0;i<n;++i) res[i]=ans/nums[i];
        }
        return res;
    }
};