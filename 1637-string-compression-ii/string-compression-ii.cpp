class Solution {
    int maxm=101;
public:
    int count(string s, int idx, int krem, vector<vector<int>> &cache){
        if(krem<0) return maxm;
        if(idx==(int)s.length() || idx+krem>=(int)s.length()) return 0;
        if(cache[idx][krem]!=maxm) return cache[idx][krem];
        int maxFreq=0;
        vector<int> cnt(26);
        for(int j=idx;j<(int)s.length();++j){
            maxFreq =max(maxFreq,++cnt[s[j]-'a']);
            int temp = count(s, j+1,krem-(j-idx+1-maxFreq), cache);
            cache[idx][krem]=min(cache[idx][krem], getLen(maxFreq) + temp);
        }
        return cache[idx][krem];
    }
    int getLen(int maxFreq) {
        if (maxFreq == 1) {
            return 1; // c
        }
        if (maxFreq < 10) {
            return 2; // [1-9]c
        }
        if (maxFreq < 100) {
            return 3; // [1-9][0-9]c
        }
        return 4; // [1-9][0-9][0-9]c
    }
    int getLengthOfOptimalCompression(string s, int k) {
        vector<vector<int>> cache(s.length(), vector<int>(k+1,maxm));
        return count(s, 0, k, cache);
    }
};