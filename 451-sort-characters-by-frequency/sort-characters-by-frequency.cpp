
class Solution {
public:
    string frequencySort(string s) {
        vector<pair<int,int>> cnt(256);
        for(int i=0;i<256;++i) cnt[i].second=i;
        for(char ch:s){
            cnt[ch].first++;
        }
        sort(cnt.rbegin(), cnt.rend());
        s="";
        for(int i=0;i<256;++i){
            if(cnt[i].first==0) break;
            s+=string(cnt[i].first,cnt[i].second);
        }
        return s;
    }
};