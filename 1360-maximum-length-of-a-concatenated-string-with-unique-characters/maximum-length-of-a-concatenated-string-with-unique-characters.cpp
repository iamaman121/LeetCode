class Solution {
public:
    int helper(vector<int> &bitArr, int i, int n, int curr){
        if(i==n) return __builtin_popcount(curr);
        int ans=helper(bitArr, i+1, n, curr);
        if((curr & bitArr[i])==0){
            ans=max(ans, helper(bitArr, i+1, n, curr|bitArr[i]));
        }
        return ans;
    }
    int maxLength(vector<string>& arr) {
        int n= (int)arr.size(), num=0;
        vector<int> bitArr;
        for(int i=0;i<n;++i){
            num=0;
            for(char ch:arr[i]){
                if(num & 1<<(ch-'a')){
                    num=0;
                    break;
                }
                else num|=1<<(ch-'a');
            }
            if(num>0) bitArr.push_back(num);
        }
        return helper(bitArr, 0, (int)bitArr.size(), 0);
    }
};