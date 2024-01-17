class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        sort(arr.begin(),arr.end());
        vector<bool> freq(1001,false);
        int cnt=1, prev=arr[0];
        for(int i=1;i<(int)arr.size();++i){
            if(arr[i]!=prev){
                if(freq[cnt]) return false;
                freq[cnt]=true;
                cnt=1;
                prev=arr[i];
            }
            else{
                ++cnt;
            }
        }
        if(freq[cnt]) return false;
        return true;
    }
};