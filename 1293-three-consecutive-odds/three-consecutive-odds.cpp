class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        int cnt= 0;
        for(int i=0;i<(int)arr.size();++i){
            if(arr[i]%2){
                ++cnt;
                if(cnt==3) return true;
            }
            else{
                cnt= 0;
            }
        }
        return false;
    }
};