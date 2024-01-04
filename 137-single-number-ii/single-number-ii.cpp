class Solution {
public:
    int singleNumber(vector<int>& arr) {
        int n=(int) arr.size();
        vector<int> bitt(32);
        for(int i=0;i<n;++i){
            for(int j=0;j<32;++j){
                if((1<<j)&arr[i]) bitt[j]++;
            }
        }
        int ans=0;
        for(int j=0;j<32;++j){
            bitt[j]%=3;
            if(bitt[j]) ans+=(1<<j);
        }
        return ans;
    }
};